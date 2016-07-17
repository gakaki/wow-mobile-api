package com.wow.order.vo;

import java.util.List;

/**
 * 
 * 订单结算查询类
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月17日 上午11:42:47 Exp $
 */
public class OrderSettleQuery {
    //用户购买的购物车id列表
    private List<Integer> shoppingCartIds;
    
    //用户id
    private Integer endUserId;

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
