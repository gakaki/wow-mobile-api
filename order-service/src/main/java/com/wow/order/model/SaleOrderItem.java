package com.wow.order.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SaleOrderItem implements Serializable {
    private Integer id;

    private Integer saleOrderId;

    private Integer productId;

    private BigDecimal orderItemAmount;

    private BigDecimal orderItemPrice;

    private Byte orderItemQty;

    private String productName;

    private Boolean needAssemble;

    private Byte productSaleType;

    private Integer parentOrderItemId;

    private Boolean isItemLeaf;

    private Integer productSupplierId;

    private Integer frozenRealStockQty;

    private Integer frozenVirtualStockQty;

    private Boolean isVirtualStockReady;

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

    public Integer getSaleOrderId() {
        return saleOrderId;
    }

    public void setSaleOrderId(Integer saleOrderId) {
        this.saleOrderId = saleOrderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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

    public Byte getProductSaleType() {
        return productSaleType;
    }

    public void setProductSaleType(Byte productSaleType) {
        this.productSaleType = productSaleType;
    }

    public Integer getParentOrderItemId() {
        return parentOrderItemId;
    }

    public void setParentOrderItemId(Integer parentOrderItemId) {
        this.parentOrderItemId = parentOrderItemId;
    }

    public Boolean getIsItemLeaf() {
        return isItemLeaf;
    }

    public void setIsItemLeaf(Boolean isItemLeaf) {
        this.isItemLeaf = isItemLeaf;
    }

    public Integer getProductSupplierId() {
        return productSupplierId;
    }

    public void setProductSupplierId(Integer productSupplierId) {
        this.productSupplierId = productSupplierId;
    }

    public Integer getFrozenRealStockQty() {
        return frozenRealStockQty;
    }

    public void setFrozenRealStockQty(Integer frozenRealStockQty) {
        this.frozenRealStockQty = frozenRealStockQty;
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
        sb.append(", productId=").append(productId);
        sb.append(", orderItemAmount=").append(orderItemAmount);
        sb.append(", orderItemPrice=").append(orderItemPrice);
        sb.append(", orderItemQty=").append(orderItemQty);
        sb.append(", productName=").append(productName);
        sb.append(", needAssemble=").append(needAssemble);
        sb.append(", productSaleType=").append(productSaleType);
        sb.append(", parentOrderItemId=").append(parentOrderItemId);
        sb.append(", isItemLeaf=").append(isItemLeaf);
        sb.append(", productSupplierId=").append(productSupplierId);
        sb.append(", frozenRealStockQty=").append(frozenRealStockQty);
        sb.append(", frozenVirtualStockQty=").append(frozenVirtualStockQty);
        sb.append(", isVirtualStockReady=").append(isVirtualStockReady);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}