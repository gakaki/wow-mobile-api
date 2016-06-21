package com.wow.product.model;

import java.io.Serializable;

public class Brand implements Serializable {
    private Integer id;

    private String brandName;

    private String brandNameFirstLetter;

    private String brandCountry;

    private String brandHomeUrl;

    private String brandLogoImg;

    private String brandVideo;

    private String brandImg;

    private String brandDesc;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandNameFirstLetter() {
        return brandNameFirstLetter;
    }

    public void setBrandNameFirstLetter(String brandNameFirstLetter) {
        this.brandNameFirstLetter = brandNameFirstLetter;
    }

    public String getBrandCountry() {
        return brandCountry;
    }

    public void setBrandCountry(String brandCountry) {
        this.brandCountry = brandCountry;
    }

    public String getBrandHomeUrl() {
        return brandHomeUrl;
    }

    public void setBrandHomeUrl(String brandHomeUrl) {
        this.brandHomeUrl = brandHomeUrl;
    }

    public String getBrandLogoImg() {
        return brandLogoImg;
    }

    public void setBrandLogoImg(String brandLogoImg) {
        this.brandLogoImg = brandLogoImg;
    }

    public String getBrandVideo() {
        return brandVideo;
    }

    public void setBrandVideo(String brandVideo) {
        this.brandVideo = brandVideo;
    }

    public String getBrandImg() {
        return brandImg;
    }

    public void setBrandImg(String brandImg) {
        this.brandImg = brandImg;
    }

    public String getBrandDesc() {
        return brandDesc;
    }

    public void setBrandDesc(String brandDesc) {
        this.brandDesc = brandDesc;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", brandName=").append(brandName);
        sb.append(", brandNameFirstLetter=").append(brandNameFirstLetter);
        sb.append(", brandCountry=").append(brandCountry);
        sb.append(", brandHomeUrl=").append(brandHomeUrl);
        sb.append(", brandLogoImg=").append(brandLogoImg);
        sb.append(", brandVideo=").append(brandVideo);
        sb.append(", brandImg=").append(brandImg);
        sb.append(", brandDesc=").append(brandDesc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}