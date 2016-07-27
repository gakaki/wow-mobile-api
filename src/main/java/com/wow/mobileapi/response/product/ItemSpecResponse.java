package com.wow.mobileapi.response.product;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fangying@wowdsgn on 2016/7/14.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ItemSpecResponse extends CommonResponse {

    private static final long serialVersionUID = 1L;
    //主品ID
    private int productId;
    //产品名
    private String productName;
    //尺寸
    private String sizeText;

    //颜色集合
    private List<String> colorDisplayNameList;
    //规格集合
    private List<String> specNameList;

    //子品特有的信息,如颜色,规格,重量,尺寸,价格,库存等
    List<SubProductInfo> subProductInfoList;

    //按颜色做成Map
    List<ColorSpecVo> colorSpecVoList;
    //按规格做成Map
    List<SpecColorVo> specColorVoList;

    public List<SpecColorVo> getSpecColorVoList() {
        return specColorVoList;
    }

    public void setSpecColorVoList(List<SpecColorVo> specColorVoList) {
        this.specColorVoList = specColorVoList;
    }

    public List<ColorSpecVo> getColorSpecVoList() {
        return colorSpecVoList;
    }

    public void setColorSpecVoList(List<ColorSpecVo> colorSpecVoList) {
        this.colorSpecVoList = colorSpecVoList;
    }

    public List<String> getColorDisplayNameList() {
        return colorDisplayNameList;
    }

    public void setColorDisplayNameList(List<String> colorDisplayNameList) {
        this.colorDisplayNameList = colorDisplayNameList;
    }

    public List<String> getSpecNameList() {
        return specNameList;
    }

    public void setSpecNameList(List<String> specNameList) {
        this.specNameList = specNameList;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSizeText() {
        return sizeText;
    }

    public void setSizeText(String sizeText) {
        this.sizeText = sizeText;
    }

    public List<SubProductInfo> getSubProductInfoList() {
        return subProductInfoList;
    }

    public void setSubProductInfoList(List<SubProductInfo> subProductInfoList) {
        this.subProductInfoList = subProductInfoList;
    }

}
