package com.wow.mobileapi.request.order;

import java.util.List;

import com.wow.common.request.ApiRequest;

/**
 * 订单结算接口请求类
 * 
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月12日 下午4:50:51 Exp $
 */
public class OrderSettleRequest extends ApiRequest {

    private static final long serialVersionUID = 1L;

    //用户购买的购物车id列表
    private List<Integer> shoppingCartIds;
    
    //用户id
    private Integer endUserId;
    
    public Integer getEndUserId() {
        return endUserId;
    }

    public void setEndUserId(Integer endUserId) {
        this.endUserId = endUserId;
    }

    public List<Integer> getShoppingCartIds() {
        return shoppingCartIds;
    }

    public void setShoppingCartIds(List<Integer> shoppingCartIds) {
        this.shoppingCartIds = shoppingCartIds;
    }
}
