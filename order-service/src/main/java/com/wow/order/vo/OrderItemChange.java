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
}
