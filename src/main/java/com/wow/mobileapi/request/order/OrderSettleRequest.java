package com.wow.mobileapi.request.order;

import com.wow.common.request.ApiRequest;

/**
 * 订单结算接口请求类
 * 
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月12日 下午4:50:51 Exp $
 */
public class OrderSettleRequest extends ApiRequest {

    private static final long serialVersionUID = 1L;

    //产品id 立即购买使用
    private Integer productId;

    //用户购买的产品数量 范围为1-127 默认为1  立即购买使用
    private Byte productQty;

    //用户id
    private Integer endUserId;

    public Integer getProductId() {
        return productId;
    }

    public void setProductIds(Integer productId) {
        this.productId = productId;
    }

    public Byte getProductQty() {
        return productQty;
    }

    public void setProductQty(Byte productQty) {
        this.productQty = productQty;
    }

    public Integer getEndUserId() {
        return endUserId;
    }

    public void setEndUserId(Integer endUserId) {
        this.endUserId = endUserId;
    }
}
