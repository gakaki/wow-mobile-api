package com.wow.mobileapi.request.user;

import com.wow.common.request.ApiRequest;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by zhengzhiqing on 16/6/28.
 */
public class ResetPwdRequest extends ApiRequest {

    private static final long serialVersionUID = 1L;
    @NotBlank
    private String mobile;
    @NotBlank
    private String captcha;
    @NotBlank
    private String newPwd;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }
}
