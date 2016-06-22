package com.wow.attribute.model;

import java.io.Serializable;

public class Category implements Serializable {
    private Integer id;

    private String categoryName;

    private Integer parentCategoryId;

    private Byte categoryLevel;

    private String categoryDesc;

    private Integer attributeGroupId;

    private String categoryIconSmall;

    private String categoryIconBig;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(Integer parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public Byte getCategoryLevel() {
        return categoryLevel;
    }

    public void setCategoryLevel(Byte categoryLevel) {
        this.categoryLevel = categoryLevel;
    }

    public String getCategoryDesc() {
        return categoryDesc;
    }

    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc;
    }

    public Integer getAttributeGroupId() {
        return attributeGroupId;
    }

    public void setAttributeGroupId(Integer attributeGroupId) {
        this.attributeGroupId = attributeGroupId;
    }

    public String getCategoryIconSmall() {
        return categoryIconSmall;
    }

    public void setCategoryIconSmall(String categoryIconSmall) {
        this.categoryIconSmall = categoryIconSmall;
    }

    public String getCategoryIconBig() {
        return categoryIconBig;
    }

    public void setCategoryIconBig(String categoryIconBig) {
        this.categoryIconBig = categoryIconBig;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", categoryName=").append(categoryName);
        sb.append(", parentCategoryId=").append(parentCategoryId);
        sb.append(", categoryLevel=").append(categoryLevel);
        sb.append(", categoryDesc=").append(categoryDesc);
        sb.append(", attributeGroupId=").append(attributeGroupId);
        sb.append(", categoryIconSmall=").append(categoryIconSmall);
        sb.append(", categoryIconBig=").append(categoryIconBig);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}