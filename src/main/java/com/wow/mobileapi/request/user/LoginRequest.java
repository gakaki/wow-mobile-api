package com.wow.mobileapi.request.user;

import com.wow.common.request.ApiRequest;

/**
 * Created by zhengzhiqing on 16/6/28.
 */
public class LoginRequest extends ApiRequest {

    /**  */
    private static final long serialVersionUID = 1L;
    private String userName;
    private String password;
    private String loginIp;
    private Byte loginChannel;
    private String userAgent;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
