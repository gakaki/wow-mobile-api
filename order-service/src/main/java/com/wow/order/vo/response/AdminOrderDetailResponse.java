package com.wow.order.vo.response;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;
import com.wow.order.vo.AdminDeliveryOrderVo;
import com.wow.order.vo.AdminOrderItemVo;

/**
 * 后台订单明细接口响应类
 * 
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月11日 下午6:49:05 Exp $
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class AdminOrderDetailResponse extends CommonResponse {

    private static final long serialVersionUID = 1L;

    //订单id
    private Integer orderId;

    //订单号
    private String orderCode;

    //收货人名称
    private String receiverName;

    //收款人手机号码
    private String receiverMobile;

    //收款人详细地址 省市区加详细地址
    private String receiverAddress;

    //订单总价
    private BigDecimal orderAmount;

    //订单状态
    private Byte orderStatus;

    //订单状态名称
    private String orderStatusName;

    //支付状态
    private Byte paymentStatus;

    //支付状态名称
    private String paymentStatusName;

    //支付方式
    private Byte paymentMethod;

    //支付方式名称
    private String paymentMethodName;

    //订单运费
    private BigDecimal deliveryFee;

    //订单优惠金额
    private BigDecimal couponAmount;

    //订单支付金额
    private BigDecimal paidAmount;

    //订单创建时间
    private String orderCreateTimeFormat;

    //商品清单列表
    private List<AdminOrderItemVo> orderItems;

    //物流信息列表
    private List<AdminDeliveryOrderVo> deliveryOrders;

    public List<AdminDeliveryOrderVo> getDeliveryOrders() {
        return deliveryOrders;
    }

    public void setDeliveryOrders(List<AdminDeliveryOrderVo> deliveryOrders) {
        this.deliveryOrders = deliveryOrders;
    }

    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
    }

    public List<AdminOrderItemVo> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<AdminOrderItemVo> orderItems) {
        this.orderItems = orderItems;
    }

    public String getPaymentMethodName() {
        return paymentMethodName;
    }

    public void setPaymentMethodName(String paymentMethodName) {
        this.paymentMethodName = paymentMethodName;
    }

    public String getPaymentStatusName() {
        return paymentStatusName;
    }

    public void setPaymentStatusName(String paymentStatusName) {
        this.paymentStatusName = paymentStatusName;
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

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
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

    public Byte getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Byte paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Byte getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Byte paymentMethod) {
        this.paymentMethod = paymentMethod;
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

    public BigDecimal getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(BigDecimal couponAmount) {
        this.couponAmount = couponAmount;
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
