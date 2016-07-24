package com.wow.mobileapi.request.order;

import java.util.List;

import com.wow.common.request.ApiRequest;

/**
 * 订单拆分接口请求类
 * 
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月12日 下午4:50:51 Exp $
 */
public class OrderSplitRequest extends ApiRequest {

    private static final long serialVersionUID = 1L;

    //订单项目id列表
    private List<Integer> saleOrderItemIds;
    
    //用户id
    private Integer endUserId;
    
    //订单id
    private Integer orderId;
    
  //物流公司代码
    private String deliveryCompanyCode;
    
    //运单号
    private String deliveryOrderNo;

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
