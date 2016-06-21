package com.wow.stock.model;

import java.io.Serializable;
import java.util.Date;

public class ProductVirtualStock implements Serializable {
    private Integer id;

    private Integer productId;

    private Integer virtualStockNum;

    private Integer frozenVirtualStockNum;

    private Boolean isActive;

    private Date createTime;

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

    public Integer getVirtualStockNum() {
        return virtualStockNum;
    }

    public void setVirtualStockNum(Integer virtualStockNum) {
        this.virtualStockNum = virtualStockNum;
    }

    public Integer getFrozenVirtualStockNum() {
        return frozenVirtualStockNum;
    }

    public void setFrozenVirtualStockNum(Integer frozenVirtualStockNum) {
        this.frozenVirtualStockNum = frozenVirtualStockNum;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
        sb.append(", virtualStockNum=").append(virtualStockNum);
        sb.append(", frozenVirtualStockNum=").append(frozenVirtualStockNum);
        sb.append(", isActive=").append(isActive);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}