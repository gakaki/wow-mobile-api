package com.wow.user.service;

import com.wow.user.model.EndUserLoginLog;
import com.wow.user.model.EndUserSession;
import com.wow.user.vo.LoginRequestVo;
import com.wow.user.vo.LoginResultVo;

import java.util.List;

/**
 * Created by zhengzhiqing on 16/6/16.
 */
public interface SessionService {

    /**
     * 用户登录
     *
     * @param loginRequest
     * @return
     */
    LoginResultVo login(LoginRequestVo loginRequest);

    /**
     * 根据userId和登录渠道查询会话
     *
     * @param userId
     * @param loginChannel
     * @return
     */
    EndUserSession getSessionByUserIdAndChannel(int userId, byte loginChannel);

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
    int logout(int endUserId, byte loginChannel);

    /**
     * 判断是否有效session
     * @param sessionToken
     * @param loginChannel
     * @return
     */
    boolean isValidSessionToken(String sessionToken, byte loginChannel);

    /**
     * 使会话失效 - 常用在修改密码之后
     * @param endUserId
     * @return
     */
    int invalidateSessionToken(int endUserId);

}
