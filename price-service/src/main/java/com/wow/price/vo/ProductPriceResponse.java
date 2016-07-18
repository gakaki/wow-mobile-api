package com.wow.price.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;
import com.wow.price.model.ProductPrice;

/**
 * Created by zhengzhiqing on 16/7/16.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ProductPriceResponse extends CommonResponse {
    private static final long serialVersionUID = 1L;

    private ProductPrice productPrice;

    public ProductPrice getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(ProductPrice productPrice) {
        this.productPrice = productPrice;
    }
}
