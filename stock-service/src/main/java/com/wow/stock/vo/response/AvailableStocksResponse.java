package com.wow.stock.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;
import com.wow.stock.vo.AvailableStockVo;

import java.util.Map;

/**
 * Created by zhengzhiqing on 16/6/30.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class AvailableStocksResponse extends CommonResponse {

    private static final long serialVersionUID = 1L;

    private Map<Integer, AvailableStockVo> availableStockVoMap;

    public Map<Integer, AvailableStockVo> getAvailableStockVoMap() {
        return availableStockVoMap;
    }

    public void setAvailableStockVoMap(Map<Integer, AvailableStockVo> availableStockVoMap) {
        this.availableStockVoMap = availableStockVoMap;
    }
}
