package com.wow.stock.vo;

/**
 * Created by zhengzhiqing on 16/6/30.
 */
public class ProductWarehouseQtyVo {

    private static final long serialVersionUID = 1L;

    private int warehouseId;

    private int productQty;

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public int getProductQty() {
        return productQty;
    }

    public void setProductQty(int productQty) {
        this.productQty = productQty;
    }
}
