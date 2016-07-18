package com.wow.mobileapi.request.stock;

import com.wow.common.request.ApiRequest;

/**
 * Created by zhengzhiqing on 16/7/13.
 */
public class StockQueryRequest extends ApiRequest {

    private int productId;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
