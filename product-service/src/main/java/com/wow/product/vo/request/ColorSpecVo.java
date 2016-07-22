package com.wow.product.vo.request;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhengzhiqing on 16/7/21.
 */
public class ColorSpecVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private int colorId;
    private String colorDisplayName;
    private String colorImgUrl;

    List<SpecVo> specVoList;

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public String getColorDisplayName() {
        return colorDisplayName;
    }

    public void setColorDisplayName(String colorDisplayName) {
        this.colorDisplayName = colorDisplayName;
    }

    public String getColorImgUrl() {
        return colorImgUrl;
    }

    public void setColorImgUrl(String colorImgUrl) {
        this.colorImgUrl = colorImgUrl;
    }

    public List<SpecVo> getSpecVoList() {
        return specVoList;
    }

    public void setSpecVoList(List<SpecVo> specVoList) {
        this.specVoList = specVoList;
    }
}
