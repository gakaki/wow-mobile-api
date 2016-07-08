package com.wow.user.vo;

import com.wow.user.model.EndUser;

import java.io.Serializable;

/**
 * Created by zhengzhiqing on 16/7/6.
 */
public class RegisterRequestVo implements Serializable {

    private static final long serialVersionUID = 1L;

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

    public String toString() {
        return "captchar:" + captcha + "endUser:" + endUser.toString();
    }
}
