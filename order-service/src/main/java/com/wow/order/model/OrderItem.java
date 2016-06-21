package com.wow.order.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OrderItem implements Serializable {
    private Integer id;

    private Integer orderId;

    private Integer productId;

    private BigDecimal orderItemAmount;

    private BigDecimal orderItemPrice;

    private Byte orderItemNum;

    private String productName;

    private Boolean needAssemble;

    private Byte productSaleType;

    private Integer parentOrderItemId;

    private Boolean isItemLeaf;

    private Integer productSupplierId;

    private Short frozenRealStockNum;

    private Short frozenVirtualStockNum;

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

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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

    public Byte getOrderItemNum() {
        return orderItemNum;
    }

    public void setOrderItemNum(Byte orderItemNum) {
        this.orderItemNum = orderItemNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public Short getFrozenRealStockNum() {
        return frozenRealStockNum;
    }

    public void setFrozenRealStockNum(Short frozenRealStockNum) {
        this.frozenRealStockNum = frozenRealStockNum;
    }

    public Short getFrozenVirtualStockNum() {
        return frozenVirtualStockNum;
    }

    public void setFrozenVirtualStockNum(Short frozenVirtualStockNum) {
        this.frozenVirtualStockNum = frozenVirtualStockNum;
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
        sb.append(", orderId=").append(orderId);
        sb.append(", productId=").append(productId);
        sb.append(", orderItemAmount=").append(orderItemAmount);
        sb.append(", orderItemPrice=").append(orderItemPrice);
        sb.append(", orderItemNum=").append(orderItemNum);
        sb.append(", productName=").append(productName);
        sb.append(", needAssemble=").append(needAssemble);
        sb.append(", productSaleType=").append(productSaleType);
        sb.append(", parentOrderItemId=").append(parentOrderItemId);
        sb.append(", isItemLeaf=").append(isItemLeaf);
        sb.append(", productSupplierId=").append(productSupplierId);
        sb.append(", frozenRealStockNum=").append(frozenRealStockNum);
        sb.append(", frozenVirtualStockNum=").append(frozenVirtualStockNum);
        sb.append(", isVirtualStockReady=").append(isVirtualStockReady);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}