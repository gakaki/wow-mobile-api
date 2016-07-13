package com.wow.user.vo.request;

import javax.validation.constraints.NotNull;

import com.wow.common.request.ApiRequest;

/**
 * 购物车相关请求类
 * 
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月12日 下午4:50:51 Exp $
 */
public class ShoppingCartRequest extends ApiRequest {
    
    private static final long serialVersionUID = 1L;
    
    //用户id
    private Integer endUserId;

    //产品id
    @NotNull
    private Integer productId;

    //产品数量范围为1-127
    @NotNull
    private Byte productQty;
    
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
