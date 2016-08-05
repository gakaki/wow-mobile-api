package com.wow.user.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 用户购物车列表
 * 
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月14日 下午4:28:55 Exp $
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ShoppingCartResultVo implements Serializable {

    /**  */
    private static final long serialVersionUID = 1L;

    //购物车id
    private Integer shoppingCartId;

    //产品id
    private Integer productId;
    
    //父产品id
    private Integer parentProductId;

    //产品名称
    private String productName;

    //产品状态
    private Byte productStatus;

    //产品状态名称
    private String productStatusName;

    //产品销售价格
    private BigDecimal sellPrice;

    //产品数量范围为1-127
    private Byte productQty;

    //产品总价 产品销售价乘以数量
    private BigDecimal productTotalAmount;

    //产品当前可用库存数目 默认为0(即没有库存)
    private Short productStock = 0;

    //产品颜色
    private String color;

    //产品规格值
    private String specImg;

    //规格名
    private String specName;

    //用户是否选中
    private Boolean isSelected;
    
    public Integer getParentProductId() {
        return parentProductId;
    }

    public void setParentProductId(Integer parentProductId) {
        this.parentProductId = parentProductId;
    }

    public Boolean getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(Boolean isSelected) {
        this.isSelected = isSelected;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public BigDecimal getProductTotalAmount() {
        return productTotalAmount;
    }

    public void setProductTotalAmount(BigDecimal productTotalAmount) {
        this.productTotalAmount = productTotalAmount;
    }

    public Short getProductStock() {
        return productStock;
    }

    public void setProductStock(Short productStock) {
        this.productStock = productStock;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductStatusName() {
        return productStatusName;
    }

    public void setProductStatusName(String productStatusName) {
        this.productStatusName = productStatusName;
    }

    public Byte getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Byte productStatus) {
        this.productStatus = productStatus;
    }

    public Integer getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(Integer shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
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

    public String getSpecImg() {
        return specImg;
    }

    public void setSpecImg(String specImg) {
        this.specImg = specImg;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

}
