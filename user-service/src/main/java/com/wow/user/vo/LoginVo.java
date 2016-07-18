package com.wow.user.vo;

import java.io.Serializable;

/**
 * Created by zhengzhiqing on 16/7/15.
 */
public class LoginVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String mobile;
    private String password;
    private String loginIp;
    private Byte loginChannel;
    private String userAgent;

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

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Byte getLoginChannel() {
        return loginChannel;
    }

    public void setLoginChannel(Byte loginChannel) {
        this.loginChannel = loginChannel;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }
}
