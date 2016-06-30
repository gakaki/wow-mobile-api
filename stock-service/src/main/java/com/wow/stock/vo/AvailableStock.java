package com.wow.stock.vo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhengzhiqing on 16/6/30.
 */
public class AvailableStock {
    private int totalAvailableStockQty;
    private int availableVirtualStockQty;
    private int totalAvailableRealStockQty;
    //仓库有多少可用库存,用Map表示
    private Map<Integer, Integer> availableRealStockQtyMap = new HashMap<Integer,Integer>();

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

    public int getTotalAvailableRealStockQty() {
        return totalAvailableRealStockQty;
    }

    public void setTotalAvailableRealStockQty(int totalAvailableRealStockQty) {
        this.totalAvailableRealStockQty = totalAvailableRealStockQty;
    }

    public Map<Integer, Integer> getAvailableRealStockQtyMap() {
        return availableRealStockQtyMap;
    }

    public void setAvailableRealStockQtyMap(Map<Integer, Integer> availableRealStockQtyMap) {
        this.availableRealStockQtyMap = availableRealStockQtyMap;
    }
}
