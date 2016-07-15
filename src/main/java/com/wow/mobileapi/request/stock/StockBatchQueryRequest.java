package com.wow.mobileapi.request.stock;

import com.wow.common.request.ApiRequest;

import java.util.List;

/**
 * Created by zhengzhiqing on 16/7/13.
 */
public class StockBatchQueryRequest extends ApiRequest {

    List<Integer> productIdList;

    public List<Integer> getProductIdList() {
        return productIdList;
    }

    public void setProductIdList(List<Integer> productIdList) {
        this.productIdList = productIdList;
    }
}
