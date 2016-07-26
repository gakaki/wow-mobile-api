package com.wow.order.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 订单项目vo
 * 
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月15日 下午6:21:56 Exp $
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class OrderItemVo implements Serializable {
    
    private static final long serialVersionUID = 1L;

    //用户购买的产品id
    private Integer productId;
    
    //发货单产品id
    private Integer deliveryOrderId;

    //产品名称
    private String productName;
    
    //用户购买的产品数量 范围为1-127
    private Byte productQty;
    
    //产品销售价格 单价
    private BigDecimal sellPrice;
    
    //产品总价 产品销售价乘以数量
    private BigDecimal sellTotalAmount;
    
    //产品颜色
    private String color;

    //产品规格值
    private String spec;
    
    //产品规格图片
    private String specImg;
    
    //是否需要发货
    @JsonIgnore
    private Boolean isShippedOut;
    
    public Boolean getIsShippedOut() {
        return isShippedOut;
    }

    public void setIsShippedOut(Boolean isShippedOut) {
        this.isShippedOut = isShippedOut;
    }

    public Integer getDeliveryOrderId() {
        return deliveryOrderId;
    }

    public void setDeliveryOrderId(Integer deliveryOrderId) {
        this.deliveryOrderId = deliveryOrderId;
    }

    public String getSpecImg() {
        return specImg;
    }

    public void setSpecImg(String specImg) {
        this.specImg = specImg;
    }

    public BigDecimal getSellTotalAmount() {
        return sellTotalAmount;
    }

    public void setSellTotalAmount(BigDecimal sellTotalAmount) {
        this.sellTotalAmount = sellTotalAmount;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Byte getProductQty() {
        return productQty;
    }

    public void setProductQty(Byte productQty) {
        this.productQty = productQty;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }
}
