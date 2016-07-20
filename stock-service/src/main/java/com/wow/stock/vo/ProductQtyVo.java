package com.wow.stock.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by zhengzhiqing on 16/6/30.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ProductQtyVo {

    private static final long serialVersionUID = 1L;

    private int productId;

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
