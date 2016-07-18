package com.wow.user.service;

import com.wow.common.response.CommonResponse;
import com.wow.user.model.EndUserSession;
import com.wow.user.vo.LoginVo;
import com.wow.user.vo.ThirdPartyLoginVo;
import com.wow.user.vo.response.LoginResponse;
import com.wow.user.vo.response.LogoutResponse;
import com.wow.user.vo.response.TokenValidateResponse;

/**
 * Created by zhengzhiqing on 16/6/16.
 */
public interface SessionService {

    /**
     * 用户登录
     *
     * @param loginVo
     * @return
     */
    LoginResponse login(LoginVo loginVo);

    /**
     * 第三方登录
     * @param thirdPartyLoginVo
     * @return
     */
    LoginResponse thirdPartyLogin(ThirdPartyLoginVo thirdPartyLoginVo);

    /**
     * 用户登出
     *
     * @param endUserId
     * @return
     */
    LogoutResponse logout(int endUserId, byte loginChannel);

    /**
     * 判断是否有效session
     * @param sessionToken
     * @param loginChannel
     * @return
     */
    TokenValidateResponse isValidSessionToken(String sessionToken, byte loginChannel);

    /**
     * 使会话失效 - 常用在修改密码之后
     * @param endUserId
     * @return
     */
    CommonResponse invalidateSessionToken(int endUserId);

}
