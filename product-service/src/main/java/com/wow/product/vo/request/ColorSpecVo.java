package com.wow.product.vo.request;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhengzhiqing on 16/7/21.
 */
public class ColorSpecVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Byte colorId;
    private String productColorImg;
    private String colorDisplayName;

    List<SpecVo> specVoList;

    public Byte getColorId() {
        return colorId;
    }

    public void setColorId(Byte colorId) {
        this.colorId = colorId;
    }

    public String getProductColorImg() {
        return productColorImg;
    }

    public void setProductColorImg(String productColorImg) {
        this.productColorImg = productColorImg;
    }

    public String getColorDisplayName() {
        return colorDisplayName;
    }

    public void setColorDisplayName(String colorDisplayName) {
        this.colorDisplayName = colorDisplayName;
    }

    public List<SpecVo> getSpecVoList() {
        return specVoList;
    }

    public void setSpecVoList(List<SpecVo> specVoList) {
        this.specVoList = specVoList;
    }
}
