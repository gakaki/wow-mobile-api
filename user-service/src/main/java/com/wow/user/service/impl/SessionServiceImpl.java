package com.wow.user.service.impl;

import com.wow.user.mapper.EndUserLoginLogMapper;
import com.wow.user.mapper.EndUserMapper;
import com.wow.user.mapper.EndUserSessionMapper;
import com.wow.user.model.EndUser;
import com.wow.user.model.EndUserLoginLog;
import com.wow.user.model.EndUserSession;
import com.wow.user.service.SessionService;
import com.wow.user.service.UserService;
import com.wow.user.util.IpConvertUtil;
import com.wow.user.vo.LoginRequest;
import com.wow.user.vo.LoginResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

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
     * @param loginRequest
     * @return
     */
    public LoginResult login(LoginRequest loginRequest) {
        LoginResult loginResult = new LoginResult();
        EndUserSession endUserSession = null;
        //先检查数据库,看用户名和密码是否匹配
        EndUser endUser = userService.authenticate(loginRequest.getUserName(), loginRequest.getPassword());
        if (endUser != null) { //验证成功
            //根据userId和channel查找EndUserSession,如果有则更新,没有则创建
            endUserSession = endUserSessionMapper.selectByUserIdChannel(endUser.getId(), loginRequest.getLoginChannel());
            long loginIp = IpConvertUtil.ipToLong(loginRequest.getLoginIp());
            Date now = new Date();
            logger.info("start to login at:" + now);
            //token生成算法,暂用UUID,可以替换
            String sessionToken = UUID.randomUUID().toString();
            if (endUserSession == null) {
                endUserSession = new EndUserSession();
                endUserSession.setEndUserId(endUser.getId());
                endUserSession.setIsLogout(false);
                endUserSession.setLastLoginIp(loginIp);
                endUserSession.setLastRefreshTime(now);
                endUserSession.setLastLoginTime(now);
                endUserSession.setLoginChannel(loginRequest.getLoginChannel());
                endUserSession.setLogoutTime(null);
                endUserSession.setSessionToken(sessionToken);
                endUserSession.setUserAgentInfo(loginRequest.getUserAgent());
                endUserSessionMapper.insert(endUserSession);
            } else {
                endUserSession.setIsLogout(false);
                endUserSession.setLastLoginIp(loginIp);
                endUserSession.setLastRefreshTime(now);
                endUserSession.setLastLoginTime(now);
                endUserSession.setLoginChannel(loginRequest.getLoginChannel());
                endUserSession.setLogoutTime(null);
                endUserSession.setSessionToken(sessionToken);
                endUserSession.setUserAgentInfo(loginRequest.getUserAgent());
                endUserSessionMapper.updateByPrimaryKey(endUserSession);
            }

            //记录登录日志
            EndUserLoginLog endUserLoginLog = new EndUserLoginLog();
            endUserLoginLog.setUserAgentInfo(loginRequest.getUserAgent());
            endUserLoginLog.setLoginChannel(loginRequest.getLoginChannel());
            endUserLoginLog.setEndUserId(endUser.getId());
            endUserLoginLog.setLoginIp(loginIp);
            endUserLoginLog.setLoginTime(now);
            endUserLoginLog.setSessionToken(sessionToken);
            endUserLoginLogMapper.insert(endUserLoginLog);

            loginResult.setUserName(loginRequest.getUserName());
            loginResult.setValidUser(true);
            loginResult.setErrorMsg(null);
            loginResult.setEndUserSession(endUserSession);
        } else {
            loginResult.setUserName(loginRequest.getUserName());
            loginResult.setValidUser(false);
            loginResult.setErrorMsg("用户名和密码不匹配,请重新输入");
            loginResult.setEndUserSession(null);
        }
        return loginResult;
    }


    /**
     * 根据userId和登录渠道查询会话
     *
     * @param userId
     * @param loginChannel
     * @return
     */
    public EndUserSession getSessionByUserIdAndChannel (int userId, byte loginChannel) {
        return endUserSessionMapper.selectByUserId(userId, loginChannel);
    }

    /**
     * 延续会话
     *
     * @param userId
     * @param loginChannel
     * @return
     */
    private int refreshSession(int userId, byte loginChannel) {
        return endUserSessionMapper.updateRefreshTime(userId,loginChannel);
    }

    /**
     * 查询用户登录日志
     *
     * @param endUserId
     * @return
     */
    public List<EndUserLoginLog> getLoginLogsByUserId(int endUserId) {
        return null;
    }

    /**
     * 用户登出
     *
     * @param endUserId
     * @return
     */
    public int logout(int endUserId,byte loginChannel) {
        EndUserSession endUserSession = new EndUserSession();
        endUserSession.setEndUserId(endUserId);
        endUserSession.setIsLogout(true);
        endUserSession.setLogoutTime(new Date());
        return endUserSessionMapper.updateLogout(endUserId, loginChannel);
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
        EndUserSession endUserSession = endUserSessionMapper.selectValidSession(sessionToken, loginChannel, mustRefreshAfter);
        logger.info("endUserSession:" + endUserSession);
        if (endUserSession != null && endUserSession.getId() != null) {
            isValid = true;
            //刷新过期时间,不是每次都刷新,仅仅在当前时间与上次刷新时间之间间隔 < 过期时间的25%处刷新
            if (currentTime - endUserSession.getLastRefreshTime().getTime() < sessionExpirationTime*0.25) {
                refreshSession(endUserSession.getEndUserId(),endUserSession.getLoginChannel());
            }
        }
        return isValid;
    }

}
