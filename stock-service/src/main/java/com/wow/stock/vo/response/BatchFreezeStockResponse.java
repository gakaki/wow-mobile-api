package com.wow.stock.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;
import com.wow.stock.vo.FreezeStockVo;

import java.util.List;

/**
 * Created by zhengzhiqing on 16/6/30.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class BatchFreezeStockResponse extends CommonResponse {

    private static final long serialVersionUID = 1L;

    private List<FreezeStockVo> freezeStockVoList;

    public List<FreezeStockVo> getFreezeStockVoList() {
        return freezeStockVoList;
    }

    public void setFreezeStockVoList(List<FreezeStockVo> freezeStockVoList) {
        this.freezeStockVoList = freezeStockVoList;
    }
}
