package com.wow.mobileapi.request.product;

import com.wow.common.request.ApiRequest;

import javax.validation.constraints.NotNull;

/**
 * Created by zhengzhiqing on 16/7/21.
 */
public class ProductQueryRequest extends ApiRequest {

    private static final long serialVersionUID = 1L;

    @NotNull
    private int productId;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
