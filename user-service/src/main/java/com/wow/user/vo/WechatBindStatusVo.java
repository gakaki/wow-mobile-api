package com.wow.user.vo;

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
    private int endUserId;
    private String nickName;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getEndUserId() {
        return endUserId;
    }

    public void setEndUserId(int endUserId) {
        this.endUserId = endUserId;
    }

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
