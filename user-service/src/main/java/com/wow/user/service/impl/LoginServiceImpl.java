package com.wow.user.service.impl;

import com.wow.user.mapper.EndUserLoginLogMapper;
import com.wow.user.mapper.EndUserMapper;
import com.wow.user.mapper.EndUserSessionMapper;
import com.wow.user.model.EndUser;
import com.wow.user.model.EndUserLoginLog;
import com.wow.user.model.EndUserSession;
import com.wow.user.service.LoginService;
import com.wow.user.service.UserService;
import com.wow.user.util.IpConvertUtil;
import com.wow.user.vo.LoginRequest;
import com.wow.user.vo.LoginResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
public class LoginServiceImpl implements LoginService {

    private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private EndUserMapper endUserMapper;

    @Autowired
    EndUserSessionMapper endUserSessionMapper;

    @Autowired
    EndUserLoginLogMapper endUserLoginLogMapper;

    @Autowired
    private UserService userService;

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
            String sessionToken = UUID.randomUUID().toString();
            if (endUserSession == null) {
                endUserSession = new EndUserSession();
                endUserSession.setEndUserId(endUser.getId());
                endUserSession.setIsActive(true);
                endUserSession.setIsExpired(false);
                endUserSession.setLastLoginIp(loginIp);
                endUserSession.setLastRefreshTime(now);
                endUserSession.setLastLoginTime(now);
                endUserSession.setLoginChannel(loginRequest.getLoginChannel());
                endUserSession.setLogoutTime(null);
                endUserSession.setSessionToken(sessionToken);
                endUserSession.setUserAgentInfo(loginRequest.getUserAgent());
                createSession(endUserSession);
            } else {
                endUserSession.setIsActive(true);
                endUserSession.setIsExpired(false);
                endUserSession.setLastLoginIp(loginIp);
                endUserSession.setLastRefreshTime(now);
                endUserSession.setLastLoginTime(now);
                endUserSession.setLoginChannel(loginRequest.getLoginChannel());
                endUserSession.setLogoutTime(null);
                endUserSession.setSessionToken(sessionToken);
                endUserSession.setUserAgentInfo(loginRequest.getUserAgent());
                updateSession(endUserSession);
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

    public int createSession(EndUserSession endUserSession) {
        return endUserSessionMapper.insert(endUserSession);
    }

    public int updateSession(EndUserSession endUserSession) {
        return endUserSessionMapper.updateByPrimaryKey(endUserSession);
    }

    /**
     * 创建会话
     *
     * @param userId
     * @return
     */
    public EndUserSession getSessionByUserId(int userId) {
        return endUserSessionMapper.selectByUserId(userId);
    }

    /**
     * 延续会话
     *
     * @param token
     * @return
     */
    public EndUserSession refreshSession(String token) {
        return null;
    }

    /**
     * 添加用户登录日志
     *
     * @param endUserLoginLog
     * @return
     */
    public int createLoginLog(EndUserLoginLog endUserLoginLog) {
        return 0;
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
    public EndUserSession logout(int endUserId) {
        return null;
    }

}
