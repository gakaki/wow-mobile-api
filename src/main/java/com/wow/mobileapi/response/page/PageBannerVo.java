package com.wow.mobileapi.response.page;

import java.io.Serializable;

/**
 * Created by zhengzhiqing on 16/7/21.
 */
public class PageBannerVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String bannerImgSrc;
    private byte bannerLinkType;
    private String bannerLinkUrl;
    private int bannerLinkTargetId;

    public String getBannerImgSrc() {
        return bannerImgSrc;
    }

    public void setBannerImgSrc(String bannerImgSrc) {
        this.bannerImgSrc = bannerImgSrc;
    }

    public byte getBannerLinkType() {
        return bannerLinkType;
    }

    public void setBannerLinkType(byte bannerLinkType) {
        this.bannerLinkType = bannerLinkType;
    }

    public String getBannerLinkUrl() {
        return bannerLinkUrl;
    }

    public void setBannerLinkUrl(String bannerLinkUrl) {
        this.bannerLinkUrl = bannerLinkUrl;
    }

    public int getBannerLinkTargetId() {
        return bannerLinkTargetId;
    }

    public void setBannerLinkTargetId(int bannerLinkTargetId) {
        this.bannerLinkTargetId = bannerLinkTargetId;
    }
}
