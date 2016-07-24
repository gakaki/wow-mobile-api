package com.wow.order.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 拆分订单查询类
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月17日 上午11:42:47 Exp $
 */
public class OrderSplitQuery implements Serializable {
    /**  */
    private static final long serialVersionUID = 1L;

    //订单项目id列表
    private List<Integer> saleOrderItemIds;

    //用户id
    private Integer endUserId;
    
    //订单号
    private String orderCode;

    //订单id
    private Integer orderId;

    //物流公司代码
    private String deliveryCompanyCode;

    //运单号
    private String deliveryOrderNo;
    
    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public List<Integer> getSaleOrderItemIds() {
        return saleOrderItemIds;
    }

    public void setSaleOrderItemIds(List<Integer> saleOrderItemIds) {
        this.saleOrderItemIds = saleOrderItemIds;
    }

    public Integer getEndUserId() {
        return endUserId;
    }

    public void setEndUserId(Integer endUserId) {
        this.endUserId = endUserId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getDeliveryCompanyCode() {
        return deliveryCompanyCode;
    }

    public void setDeliveryCompanyCode(String deliveryCompanyCode) {
        this.deliveryCompanyCode = deliveryCompanyCode;
    }

    public String getDeliveryOrderNo() {
        return deliveryOrderNo;
    }

    public void setDeliveryOrderNo(String deliveryOrderNo) {
        this.deliveryOrderNo = deliveryOrderNo;
    }

}
