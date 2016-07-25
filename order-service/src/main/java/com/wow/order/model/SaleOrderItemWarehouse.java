package com.wow.order.model;

import java.io.Serializable;
import java.util.Date;

public class SaleOrderItemWarehouse implements Serializable {
    private Integer id;

    private Integer saleOrderItemId;

    private Integer warehouseId;

    private Integer frozenWarehouseStockQty;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSaleOrderItemId() {
        return saleOrderItemId;
    }

    public void setSaleOrderItemId(Integer saleOrderItemId) {
        this.saleOrderItemId = saleOrderItemId;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Integer getFrozenWarehouseStockQty() {
        return frozenWarehouseStockQty;
    }

    public void setFrozenWarehouseStockQty(Integer frozenWarehouseStockQty) {
        this.frozenWarehouseStockQty = frozenWarehouseStockQty;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", saleOrderItemId=").append(saleOrderItemId);
        sb.append(", warehouseId=").append(warehouseId);
        sb.append(", frozenWarehouseStockQty=").append(frozenWarehouseStockQty);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}