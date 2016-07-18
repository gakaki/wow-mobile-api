package com.wow.user.vo;

import java.io.Serializable;

/**
 * Created by zhengzhiqing on 16/7/15.
 */
public class ThirdPartyLoginVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private int thirdPartyPlatformType;
    private String thirdPartyPlatformUserId;
    private String loginIp;
    private Byte loginChannel;
    private String userAgent;

    public int getThirdPartyPlatformType() {
        return thirdPartyPlatformType;
    }

    public void setThirdPartyPlatformType(int thirdPartyPlatformType) {
        this.thirdPartyPlatformType = thirdPartyPlatformType;
    }

    public String getThirdPartyPlatformUserId() {
        return thirdPartyPlatformUserId;
    }

    public void setThirdPartyPlatformUserId(String thirdPartyPlatformUserId) {
        this.thirdPartyPlatformUserId = thirdPartyPlatformUserId;
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
