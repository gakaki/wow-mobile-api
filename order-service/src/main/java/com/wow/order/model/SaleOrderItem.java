package com.wow.order.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SaleOrderItem implements Serializable {
    private Integer id;

    private Integer saleOrderId;

    private Integer deliveryOrderId;

    private Integer productId;

    private Integer parentProductId;

    private BigDecimal orderItemAmount;

    private BigDecimal orderItemPrice;

    private Byte orderItemQty;

    private String productName;

    private Boolean needAssemble;

    private Integer frozenWarehouseStockTotalQty;

    private Integer frozenVirtualStockQty;

    private Boolean isVirtualStockReady;

    private Date createTime;

    private Date updateTime;

    private Boolean isShippedOut;

    private Boolean isDeleted;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSaleOrderId() {
        return saleOrderId;
    }

    public void setSaleOrderId(Integer saleOrderId) {
        this.saleOrderId = saleOrderId;
    }

    public Integer getDeliveryOrderId() {
        return deliveryOrderId;
    }

    public void setDeliveryOrderId(Integer deliveryOrderId) {
        this.deliveryOrderId = deliveryOrderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getParentProductId() {
        return parentProductId;
    }

    public void setParentProductId(Integer parentProductId) {
        this.parentProductId = parentProductId;
    }

    public BigDecimal getOrderItemAmount() {
        return orderItemAmount;
    }

    public void setOrderItemAmount(BigDecimal orderItemAmount) {
        this.orderItemAmount = orderItemAmount;
    }

    public BigDecimal getOrderItemPrice() {
        return orderItemPrice;
    }

    public void setOrderItemPrice(BigDecimal orderItemPrice) {
        this.orderItemPrice = orderItemPrice;
    }

    public Byte getOrderItemQty() {
        return orderItemQty;
    }

    public void setOrderItemQty(Byte orderItemQty) {
        this.orderItemQty = orderItemQty;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public Boolean getNeedAssemble() {
        return needAssemble;
    }

    public void setNeedAssemble(Boolean needAssemble) {
        this.needAssemble = needAssemble;
    }

    public Integer getFrozenWarehouseStockTotalQty() {
        return frozenWarehouseStockTotalQty;
    }

    public void setFrozenWarehouseStockTotalQty(Integer frozenWarehouseStockTotalQty) {
        this.frozenWarehouseStockTotalQty = frozenWarehouseStockTotalQty;
    }

    public Integer getFrozenVirtualStockQty() {
        return frozenVirtualStockQty;
    }

    public void setFrozenVirtualStockQty(Integer frozenVirtualStockQty) {
        this.frozenVirtualStockQty = frozenVirtualStockQty;
    }

    public Boolean getIsVirtualStockReady() {
        return isVirtualStockReady;
    }

    public void setIsVirtualStockReady(Boolean isVirtualStockReady) {
        this.isVirtualStockReady = isVirtualStockReady;
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

    public Boolean getIsShippedOut() {
        return isShippedOut;
    }

    public void setIsShippedOut(Boolean isShippedOut) {
        this.isShippedOut = isShippedOut;
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
        sb.append(", saleOrderId=").append(saleOrderId);
        sb.append(", deliveryOrderId=").append(deliveryOrderId);
        sb.append(", productId=").append(productId);
        sb.append(", parentProductId=").append(parentProductId);
        sb.append(", orderItemAmount=").append(orderItemAmount);
        sb.append(", orderItemPrice=").append(orderItemPrice);
        sb.append(", orderItemQty=").append(orderItemQty);
        sb.append(", productName=").append(productName);
        sb.append(", needAssemble=").append(needAssemble);
        sb.append(", frozenWarehouseStockTotalQty=").append(frozenWarehouseStockTotalQty);
        sb.append(", frozenVirtualStockQty=").append(frozenVirtualStockQty);
        sb.append(", isVirtualStockReady=").append(isVirtualStockReady);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isShippedOut=").append(isShippedOut);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}