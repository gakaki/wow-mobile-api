package com.wow.stock.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhengzhiqing on 16/6/30.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class FreezeStockVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private int productId;

    //冻结的真实库存
    private int frozenWarehouseStockTotalQty;

    //冻结的虚拟库存 只有真实库存不存在的情况下才会冻结虚拟库存
    private int frozenVirtualStockQty;

    private List<WarehouseStockFrozenResultVo> warehouseStockFrozenResultVoList;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getFrozenWarehouseStockTotalQty() {
        return frozenWarehouseStockTotalQty;
    }

    public void setFrozenWarehouseStockTotalQty(int frozenWarehouseStockTotalQty) {
        this.frozenWarehouseStockTotalQty = frozenWarehouseStockTotalQty;
    }

    public int getFrozenVirtualStockQty() {
        return frozenVirtualStockQty;
    }

    public void setFrozenVirtualStockQty(int frozenVirtualStockQty) {
        this.frozenVirtualStockQty = frozenVirtualStockQty;
    }

    public List<WarehouseStockFrozenResultVo> getWarehouseStockFrozenResultVoList() {
        return warehouseStockFrozenResultVoList;
    }

    public void setWarehouseStockFrozenResultVoList(List<WarehouseStockFrozenResultVo> warehouseStockFrozenResultVoList) {
        this.warehouseStockFrozenResultVoList = warehouseStockFrozenResultVoList;
    }
}
