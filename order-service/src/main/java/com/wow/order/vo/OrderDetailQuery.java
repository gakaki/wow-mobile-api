package com.wow.order.vo;

import java.io.Serializable;

/**
 * 订单明细查询类
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月17日 上午11:42:47 Exp $
 */
public class OrderDetailQuery implements Serializable {
    /**  */
    private static final long serialVersionUID = 1L;

    //订单id
    private Integer orderId;

    //订单号
    private String orderCode;

    //取消原因
    private String cancelReason;

    //是否自动取消订单
    private boolean isAutoCancel;

    //用户id
    private Integer endUserId;
    
    public Integer getEndUserId() {
        return endUserId;
    }

    public void setEndUserId(Integer endUserId) {
        this.endUserId = endUserId;
    }

    public boolean isAutoCancel() {
        return isAutoCancel;
    }

    public void setAutoCancel(boolean isAutoCancel) {
        this.isAutoCancel = isAutoCancel;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }
}
