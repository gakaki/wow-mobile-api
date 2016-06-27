package com.wow.user.service;

import com.wow.user.model.EndUserLoginLog;
import com.wow.user.model.EndUserSession;
import com.wow.user.vo.LoginRequest;
import com.wow.user.vo.LoginResult;

import java.util.List;

/**
 * Created by zhengzhiqing on 16/6/16.
 */
public interface LoginService {
    //table: end_user_login_log

    /**
     * 用户登录
     *
     * @param loginRequest
     * @return
     */
    LoginResult login(LoginRequest loginRequest);

    /**
     * 延续会话
     *
     * @param token
     * @return
     */
    EndUserSession refreshSession(String token);

    /**
     * 添加用户登录日志
     *
     * @param endUserLoginLog
     * @return
     */
    int createLoginLog(EndUserLoginLog endUserLoginLog);

    /**
     * 查询用户登录日志
     *
     * @param endUserId
     * @return
     */
    List<EndUserLoginLog> getLoginLogsByUserId(int endUserId);

    /**
     * 用户登出
     *
     * @param endUserId
     * @return
     */
    EndUserSession logout(int endUserId);

}
