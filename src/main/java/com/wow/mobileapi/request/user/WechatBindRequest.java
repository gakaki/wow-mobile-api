package com.wow.mobileapi.request.user;

import com.wow.common.request.ApiRequest;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by zhengzhiqing on 16/7/6.
 */
public class WechatBindRequest extends ApiRequest {

    private static final long serialVersionUID = 1L;

    @NotBlank
    private String mobile;
    @NotBlank
    private String openId;
    @NotBlank
    private String wechatNickName;
    @NotBlank
    private String wechatAvatar;

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
