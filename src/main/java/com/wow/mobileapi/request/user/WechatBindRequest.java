package com.wow.mobileapi.request.user;

import com.wow.common.request.ApiRequest;

import javax.validation.constraints.NotNull;

/**
 * Created by zhengzhiqing on 16/7/6.
 */
public class WechatBindRequest extends ApiRequest {

    private static final long serialVersionUID = 1L;
//    @NotNull
//    private Integer endUserId;
//
//    private String mobile;
    @NotNull
    private String openId;
    @NotNull
    private String wechatNickName;
    @NotNull
    private String wechatAvatar;

//    public Integer getEndUserId() {
//        return endUserId;
//    }
//
//    public void setEndUserId(Integer endUserId) {
//        this.endUserId = endUserId;
//    }
//
//    public String getMobile() {
//        return mobile;
//    }
//
//    public void setMobile(String mobile) {
//        this.mobile = mobile;
//    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
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
