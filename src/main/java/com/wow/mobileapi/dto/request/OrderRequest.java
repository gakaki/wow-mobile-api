package com.wow.mobileapi.dto.request;

import java.math.BigDecimal;

public class OrderRequest extends CommonRequest {

    /**  */
    private static final long serialVersionUID = 1L;
    
    private Integer id;

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
