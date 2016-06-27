package com.wow.user.service.impl;

import com.wow.user.model.EndUserLoginLog;
import com.wow.user.model.EndUserSession;
import com.wow.user.service.LoginService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhengzhiqing on 16/6/16.
 */
@Service
@Transactional(value = "userTransactionManager")
public class LoginServiceImpl implements LoginService {

    //table: end_user_login_log

    /**
     * 用户登录
     *
     * @param userName
     * @param password
     * @return
     */
    public EndUserSession login(String userName, String password) {
        return null;
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
