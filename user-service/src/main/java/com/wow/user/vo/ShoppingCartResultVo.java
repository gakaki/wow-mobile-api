package com.wow.user.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import com.wow.common.enums.ProductStatusEnum;

/**
 * 用户购物车列表
 * 
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月14日 下午4:28:55 Exp $
 */
public class ShoppingCartResultVo implements Serializable{
    
    /**  */
    private static final long serialVersionUID = 1L;

    //购物车id
    private Integer shoppingCartId;
    
    //产品id
    private Integer productId;
    
    //产品数量范围为1-127
    private Byte productQty;
    
    //产品名称
    private String productName;
    
    //产品颜色
    private String color;
    
    //产品规格值
    private String spec;
    
    //产品状态
    private Byte productStatus;
    
    //产品状态名称
    @SuppressWarnings("unused")
    private String productStatusName;
    
    //产品销售价格
    private BigDecimal sellPrice;
    
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductStatusName() {
        return ProductStatusEnum.get((int)productStatus);
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
