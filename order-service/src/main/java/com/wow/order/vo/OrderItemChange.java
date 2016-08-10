package com.wow.order.vo;

/**
 * Created by zhengzhiqing on 16/7/2.
 */
public class OrderItemChange {
    private int id;
    private int orderId;
    private Integer productId;
    private Byte orderItemQty;
    private Short frozenRealStockQtyBefore;
    private Short frozenVirtualStockQtyBefore;
    private Boolean isVirtualStockReadyBefore;
    private Short frozenRealStockQtyAfter;
    private Short frozenVirtualStockQtyAfter;
    private Boolean isVirtualStockReadyAfter;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public Integer getProductId() {
        return productId;
    }
    public void setProductId(Integer productId) {
        this.productId = productId;
    }
    public Byte getOrderItemQty() {
        return orderItemQty;
    }
    public void setOrderItemQty(Byte orderItemQty) {
        this.orderItemQty = orderItemQty;
    }
    public Short getFrozenRealStockQtyBefore() {
        return frozenRealStockQtyBefore;
    }
    public void setFrozenRealStockQtyBefore(Short frozenRealStockQtyBefore) {
        this.frozenRealStockQtyBefore = frozenRealStockQtyBefore;
    }
    public Short getFrozenVirtualStockQtyBefore() {
        return frozenVirtualStockQtyBefore;
    }
    public void setFrozenVirtualStockQtyBefore(Short frozenVirtualStockQtyBefore) {
        this.frozenVirtualStockQtyBefore = frozenVirtualStockQtyBefore;
    }
    public Boolean getIsVirtualStockReadyBefore() {
        return isVirtualStockReadyBefore;
    }
    public void setIsVirtualStockReadyBefore(Boolean isVirtualStockReadyBefore) {
        this.isVirtualStockReadyBefore = isVirtualStockReadyBefore;
    }
    public Short getFrozenRealStockQtyAfter() {
        return frozenRealStockQtyAfter;
    }
    public void setFrozenRealStockQtyAfter(Short frozenRealStockQtyAfter) {
        this.frozenRealStockQtyAfter = frozenRealStockQtyAfter;
    }
    public Short getFrozenVirtualStockQtyAfter() {
        return frozenVirtualStockQtyAfter;
    }
    public void setFrozenVirtualStockQtyAfter(Short frozenVirtualStockQtyAfter) {
        this.frozenVirtualStockQtyAfter = frozenVirtualStockQtyAfter;
    }
    public Boolean getIsVirtualStockReadyAfter() {
        return isVirtualStockReadyAfter;
    }
    public void setIsVirtualStockReadyAfter(Boolean isVirtualStockReadyAfter) {
        this.isVirtualStockReadyAfter = isVirtualStockReadyAfter;
    }
    
    
}
