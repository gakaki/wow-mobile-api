package com.wow.user.model;

import java.io.Serializable;
import java.util.Date;

public class EndUserShareScene implements Serializable {
    private Integer id;

    private Integer endUserId;

    private Integer sceneId;

    private String shareTitle;

    private String shareDesc;

    private String shareUrl;

    private String shareImg;

    private Byte shareChannel;

    private String recommendCode;

    private Date shareTime;

    private Boolean isShareSuccess;

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

    public Integer getSceneId() {
        return sceneId;
    }

    public void setSceneId(Integer sceneId) {
        this.sceneId = sceneId;
    }

    public String getShareTitle() {
        return shareTitle;
    }

    public void setShareTitle(String shareTitle) {
        this.shareTitle = shareTitle;
    }

    public String getShareDesc() {
        return shareDesc;
    }

    public void setShareDesc(String shareDesc) {
        this.shareDesc = shareDesc;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public String getShareImg() {
        return shareImg;
    }

    public void setShareImg(String shareImg) {
        this.shareImg = shareImg;
    }

    public Byte getShareChannel() {
        return shareChannel;
    }

    public void setShareChannel(Byte shareChannel) {
        this.shareChannel = shareChannel;
    }

    public String getRecommendCode() {
        return recommendCode;
    }

    public void setRecommendCode(String recommendCode) {
        this.recommendCode = recommendCode;
    }

    public Date getShareTime() {
        return shareTime;
    }

    public void setShareTime(Date shareTime) {
        this.shareTime = shareTime;
    }

    public Boolean getIsShareSuccess() {
        return isShareSuccess;
    }

    public void setIsShareSuccess(Boolean isShareSuccess) {
        this.isShareSuccess = isShareSuccess;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", endUserId=").append(endUserId);
        sb.append(", sceneId=").append(sceneId);
        sb.append(", shareTitle=").append(shareTitle);
        sb.append(", shareDesc=").append(shareDesc);
        sb.append(", shareUrl=").append(shareUrl);
        sb.append(", shareImg=").append(shareImg);
        sb.append(", shareChannel=").append(shareChannel);
        sb.append(", recommendCode=").append(recommendCode);
        sb.append(", shareTime=").append(shareTime);
        sb.append(", isShareSuccess=").append(isShareSuccess);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}