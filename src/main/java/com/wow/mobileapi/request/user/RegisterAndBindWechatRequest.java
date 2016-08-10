package com.wow.mobileapi.request.user;

import com.wow.common.request.ApiRequest;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by zhengzhiqing on 16/7/6.
 */
public class RegisterAndBindWechatRequest extends ApiRequest {

    private static final long serialVersionUID = 1L;

    @NotBlank
    private String captcha;
    @NotBlank
    private String mobile;
    @NotBlank
    private String password;

    private UserInfoFromWechat userInfoFromWechat;

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserInfoFromWechat getUserInfoFromWechat() {
        return userInfoFromWechat;
    }

    public void setUserInfoFromWechat(UserInfoFromWechat userInfoFromWechat) {
        this.userInfoFromWechat = userInfoFromWechat;
    }
}
