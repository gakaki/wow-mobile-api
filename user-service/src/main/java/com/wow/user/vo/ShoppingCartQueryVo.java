package com.wow.user.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 购物车相关请求类
 * 
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月12日 下午4:50:51 Exp $
 */
public class ShoppingCartQueryVo implements Serializable {

    private static final long serialVersionUID = 1L;

    //购物车id(修改购物车产品数量时使用)
    private Integer shoppingCartId;

    //用户id
    private Integer endUserId;

    //产品id
    private Integer productId;

    //产品数量范围为1-127
    private Byte productQty;

    //购物车id列表 仅在删除购物车产品时使用
    private List<Integer> shoppingCartIds;

    //是否删除
    private Boolean isDeleted;

    //是否选中
    private Boolean isSelected;

    //更新时间 修改购物车数量和删除购物车信息时使用
    private Date updateTime;
    
    //产品销售价快照  保存到购物车时使用
    private BigDecimal sellPrice;
    
    //产品重量快照 保存到购物车时使用
    private BigDecimal weight;
    
    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public Boolean getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(Boolean isSelected) {
        this.isSelected = isSelected;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public List<Integer> getShoppingCartIds() {
        return shoppingCartIds;
    }

    public void setShoppingCartIds(List<Integer> shoppingCartIds) {
        this.shoppingCartIds = shoppingCartIds;
    }

    public Integer getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(Integer shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public Integer getEndUserId() {
        return endUserId;
    }

    public void setEndUserId(Integer endUserId) {
        this.endUserId = endUserId;
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

}
