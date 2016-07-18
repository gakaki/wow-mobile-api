package com.wow.user.model;

import java.io.Serializable;
import java.util.Date;

public class EndUserWechat implements Serializable {
    private Integer id;

    private Integer endUserId;

    private String mobile;

    private String openId;

    private String wechatNickName;

    private String wechatAvatar;

    private Boolean isBind;

    private Date bindTime;

    private Date unbindTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public String getWechatNickName() {
        return wechatNickName;
    }

    public void setWechatNickName(String wechatNickName) {
        this.wechatNickName = wechatNickName == null ? null : wechatNickName.trim();
    }

    public String getWechatAvatar() {
        return wechatAvatar;
    }

    public void setWechatAvatar(String wechatAvatar) {
        this.wechatAvatar = wechatAvatar == null ? null : wechatAvatar.trim();
    }

    public Boolean getIsBind() {
        return isBind;
    }

    public void setIsBind(Boolean isBind) {
        this.isBind = isBind;
    }

    public Date getBindTime() {
        return bindTime;
    }

    public void setBindTime(Date bindTime) {
        this.bindTime = bindTime;
    }

    public Date getUnbindTime() {
        return unbindTime;
    }

    public void setUnbindTime(Date unbindTime) {
        this.unbindTime = unbindTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", endUserId=").append(endUserId);
        sb.append(", mobile=").append(mobile);
        sb.append(", openId=").append(openId);
        sb.append(", wechatNickName=").append(wechatNickName);
        sb.append(", wechatAvatar=").append(wechatAvatar);
        sb.append(", isBind=").append(isBind);
        sb.append(", bindTime=").append(bindTime);
        sb.append(", unbindTime=").append(unbindTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}