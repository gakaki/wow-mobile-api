package com.wow.order.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * 购物车结算查询类
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月17日 上午11:42:47 Exp $
 */
public class OrderSettleQuery implements Serializable {
    /**  */
    private static final long serialVersionUID = 1L;
    
    //产品id 立即购买使用
    private Integer productId;
    
    //用户购买的产品数量 范围为1-127 默认为1  立即购买使用
    private Byte productQty;

    //用户购买的购物车id列表
    private List<Integer> shoppingCartIds;
    
    //用户id
    private Integer endUserId;
    
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

    public List<Integer> getShoppingCartIds() {
        return shoppingCartIds;
    }

    public void setShoppingCartIds(List<Integer> shoppingCartIds) {
        this.shoppingCartIds = shoppingCartIds;
    }

    public Integer getEndUserId() {
        return endUserId;
    }

    public void setEndUserId(Integer endUserId) {
        this.endUserId = endUserId;
    }

}
