package com.wow.stock.model;

import java.io.Serializable;
import java.util.Date;

public class ProductVirtualStock implements Serializable {
    private Integer id;

    private Integer productId;

    private Integer virtualStockQty;

    private Integer frozenVirtualStockQty;

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

    public Integer getVirtualStockQty() {
        return virtualStockQty;
    }

    public void setVirtualStockQty(Integer virtualStockQty) {
        this.virtualStockQty = virtualStockQty;
    }

    public Integer getFrozenVirtualStockQty() {
        return frozenVirtualStockQty;
    }

    public void setFrozenVirtualStockQty(Integer frozenVirtualStockQty) {
        this.frozenVirtualStockQty = frozenVirtualStockQty;
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
        sb.append(", virtualStockQty=").append(virtualStockQty);
        sb.append(", frozenVirtualStockQty=").append(frozenVirtualStockQty);
        sb.append(", isActive=").append(isActive);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}