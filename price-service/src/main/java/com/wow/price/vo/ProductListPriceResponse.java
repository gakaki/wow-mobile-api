package com.wow.price.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;
import com.wow.price.model.ProductPrice;

import java.util.Map;

/**
 * Created by zhengzhiqing on 16/7/16.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ProductListPriceResponse extends CommonResponse {
    private static final long serialVersionUID = 1L;

    private Map<Integer, ProductPrice> map;

    public Map<Integer, ProductPrice> getMap() {
        return map;
    }

    public void setMap(Map<Integer, ProductPrice> map) {
        this.map = map;
    }
}
