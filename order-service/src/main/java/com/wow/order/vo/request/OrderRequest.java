package com.wow.order.vo.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import com.wow.common.request.ApiRequest;

/**
 * 订单请求接口类
 * 
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月12日 下午4:50:51 Exp $
 */
public class OrderRequest extends ApiRequest {

    private static final long serialVersionUID = 1L;

    @NotNull
    private Integer id;

    @NotNull
    private String orderCode;

    private Integer endUserId;

    private BigDecimal orderAmount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Integer getEndUserId() {
        return endUserId;
    }

    public void setEndUserId(Integer endUserId) {
        this.endUserId = endUserId;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

}
