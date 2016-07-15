package com.wow.mobileapi.request.user;

import com.wow.common.request.ApiRequest;

/**
 * Created by zhengzhiqing on 16/7/6.
 */
public class WechatBindRequest extends ApiRequest {

    private static final long serialVersionUID = 1L;

    private Integer endUserId;

    private String mobile;

    private String wechatId;

    private String wechatNickName;

    private String wechatAvatar;

    public Integer getEndUserId() {
        return endUserId;
    }

    public void setEndUserId(Integer endUserId) {
        this.endUserId = endUserId;
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

    public String getWechatNickName() {
        return wechatNickName;
    }

    public void setWechatNickName(String wechatNickName) {
        this.wechatNickName = wechatNickName;
    }

    public String getWechatAvatar() {
        return wechatAvatar;
    }

    public void setWechatAvatar(String wechatAvatar) {
        this.wechatAvatar = wechatAvatar;
    }
}
