package com.wow.stock.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by zhengzhiqing on 16/6/30.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ProductQtyVo implements Serializable {

    private static final long serialVersionUID = 1L;

    //产品id
    private int productId;

    //请求冻结的产品数量
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
