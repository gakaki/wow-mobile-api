package com.wow.mobileapi.response.product;

import com.wow.product.vo.request.SpecVo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by zhengzhiqing on 16/7/23.
 */
public class ColorSpecVo implements Serializable {

    private static final long serialVersionUID = 1L;


    private String colorDisplayName;

    private List<SpecMapVo> specMapVoList;

    public String getColorDisplayName() {
        return colorDisplayName;
    }

    public void setColorDisplayName(String colorDisplayName) {
        this.colorDisplayName = colorDisplayName;
    }

    public List<SpecMapVo> getSpecMapVoList() {
        return specMapVoList;
    }

    public void setSpecMapVoList(List<SpecMapVo> specMapVoList) {
        this.specMapVoList = specMapVoList;
    }
}

