package com.wow.order.vo.response;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.constant.CommonConstant;
import com.wow.common.response.CommonResponse;
import com.wow.order.vo.OrderSettleVo;


/**
 * 订单结算接口响应类
 * 
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月11日 下午6:49:05 Exp $
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class OrderSettleResponse extends CommonResponse {

    private static final long serialVersionUID = 1L;
    
    //结算产品列表
    private List<OrderSettleVo> orderSettles;
    
    //订单运费 默认为0.00
    private BigDecimal deliveryFee=CommonConstant.ZEROB_IGDECIMAL;
    
    //订单总价
    private BigDecimal totalAmount;

    public List<OrderSettleVo> getOrderSettles() {
        return orderSettles;
    }

    public void setOrderSettles(List<OrderSettleVo> orderSettles) {
        this.orderSettles = orderSettles;
    }

    public BigDecimal getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(BigDecimal deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

}
