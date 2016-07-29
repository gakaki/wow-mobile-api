package com.wow.order.vo;

import java.io.Serializable;

import com.wow.common.page.PageQuery;

/**
 * 订单列表查询类
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月17日 上午11:42:47 Exp $
 */
public class OrderListQuery extends PageQuery implements Serializable {
    /**  */
    private static final long serialVersionUID = 1L;

    //用户id
    private Integer endUserId;

    //订单状态
    private Byte orderStatus;

    public Byte getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Byte orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getEndUserId() {
        return endUserId;
    }

    public void setEndUserId(Integer endUserId) {
        this.endUserId = endUserId;
    }

}