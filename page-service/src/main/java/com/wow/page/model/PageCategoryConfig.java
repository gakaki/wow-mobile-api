package com.wow.page.model;

import java.io.Serializable;
import java.util.Date;

public class PageCategoryConfig implements Serializable {
    private Integer id;

    private Byte pageType;

    private Byte pageModuleType;

    private Integer categoryId;

    private Byte sortOrder;

    private String categoryBgimg;

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

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Byte getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Byte sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getCategoryBgimg() {
        return categoryBgimg;
    }

    public void setCategoryBgimg(String categoryBgimg) {
        this.categoryBgimg = categoryBgimg == null ? null : categoryBgimg.trim();
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
        sb.append(", categoryId=").append(categoryId);
        sb.append(", sortOrder=").append(sortOrder);
        sb.append(", categoryBgimg=").append(categoryBgimg);
        sb.append(", validFrom=").append(validFrom);
        sb.append(", validTo=").append(validTo);
        sb.append(", isEnabled=").append(isEnabled);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}