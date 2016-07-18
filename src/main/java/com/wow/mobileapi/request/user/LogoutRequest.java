package com.wow.mobileapi.request.user;

import com.wow.common.request.ApiRequest;

/**
 * Created by zhengzhiqing on 16/6/28.
 */
public class LogoutRequest extends ApiRequest {

    private Byte loginChannel;

    private int endUserId;

    public Byte getLoginChannel() {
        return loginChannel;
    }

    public void setLoginChannel(Byte loginChannel) {
        this.loginChannel = loginChannel;
    }

    public int getEndUserId() {
        return endUserId;
    }

    public void setEndUserId(int endUserId) {
        this.endUserId = endUserId;
    }
}
