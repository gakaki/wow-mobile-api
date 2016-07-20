package com.wow.stock.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Created by zhengzhiqing on 16/6/30.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class UnfreezeStockVo {

    private static final long serialVersionUID = 1L;

    List<ProductQtyVo> productQtyVoList;

    List<ProductWarehouseQtyVo> productWarehouseQtyVoList;

    public List<ProductQtyVo> getProductQtyVoList() {
        return productQtyVoList;
    }

    public void setProductQtyVoList(List<ProductQtyVo> productQtyVoList) {
        this.productQtyVoList = productQtyVoList;
    }

    public List<ProductWarehouseQtyVo> getProductWarehouseQtyVoList() {
        return productWarehouseQtyVoList;
    }

    public void setProductWarehouseQtyVoList(List<ProductWarehouseQtyVo> productWarehouseQtyVoList) {
        this.productWarehouseQtyVoList = productWarehouseQtyVoList;
    }
}
