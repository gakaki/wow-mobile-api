package com.wow.mobileapi.response.product;

import java.io.Serializable;

/**
 * Created by zhengzhiqing on 16/7/23.
 */
public class ColorMapVo implements Serializable {

    private static final long serialVersionUID = 1L;


    private String colorDisplayName;

    private SubProductInfo subProductInfo;

    public String getColorDisplayName() {
        return colorDisplayName;
    }

    public void setColorDisplayName(String colorDisplayName) {
        this.colorDisplayName = colorDisplayName;
    }

    public SubProductInfo getSubProductInfo() {
        return subProductInfo;
    }

    public void setSubProductInfo(SubProductInfo subProductInfo) {
        this.subProductInfo = subProductInfo;
    }
}

