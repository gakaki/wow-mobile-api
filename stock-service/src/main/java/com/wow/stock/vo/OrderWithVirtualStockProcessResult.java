package com.wow.stock.vo;

import com.wow.order.model.OrderItem;

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
}
