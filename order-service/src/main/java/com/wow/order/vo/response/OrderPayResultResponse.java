package com.wow.order.vo.response;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;

/**
 * 订单支付结果接口响应类
 * 
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月11日 下午6:49:05 Exp $
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class OrderPayResultResponse extends CommonResponse {

    private static final long serialVersionUID = 1L;

    //订单号
    private String orderCode;

    //订单总价 实际支付的金额
    private BigDecimal payAmount;

    //支付方式
    private String paymentChannel;

    //支付方式名称
    private String paymentChannelName;
    
    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public String getPaymentChannel() {
        return paymentChannel;
    }

    public void setPaymentChannel(String paymentChannel) {
        this.paymentChannel = paymentChannel;
    }

    public String getPaymentChannelName() {
        return paymentChannelName;
    }

    public void setPaymentChannelName(String paymentChannelName) {
        this.paymentChannelName = paymentChannelName;
    }

}
