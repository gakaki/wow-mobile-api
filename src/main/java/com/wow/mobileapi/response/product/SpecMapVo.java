package com.wow.mobileapi.response.product;

import com.wow.product.vo.request.SpecVo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhengzhiqing on 16/7/23.
 */
public class SpecMapVo implements Serializable {

    private static final long serialVersionUID = 1L;


    private String specName;

    private SubProductInfo subProductInfo;

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public SubProductInfo getSubProductInfo() {
        return subProductInfo;
    }

    public void setSubProductInfo(SubProductInfo subProductInfo) {
        this.subProductInfo = subProductInfo;
    }
}

