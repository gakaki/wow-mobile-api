package com.wow.user.service;

import com.wow.common.response.CommonResponse;

/**
 * Created by zhengzhiqing on 16/7/17.
 */
public interface CaptchaService {
    /**
     * 获取验证码
     * @param mobile
     * @return 验证码
     */
    CommonResponse sendCaptcha(String mobile, int templateType, long expirationTime);
}
