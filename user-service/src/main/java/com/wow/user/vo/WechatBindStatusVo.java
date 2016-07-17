package com.wow.user.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * Created by zhengzhiqing on 16/7/13.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class WechatBindStatusVo implements Serializable{

    private static final long serialVersionUID = 1L;

    private boolean registered;
    private boolean binded;
    private String mobile;
    private String openId;
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
        this.registered = registered;
    }

    public boolean isBinded() {
        return binded;
    }

    public void setBinded(boolean binded) {
        this.binded = binded;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}
