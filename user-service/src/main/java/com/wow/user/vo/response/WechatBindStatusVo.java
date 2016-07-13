package com.wow.user.vo.response;

import java.io.Serializable;

/**
 * Created by zhengzhiqing on 16/7/13.
 */
public class WechatBindStatusVo implements Serializable{

    private static final long serialVersionUID = 1L;

    private boolean registered;
    private boolean binded;
    private String mobile;
    private String wechatId;

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        registered = registered;
    }

    public boolean isBinded() {
        return binded;
    }

    public void setBinded(boolean binded) {
        binded = binded;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }
}
