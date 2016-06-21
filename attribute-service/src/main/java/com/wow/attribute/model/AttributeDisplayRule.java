package com.wow.attribute.model;

import java.io.Serializable;

public class AttributeDisplayRule implements Serializable {
    private Integer id;

    private Integer attributeGroupId;

    private Integer attributeId;

    private Boolean isFilterAttribute;

    private Byte sortOrder;

    private Boolean isAmongMore;

    private Boolean canShowInItemDetail;

    private Boolean isDeleted;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAttributeGroupId() {
        return attributeGroupId;
    }

    public void setAttributeGroupId(Integer attributeGroupId) {
        this.attributeGroupId = attributeGroupId;
    }

    public Integer getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Integer attributeId) {
        this.attributeId = attributeId;
    }

    public Boolean getIsFilterAttribute() {
        return isFilterAttribute;
    }

    public void setIsFilterAttribute(Boolean isFilterAttribute) {
        this.isFilterAttribute = isFilterAttribute;
    }

    public Byte getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Byte sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Boolean getIsAmongMore() {
        return isAmongMore;
    }

    public void setIsAmongMore(Boolean isAmongMore) {
        this.isAmongMore = isAmongMore;
    }

    public Boolean getCanShowInItemDetail() {
        return canShowInItemDetail;
    }

    public void setCanShowInItemDetail(Boolean canShowInItemDetail) {
        this.canShowInItemDetail = canShowInItemDetail;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", attributeGroupId=").append(attributeGroupId);
        sb.append(", attributeId=").append(attributeId);
        sb.append(", isFilterAttribute=").append(isFilterAttribute);
        sb.append(", sortOrder=").append(sortOrder);
        sb.append(", isAmongMore=").append(isAmongMore);
        sb.append(", canShowInItemDetail=").append(canShowInItemDetail);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}