package com.wow.stock.vo;

import java.io.Serializable;

/**
 * Created by zhengzhiqing on 16/7/15.
 */
public class WarehouseStockVo implements Serializable{

    private int productId;
    private int warehouseId;
    private int availableStock;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public int getAvailableStock() {
        return availableStock;
    }

    public void setAvailableStock(int availableStock) {
        this.availableStock = availableStock;
    }
}
