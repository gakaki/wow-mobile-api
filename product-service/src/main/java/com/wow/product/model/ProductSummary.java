package com.wow.product.model;

import java.io.Serializable;
import java.util.Date;

public class ProductSummary implements Serializable {
    private Integer id;

    private Integer productId;

    private Integer totalSoldQty;

    private Integer sevenDaysSoldQty;

    private Integer totalCommentQty;

    private Date updateTime;

    private Boolean isDeleted;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getTotalSoldQty() {
        return totalSoldQty;
    }

    public void setTotalSoldQty(Integer totalSoldQty) {
        this.totalSoldQty = totalSoldQty;
    }

    public Integer getSevenDaysSoldQty() {
        return sevenDaysSoldQty;
    }

    public void setSevenDaysSoldQty(Integer sevenDaysSoldQty) {
        this.sevenDaysSoldQty = sevenDaysSoldQty;
    }

    public Integer getTotalCommentQty() {
        return totalCommentQty;
    }

    public void setTotalCommentQty(Integer totalCommentQty) {
        this.totalCommentQty = totalCommentQty;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
        sb.append(", productId=").append(productId);
        sb.append(", totalSoldQty=").append(totalSoldQty);
        sb.append(", sevenDaysSoldQty=").append(sevenDaysSoldQty);
        sb.append(", totalCommentQty=").append(totalCommentQty);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}