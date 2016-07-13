package com.wow.user.vo.request;

import com.wow.common.request.ApiRequest;
import com.wow.user.model.EndUser;

/**
 * Created by zhengzhiqing on 16/7/6.
 */
public class RegisterRequest extends ApiRequest {

    private EndUser endUser;
    private String captcha;

    public EndUser getEndUser() {
        return endUser;
    }

    public void setEndUser(EndUser endUser) {
        this.endUser = endUser;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

}
