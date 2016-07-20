package com.wow.stock.vo.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;
import com.wow.stock.vo.AvailableStockVo;

/**
 * Created by zhengzhiqing on 16/6/30.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class AvailableStocksResponse extends CommonResponse {

    private static final long serialVersionUID = 1L;

    private List<AvailableStockVo> availableStockVoList;

    public List<AvailableStockVo> getAvailableStockVoList() {
        return availableStockVoList;
    }

    public void setAvailableStockVoList(List<AvailableStockVo> availableStockVoList) {
        this.availableStockVoList = availableStockVoList;
    }
}
