package com.wow.mobileapi.request.stock;

import com.wow.common.request.ApiRequest;

import javax.validation.constraints.NotNull;

/**
 * Created by zhengzhiqing on 16/7/13.
 */
public class StockFreezeRequest extends ApiRequest {

    private static final long serialVersionUID = 1L;

    @NotNull
    private int productId;

    @NotNull
    private int productQty;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductQty() {
        return productQty;
    }

    public void setProductQty(int productQty) {
        this.productQty = productQty;
    }
}
