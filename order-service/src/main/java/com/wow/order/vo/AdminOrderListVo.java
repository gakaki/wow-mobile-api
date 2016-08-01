package com.wow.order.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 订单列表vo
 * 
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月15日 下午6:21:56 Exp $
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class AdminOrderListVo implements Serializable {
    /**  */
    private static final long serialVersionUID = 1L;

    //订单id
    private Integer orderId;

    //订单号
    private String orderCode;

    //订单总价
    private BigDecimal orderAmount;
    
    //订单运费
    private BigDecimal deliveryFee;

    //订单状态
    private Byte orderStatus;

    //订单状态名称
    private String orderStatusName;
    
    //收货人姓名
    private String receiverName;
    
    //收货人手机号码
    private String receiverMobile;

    //订单创建时间
    @JsonIgnore
    private Date orderCreateTime;

    //订单创建时间
    private String orderCreateTimeFormat;
    
    //订单产品list
    private List<AdminOrderItemVo> orderItemVos;
    
    public List<AdminOrderItemVo> getOrderItemVos() {
        return orderItemVos;
    }

    public void setOrderItemVos(List<AdminOrderItemVo> orderItemVos) {
        this.orderItemVos = orderItemVos;
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

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Byte getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Byte orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatusName() {
        return orderStatusName;
    }

    public void setOrderStatusName(String orderStatusName) {
        this.orderStatusName = orderStatusName;
    }

    public Date getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(Date orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public String getOrderCreateTimeFormat() {
        return orderCreateTimeFormat;
    }

    public void setOrderCreateTimeFormat(String orderCreateTimeFormat) {
        this.orderCreateTimeFormat = orderCreateTimeFormat;
    }

    public BigDecimal getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(BigDecimal deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

}
