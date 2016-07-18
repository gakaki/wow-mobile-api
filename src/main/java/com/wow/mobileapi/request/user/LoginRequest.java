package com.wow.mobileapi.request.user;

import com.wow.common.request.ApiRequest;

import javax.validation.constraints.NotNull;

/**
 * Created by zhengzhiqing on 16/6/28.
 */
public class LoginRequest extends ApiRequest {

    /**  */
    private static final long serialVersionUID = 1L;
    @NotNull
    private String mobile;
    @NotNull
    private String password;
    @NotNull
    private Byte loginChannel;

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

    public Byte getLoginChannel() {
        return loginChannel;
    }

    public void setLoginChannel(Byte loginChannel) {
        this.loginChannel = loginChannel;
    }
}
