package com.wow.mobileapi.response.product;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhengzhiqing on 16/7/23.
 */
public class SpecColorVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String specName;

    private List<ColorMapVo> colorMapVoList;

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public List<ColorMapVo> getColorMapVoList() {
        return colorMapVoList;
    }

    public void setColorMapVoList(List<ColorMapVo> colorMapVoList) {
        this.colorMapVoList = colorMapVoList;
    }
}

