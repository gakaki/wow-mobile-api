package com.wow.stock.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;

import java.util.Map;

/**
 * Created by zhengzhiqing on 16/6/30.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class AvailableStockVo extends CommonResponse {

    private static final long serialVersionUID = 1L;

    private long totalAvailableStockQty;
    private long availableVirtualStockQty;
    private long totalAvailableRealStockQty;
    //仓库有多少可用库存,用Map表示
    private Map<Integer, Integer> availableRealStockQtyMap;

    public long getTotalAvailableStockQty() {
        return totalAvailableStockQty;
    }

    public void setTotalAvailableStockQty(long totalAvailableStockQty) {
        this.totalAvailableStockQty = totalAvailableStockQty;
    }

    public long getAvailableVirtualStockQty() {
        return availableVirtualStockQty;
    }

    public void setAvailableVirtualStockQty(long availableVirtualStockQty) {
        this.availableVirtualStockQty = availableVirtualStockQty;
    }

    public long getTotalAvailableRealStockQty() {
        return totalAvailableRealStockQty;
    }

    public void setTotalAvailableRealStockQty(long totalAvailableRealStockQty) {
        this.totalAvailableRealStockQty = totalAvailableRealStockQty;
    }

    public Map<Integer, Integer> getAvailableRealStockQtyMap() {
        return availableRealStockQtyMap;
    }

    public void setAvailableRealStockQtyMap(Map<Integer, Integer> availableRealStockQtyMap) {
        this.availableRealStockQtyMap = availableRealStockQtyMap;
    }
}
