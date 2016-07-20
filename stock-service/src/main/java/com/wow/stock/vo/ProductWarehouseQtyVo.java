package com.wow.stock.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by zhengzhiqing on 16/6/30.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ProductWarehouseQtyVo extends ProductQtyVo {

    private static final long serialVersionUID = 1L;

    private int warehouseId;

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }
}
