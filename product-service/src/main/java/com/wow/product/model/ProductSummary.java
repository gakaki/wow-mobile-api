package com.wow.product.model;

import java.io.Serializable;
import java.util.Date;

public class ProductSummary implements Serializable {
    private Integer id;

    private Integer productId;

    private Integer totalSoldNum;

    private Integer sevenDaysSoldNum;

    private Integer totalComments;

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

    public Integer getTotalSoldNum() {
        return totalSoldNum;
    }

    public void setTotalSoldNum(Integer totalSoldNum) {
        this.totalSoldNum = totalSoldNum;
    }

    public Integer getSevenDaysSoldNum() {
        return sevenDaysSoldNum;
    }

    public void setSevenDaysSoldNum(Integer sevenDaysSoldNum) {
        this.sevenDaysSoldNum = sevenDaysSoldNum;
    }

    public Integer getTotalComments() {
        return totalComments;
    }

    public void setTotalComments(Integer totalComments) {
        this.totalComments = totalComments;
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
        sb.append(", totalSoldNum=").append(totalSoldNum);
        sb.append(", sevenDaysSoldNum=").append(sevenDaysSoldNum);
        sb.append(", totalComments=").append(totalComments);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}