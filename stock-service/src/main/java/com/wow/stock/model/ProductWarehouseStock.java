package com.wow.stock.model;

import java.io.Serializable;
import java.util.Date;

public class ProductWarehouseStock implements Serializable {
    private Integer id;

    private Integer productId;

    private Integer warehouseId;

    private Integer realStockQty;

    private Integer frozenStockQty;

    private Integer lockStockQty;

    private Boolean isActive;

    private Date createDate;

    private Date updateDate;

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

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Integer getRealStockQty() {
        return realStockQty;
    }

    public void setRealStockQty(Integer realStockQty) {
        this.realStockQty = realStockQty;
    }

    public Integer getFrozenStockQty() {
        return frozenStockQty;
    }

    public void setFrozenStockQty(Integer frozenStockQty) {
        this.frozenStockQty = frozenStockQty;
    }

    public Integer getLockStockQty() {
        return lockStockQty;
    }

    public void setLockStockQty(Integer lockStockQty) {
        this.lockStockQty = lockStockQty;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", productId=").append(productId);
        sb.append(", warehouseId=").append(warehouseId);
        sb.append(", realStockQty=").append(realStockQty);
        sb.append(", frozenStockQty=").append(frozenStockQty);
        sb.append(", lockStockQty=").append(lockStockQty);
        sb.append(", isActive=").append(isActive);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}