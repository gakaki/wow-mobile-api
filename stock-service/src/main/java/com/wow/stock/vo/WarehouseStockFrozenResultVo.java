package com.wow.stock.vo;

import java.io.Serializable;

/**
 * Created by zhengzhiqing on 16/7/15.
 */
public class WarehouseStockFrozenResultVo implements Serializable{

    private static final long serialVersionUID = 1L;

    //产品id
    private int productId;
    
    //仓库id
    private int warehouseId;
    
    //冻结的库存个数
    private int frozenStock;

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

    public int getFrozenStock() {
        return frozenStock;
    }

    public void setFrozenStock(int frozenStock) {
        this.frozenStock = frozenStock;
    }
}
