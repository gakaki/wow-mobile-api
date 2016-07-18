package com.wow.stock.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;
import com.wow.stock.vo.AvailableStockVo;

import java.util.Map;

/**
 * Created by zhengzhiqing on 16/6/30.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class AvailableStockResponse extends CommonResponse {

    private static final long serialVersionUID = 1L;

    private AvailableStockVo availableStockVo;

    public AvailableStockVo getAvailableStockVo() {
        return availableStockVo;
    }

    public void setAvailableStockVo(AvailableStockVo availableStockVo) {
        this.availableStockVo = availableStockVo;
    }
}
