package com.wow.user.vo;

import java.io.Serializable;

/**
 * Created by zhengzhiqing on 16/7/9.
 */
public class WechatBindingStatusVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean registered;
    private boolean bindWechat;
    private String mobile;
    private String wechatId;

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    public boolean isBindWechat() {
        return bindWechat;
    }

    public void setBindWechat(boolean bindWechat) {
        this.bindWechat = bindWechat;
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
