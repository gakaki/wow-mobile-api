package com.wow.order.vo;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 发货单vo
 * 
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月15日 下午6:21:56 Exp $
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class DeliveryOrderVo implements Serializable {

    private static final long serialVersionUID = 1L;
    
    //快递公司code
    private String deliveryCompanyCode;

    //快递公司名称
    private String deliveryCompanyName;

    //快递单号
    private String deliveryOrderNo;

    //订单项目
    private List<OrderItemVo> orderItems;
    
    public String getDeliveryCompanyCode() {
        return deliveryCompanyCode;
    }

    public void setDeliveryCompanyCode(String deliveryCompanyCode) {
        this.deliveryCompanyCode = deliveryCompanyCode;
    }

    public String getDeliveryCompanyName() {
        return deliveryCompanyName;
    }

    public void setDeliveryCompanyName(String deliveryCompanyName) {
        this.deliveryCompanyName = deliveryCompanyName;
    }

    public String getDeliveryOrderNo() {
        return deliveryOrderNo;
    }

    public void setDeliveryOrderNo(String deliveryOrderNo) {
        this.deliveryOrderNo = deliveryOrderNo;
    }

    public List<OrderItemVo> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemVo> orderItems) {
        this.orderItems = orderItems;
    }
}
