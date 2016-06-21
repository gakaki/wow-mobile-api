package com.wow.stock.model;

import java.io.Serializable;
import java.util.Date;

public class ProductWarehouseStock implements Serializable {
    private Integer id;

    private Integer productId;

    private Integer warehouseId;

    private Short realStock;

    private Short frozenStock;

    private Boolean isActive;

    private Date createDate;

    private Date updateDate;

    private Boolean isDeleted;

    private Short lockStock;

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

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Short getRealStock() {
        return realStock;
    }

    public void setRealStock(Short realStock) {
        this.realStock = realStock;
    }

    public Short getFrozenStock() {
        return frozenStock;
    }

    public void setFrozenStock(Short frozenStock) {
        this.frozenStock = frozenStock;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Short getLockStock() {
        return lockStock;
    }

    public void setLockStock(Short lockStock) {
        this.lockStock = lockStock;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", productId=").append(productId);
        sb.append(", warehouseId=").append(warehouseId);
        sb.append(", realStock=").append(realStock);
        sb.append(", frozenStock=").append(frozenStock);
        sb.append(", isActive=").append(isActive);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", lockStock=").append(lockStock);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}