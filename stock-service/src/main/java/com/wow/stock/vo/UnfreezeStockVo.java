package com.wow.stock.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Created by zhengzhiqing on 16/6/30.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class UnfreezeStockVo {

    private static final long serialVersionUID = 1L;

    private int productId;

    //虚拟库存
    private int virtualProductQty;

    //仓库库存仓库库存
    List<ProductWarehouseQtyVo> productWarehouseQtyVoList;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getVirtualProductQty() {
        return virtualProductQty;
    }

    public void setVirtualProductQty(int virtualProductQty) {
        this.virtualProductQty = virtualProductQty;
    }

    public List<ProductWarehouseQtyVo> getProductWarehouseQtyVoList() {
        return productWarehouseQtyVoList;
    }

    public void setProductWarehouseQtyVoList(List<ProductWarehouseQtyVo> productWarehouseQtyVoList) {
        this.productWarehouseQtyVoList = productWarehouseQtyVoList;
    }
}
