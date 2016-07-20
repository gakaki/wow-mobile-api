package com.wow.stock.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;
import com.wow.stock.vo.FreezeStockVo;

/**
 * Created by zhengzhiqing on 16/6/30.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class FreezeStockResponse extends CommonResponse {

    private static final long serialVersionUID = 1L;

    private FreezeStockVo freezeStockVo;

    public FreezeStockVo getFreezeStockVo() {
        return freezeStockVo;
    }

    public void setFreezeStockVo(FreezeStockVo freezeStockVo) {
        this.freezeStockVo = freezeStockVo;
    }
}
