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
public class AdminOrderItemVo implements Serializable {

    private static final long serialVersionUID = 1L;

    //订单id
    @JsonIgnore
    private Integer saleOrderId;

    //订单项目id
    private Integer saleOrderItemId;

    //用户购买的产品id
    private Integer productId;

    //产品名称
    private String productName;

    //用户购买的产品数量 范围为1-127
    private Byte productQty;

    //产品销售价格 单价
    private BigDecimal sellPrice;

    //产品总价 产品销售价乘以数量
    private BigDecimal productTotalAmount;

    //产品颜色
    private String color;

    //产品规格值
    private String specName;

    //产品规格图片
    private String specImg;
    
    public Integer getSaleOrderId() {
        return saleOrderId;
    }

    public void setSaleOrderId(Integer saleOrderId) {
        this.saleOrderId = saleOrderId;
    }

    public Integer getSaleOrderItemId() {
        return saleOrderItemId;
    }

    public void setSaleOrderItemId(Integer saleOrderItemId) {
        this.saleOrderItemId = saleOrderItemId;
    }

    public String getSpecImg() {
        return specImg;
    }

    public void setSpecImg(String specImg) {
        this.specImg = specImg;
    }

    public BigDecimal getProductTotalAmount() {
        return productTotalAmount;
    }

    public void setProductTotalAmount(BigDecimal productTotalAmount) {
        this.productTotalAmount = productTotalAmount;
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

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }
}
