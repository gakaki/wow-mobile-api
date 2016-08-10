package com.wow.stock.vo;

import java.io.Serializable;

/**
 * Created by zhengzhiqing on 16/7/15.
 */
public class VirtualStockVo implements Serializable{

    /**  */
    private static final long serialVersionUID = 1L;
    private int productId;
    private int availableVirtualStock;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getAvailableVirtualStock() {
        return availableVirtualStock;
    }

    public void setAvailableVirtualStock(int availableVirtualStock) {
        this.availableVirtualStock = availableVirtualStock;
    }
}
