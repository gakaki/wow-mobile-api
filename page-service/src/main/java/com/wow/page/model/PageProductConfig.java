package com.wow.page.model;

import java.io.Serializable;
import java.util.Date;

public class PageProductConfig implements Serializable {
    private Integer id;

    private Byte pageType;

    private Byte pageModuleType;

    private Integer productId;

    private String productImg;

    private Byte locationSort;

    private Date validFrom;

    private Date validTo;

    private Boolean isEnabled;

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

    public Byte getPageModuleType() {
        return pageModuleType;
    }

    public void setPageModuleType(Byte pageModuleType) {
        this.pageModuleType = pageModuleType;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg == null ? null : productImg.trim();
    }

    public Byte getLocationSort() {
        return locationSort;
    }

    public void setLocationSort(Byte locationSort) {
        this.locationSort = locationSort;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pageType=").append(pageType);
        sb.append(", pageModuleType=").append(pageModuleType);
        sb.append(", productId=").append(productId);
        sb.append(", productImg=").append(productImg);
        sb.append(", locationSort=").append(locationSort);
        sb.append(", validFrom=").append(validFrom);
        sb.append(", validTo=").append(validTo);
        sb.append(", isEnabled=").append(isEnabled);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}