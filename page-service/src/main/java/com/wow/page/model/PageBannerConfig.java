package com.wow.page.model;

import java.io.Serializable;
import java.util.Date;

public class PageBannerConfig implements Serializable {
    private Integer id;

    private Byte pageType;

    private String bannerTitle;

    private String bannerDesc;

    private String bannerImgSrc;

    private Byte bannerLinkType;

    private String bannerLinkUrl;

    private Integer bannerLinkTargetId;

    private Date activeFrom;

    private Date activeTo;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getPageType() {
        return pageType;
    }

    public void setPageType(Byte pageType) {
        this.pageType = pageType;
    }

    public String getBannerTitle() {
        return bannerTitle;
    }

    public void setBannerTitle(String bannerTitle) {
        this.bannerTitle = bannerTitle;
    }

    public String getBannerDesc() {
        return bannerDesc;
    }

    public void setBannerDesc(String bannerDesc) {
        this.bannerDesc = bannerDesc;
    }

    public String getBannerImgSrc() {
        return bannerImgSrc;
    }

    public void setBannerImgSrc(String bannerImgSrc) {
        this.bannerImgSrc = bannerImgSrc;
    }

    public Byte getBannerLinkType() {
        return bannerLinkType;
    }

    public void setBannerLinkType(Byte bannerLinkType) {
        this.bannerLinkType = bannerLinkType;
    }

    public String getBannerLinkUrl() {
        return bannerLinkUrl;
    }

    public void setBannerLinkUrl(String bannerLinkUrl) {
        this.bannerLinkUrl = bannerLinkUrl;
    }

    public Integer getBannerLinkTargetId() {
        return bannerLinkTargetId;
    }

    public void setBannerLinkTargetId(Integer bannerLinkTargetId) {
        this.bannerLinkTargetId = bannerLinkTargetId;
    }

    public Date getActiveFrom() {
        return activeFrom;
    }

    public void setActiveFrom(Date activeFrom) {
        this.activeFrom = activeFrom;
    }

    public Date getActiveTo() {
        return activeTo;
    }

    public void setActiveTo(Date activeTo) {
        this.activeTo = activeTo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pageType=").append(pageType);
        sb.append(", bannerTitle=").append(bannerTitle);
        sb.append(", bannerDesc=").append(bannerDesc);
        sb.append(", bannerImgSrc=").append(bannerImgSrc);
        sb.append(", bannerLinkType=").append(bannerLinkType);
        sb.append(", bannerLinkUrl=").append(bannerLinkUrl);
        sb.append(", bannerLinkTargetId=").append(bannerLinkTargetId);
        sb.append(", activeFrom=").append(activeFrom);
        sb.append(", activeTo=").append(activeTo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}