package com.wow.order.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 创建订单项目查询类
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月17日 上午11:42:47 Exp $
 */
public class OrderItemQuery implements Serializable {
    /**  */
    private static final long serialVersionUID = 1L;

    //订单项目id列表
    private List<Integer> orderItemIds;

    //发货单id
    private Integer deliveryOrderId;

    public List<Integer> getOrderItemIds() {
        return orderItemIds;
    }

    public void setOrderItemIds(List<Integer> orderItemIds) {
        this.orderItemIds = orderItemIds;
    }

    public Integer getDeliveryOrderId() {
        return deliveryOrderId;
    }

    public void setDeliveryOrderId(Integer deliveryOrderId) {
        this.deliveryOrderId = deliveryOrderId;
    }
}
