package com.wow.stock.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhengzhiqing on 16/6/30.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class AvailableStockVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private int productId;
    private int totalAvailableStockQty;
    private int availableVirtualStockQty;
    private int totalAvailableWarehouseStockQty;
    //仓库有多少可用库存,用list表示
    private List<WarehouseStockVo> warehouseStockVoList;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getTotalAvailableStockQty() {
        return totalAvailableStockQty;
    }

    public void setTotalAvailableStockQty(int totalAvailableStockQty) {
        this.totalAvailableStockQty = totalAvailableStockQty;
    }

    public int getAvailableVirtualStockQty() {
        return availableVirtualStockQty;
    }

    public void setAvailableVirtualStockQty(int availableVirtualStockQty) {
        this.availableVirtualStockQty = availableVirtualStockQty;
    }

    public int getTotalAvailableWarehouseStockQty() {
        return totalAvailableWarehouseStockQty;
    }

    public void setTotalAvailableWarehouseStockQty(int totalAvailableWarehouseStockQty) {
        this.totalAvailableWarehouseStockQty = totalAvailableWarehouseStockQty;
    }

    public List<WarehouseStockVo> getWarehouseStockVoList() {
        return warehouseStockVoList;
    }

    public void setWarehouseStockVoList(List<WarehouseStockVo> warehouseStockVoList) {
        this.warehouseStockVoList = warehouseStockVoList;
    }
}
