package com.wow.user.service.impl;

import com.wow.user.mapper.EndUserLoginLogMapper;
import com.wow.user.mapper.EndUserMapper;
import com.wow.user.mapper.EndUserSessionMapper;
import com.wow.user.model.EndUser;
import com.wow.user.model.EndUserLoginLog;
import com.wow.user.model.EndUserLoginLogExample;
import com.wow.user.model.EndUserSession;
import com.wow.user.model.EndUserSessionExample;
import com.wow.user.service.SessionService;
import com.wow.user.service.UserService;
import com.wow.user.util.IpConvertUtil;
import com.wow.user.vo.LoginRequestVo;
import com.wow.user.vo.LoginResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

/**
 * Created by zhengzhiqing on 16/6/16.
 */
@Service
@Transactional(value = "userTransactionManager")
public class SessionServiceImpl implements SessionService {

    private static final Logger logger = LoggerFactory.getLogger(SessionServiceImpl.class);

    @Autowired
    private EndUserMapper endUserMapper;

    @Autowired
    private EndUserSessionMapper endUserSessionMapper;

    @Autowired
    private EndUserLoginLogMapper endUserLoginLogMapper;

    @Autowired
    private UserService userService;

    @Value("${session.expirationTime}")
    private long sessionExpirationTime;

    /**
     * 用户登录
     *
     * @param loginRequestVo
     * @return
     */
    public LoginResultVo login(LoginRequestVo loginRequestVo) {
        LoginResultVo loginResultVo = new LoginResultVo();
        EndUserSession endUserSession = null;
        //先检查数据库,看用户名和密码是否匹配
        EndUser endUser = userService.authenticate(loginRequestVo.getUserName(), loginRequestVo.getPassword());
        if (endUser != null) { //验证成功
            //根据userId和channel查找EndUserSession,如果有则更新,没有则创建
            endUserSession = getSessionByUserIdAndChannel(endUser.getId(), loginRequestVo.getLoginChannel());
            long loginIp = IpConvertUtil.ipToLong(loginRequestVo.getLoginIp());
            Date now = new Date();
            //token生成算法,暂用UUID,可以替换
            String sessionToken = UUID.randomUUID().toString();
            if (endUserSession == null) {
                endUserSession = new EndUserSession();
                endUserSession.setEndUserId(endUser.getId());
                endUserSession.setIsLogout(false);
                endUserSession.setLastLoginIp(loginIp);
                endUserSession.setLastRefreshTime(now);
                endUserSession.setLastLoginTime(now);
                endUserSession.setLoginChannel(loginRequestVo.getLoginChannel());
                endUserSession.setLogoutTime(null);
                endUserSession.setSessionToken(sessionToken);
                endUserSession.setUserAgentInfo(loginRequestVo.getUserAgent());
                endUserSessionMapper.insertSelective(endUserSession);
            } else {
                endUserSession.setIsLogout(false);
                endUserSession.setLastLoginIp(loginIp);
                endUserSession.setLastRefreshTime(now);
                endUserSession.setLastLoginTime(now);
                endUserSession.setLoginChannel(loginRequestVo.getLoginChannel());
                endUserSession.setLogoutTime(null);
                endUserSession.setSessionToken(sessionToken);
                endUserSession.setUserAgentInfo(loginRequestVo.getUserAgent());
                //此处不用updateByPrimaryKeySelective,因为setLogoutTime(null)
                endUserSessionMapper.updateByPrimaryKey(endUserSession);
            }

            //记录登录日志
            EndUserLoginLog endUserLoginLog = new EndUserLoginLog();
            endUserLoginLog.setUserAgentInfo(loginRequestVo.getUserAgent());
            endUserLoginLog.setLoginChannel(loginRequestVo.getLoginChannel());
            endUserLoginLog.setEndUserId(endUser.getId());
            endUserLoginLog.setLoginIp(loginIp);
            endUserLoginLog.setLoginTime(now);
            endUserLoginLog.setSessionToken(sessionToken);
            endUserLoginLogMapper.insert(endUserLoginLog);

            loginResultVo.setUserName(loginRequestVo.getUserName());
            loginResultVo.setValidUser(true);
            loginResultVo.setErrorMsg(null);
            loginResultVo.setEndUserSession(endUserSession);
        } else {
            loginResultVo.setUserName(loginRequestVo.getUserName());
            loginResultVo.setValidUser(false);
            loginResultVo.setErrorMsg("用户名和密码不匹配,请重新输入");
            loginResultVo.setEndUserSession(null);
        }
        return loginResultVo;
    }


    /**
     * 根据userId和登录渠道查询会话
     *
     * @param userId
     * @param loginChannel
     * @return
     */
    @Transactional(propagation= Propagation.SUPPORTS)
    public EndUserSession getSessionByUserIdAndChannel (int userId, byte loginChannel) {
        EndUserSession endUserSession = null;
        EndUserSessionExample endUserSessionExample = new EndUserSessionExample();
        EndUserSessionExample.Criteria criteria = endUserSessionExample.createCriteria();
        criteria.andEndUserIdEqualTo(userId);
        criteria.andLoginChannelEqualTo(loginChannel);
        List<EndUserSession> endUserSessions = endUserSessionMapper.selectByExample(endUserSessionExample);
        if (endUserSessions != null && endUserSessions.size()==1) {
            endUserSession = endUserSessions.get(0);
        } else if (endUserSessions.size() > 1) {
            //异常,不应该有多条记录
        }
        return endUserSession;
    }

    /**
     * 延续会话过期时间
     *
     * @param endUserSession
     * @return
     */
    private int refreshSession(EndUserSession endUserSession) {
        EndUserSessionExample endUserSessionExample = new EndUserSessionExample();
        EndUserSessionExample.Criteria criteria = endUserSessionExample.createCriteria();
        criteria.andEndUserIdEqualTo(endUserSession.getEndUserId());
        criteria.andLoginChannelEqualTo(endUserSession.getLoginChannel());
        criteria.andIsLogoutEqualTo(false);
        criteria.andIsActiveEqualTo(true);
        endUserSession.setLastRefreshTime(new Date());
        return endUserSessionMapper.updateByExampleSelective(endUserSession, endUserSessionExample);
    }

    /**
     * 查询用户登录日志
     *
     * @param endUserId
     * @return
     */
    @Transactional(propagation= Propagation.SUPPORTS)
    public List<EndUserLoginLog> getLoginLogsByUserId(int endUserId) {
        EndUserLoginLogExample endUserLoginLogExample = new EndUserLoginLogExample();
        EndUserLoginLogExample.Criteria criteria = endUserLoginLogExample.createCriteria();
        criteria.andEndUserIdEqualTo(endUserId);
        return endUserLoginLogMapper.selectByExample(endUserLoginLogExample);
    }

    /**
     * 用户登出
     *
     * @param endUserId
     * @return
     */
    public int logout(int endUserId,byte loginChannel) {
        EndUserSession endUserSession = new EndUserSession();
        endUserSession.setIsLogout(true);
        endUserSession.setLogoutTime(new Date());
        EndUserSessionExample endUserSessionExample = new EndUserSessionExample();
        EndUserSessionExample.Criteria criteria = endUserSessionExample.createCriteria();
        criteria.andEndUserIdEqualTo(endUserId);
        criteria.andLoginChannelEqualTo(loginChannel);
        return endUserSessionMapper.updateByExampleSelective(endUserSession, endUserSessionExample);
    }

    /**
     * 判断是否有效session
     *
     * @param sessionToken
     * @param loginChannel
     * @return
     */
    @Override
    public boolean isValidSessionToken(String sessionToken, byte loginChannel) {
        logger.info("check whether is valid session token:" + sessionToken + ", loginChannel:" + loginChannel);
        boolean isValid = false;
        long currentTime = System.currentTimeMillis();
        Date mustRefreshAfter = new Date(currentTime - sessionExpirationTime);
        EndUserSession endUserSession = getValidUserSessionBySessionToken(
                sessionToken, loginChannel, mustRefreshAfter);
        logger.info("endUserSession:" + endUserSession);
        if (endUserSession != null && endUserSession.getId() != null) {
            isValid = true;
            //刷新过期时间,不是每次都刷新,仅仅在当前时间与上次刷新时间之间间隔 < 过期时间的25%处刷新
            if (currentTime - endUserSession.getLastRefreshTime().getTime() < sessionExpirationTime*0.25) {
                refreshSession(endUserSession);
            }
        }
        return isValid;
    }

    /**
     * 根据会话token查找当前有效的会话信息
     * @param sessionToken
     * @param loginChannel
     * @param mustRefreshAfter
     * @return
     */
    private EndUserSession getValidUserSessionBySessionToken(
            String sessionToken, byte loginChannel, Date mustRefreshAfter) {
        EndUserSession endUserSession = null;
        EndUserSessionExample endUserSessionExample = new EndUserSessionExample();
        EndUserSessionExample.Criteria criteria = endUserSessionExample.createCriteria();
        criteria.andSessionTokenEqualTo(sessionToken);
        criteria.andLoginChannelEqualTo(loginChannel);
        criteria.andIsLogoutEqualTo(false);
        criteria.andIsActiveEqualTo(true);
        criteria.andLastRefreshTimeGreaterThan(mustRefreshAfter);

        List<EndUserSession> endUserSessions = endUserSessionMapper.selectByExample(endUserSessionExample);

        if (endUserSessions != null && endUserSessions.size()==1) {
            endUserSession = endUserSessions.get(0);
        } else if (endUserSessions.size() > 1) {
            //异常,不应该有多条记录
        }
        return endUserSession;

    }

    /**
     * 使会话失效 - 常用在修改密码之后
     *
     * @param endUserId
     * @return
     */
    @Override
    public int invalidateSessionToken(int endUserId) {
        EndUserSessionExample endUserSessionExample = new EndUserSessionExample();
        EndUserSessionExample.Criteria criteria=endUserSessionExample.createCriteria();
        criteria.andIdEqualTo(endUserId);
        List<EndUserSession> endUserSessions=getAllActiveUserSession(endUserId);
        for (EndUserSession endUserSession : endUserSessions) {
            endUserSession.setIsActive(false);
            endUserSessionMapper.updateByExampleSelective(endUserSession, endUserSessionExample);
        }
        return endUserSessions.size();
    }

    /**
     * 获取所有有效的会话
     * @param endUserId
     * @return
     */
    private List<EndUserSession> getAllActiveUserSession(int endUserId) {
        EndUserSessionExample endUserSessionExample = new EndUserSessionExample();
        EndUserSessionExample.Criteria criteria = endUserSessionExample.createCriteria();
        criteria.andIdEqualTo(endUserId);
        criteria.andIsLogoutEqualTo(false);
        criteria.andIsActiveEqualTo(true);
        return endUserSessionMapper.selectByExample(endUserSessionExample);
    }
}
