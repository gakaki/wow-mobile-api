package com.wow.order.vo;

import java.util.List;
import java.util.Map;

/**
 * Created by zhengzhiqing on 16/7/2.
 */
public class OrderWithVirtualStockProcessResult {
    private int productId;
    private int frozenVirtualStockBefore;
    private int frozenVirtualStockAfter;
    //按仓库冻结真实库存
    private Map<Integer,Integer> frozenWarehouseRealStockMap;
    List<OrderItemChange> orderItemChangeList;
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public int getFrozenVirtualStockBefore() {
        return frozenVirtualStockBefore;
    }
    public void setFrozenVirtualStockBefore(int frozenVirtualStockBefore) {
        this.frozenVirtualStockBefore = frozenVirtualStockBefore;
    }
    public int getFrozenVirtualStockAfter() {
        return frozenVirtualStockAfter;
    }
    public void setFrozenVirtualStockAfter(int frozenVirtualStockAfter) {
        this.frozenVirtualStockAfter = frozenVirtualStockAfter;
    }
    public Map<Integer, Integer> getFrozenWarehouseRealStockMap() {
        return frozenWarehouseRealStockMap;
    }
    public void setFrozenWarehouseRealStockMap(Map<Integer, Integer> frozenWarehouseRealStockMap) {
        this.frozenWarehouseRealStockMap = frozenWarehouseRealStockMap;
    }
    public List<OrderItemChange> getOrderItemChangeList() {
        return orderItemChangeList;
    }
    public void setOrderItemChangeList(List<OrderItemChange> orderItemChangeList) {
        this.orderItemChangeList = orderItemChangeList;
    }
    
    
}
