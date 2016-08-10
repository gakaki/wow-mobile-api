package com.wow.product.vo.request;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhengzhiqing on 16/7/21.
 */
public class ProductCreateRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private int categoryId;
    private String productName;
    private String sellingPoint;
    private String productModel;
    private int brandId;

    private int originCountryId;
    private String originCity;
    private int originProvinceId;
    private byte styleId;
    private short length;
    private short width;
    private short height;
    private String applicablePeople;
    private boolean canCustomized;
    private List<String> applicableSceneList;
    private List<Integer> materialList;
    private String detailDescription; //商品描述
    private List<DesignerVo> designerVoList;
    private List<ColorSpecVo> colorSpecVoList;
    private List<ProductImgVo> productImgVoList;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSellingPoint() {
        return sellingPoint;
    }

    public void setSellingPoint(String sellingPoint) {
        this.sellingPoint = sellingPoint;
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }



    /*public int getOriginCountryId() {
        return originCountryId;
    }

    public void setOriginCountryId(int originCountryId) {
        this.originCountryId = originCountryId;
    }*/

    public int getOriginCountryId() {
        return originCountryId;
    }

    public void setOriginCountryId(int originCountryId) {
        this.originCountryId = originCountryId;
    }

    public int getOriginProvinceId() {
        return originProvinceId;
    }

    public void setOriginProvinceId(int originProvinceId) {
        this.originProvinceId = originProvinceId;
    }

    public String getOriginCity() {
        return originCity;
    }

    public void setOriginCity(String originCity) {
        this.originCity = originCity;
    }

    public byte getStyleId() {
        return styleId;
    }

    public void setStyleId(byte styleId) {
        this.styleId = styleId;
    }

    public Short getLength() {
        return length;
    }

    public void setLength(Short length) {
        this.length = length;
    }

    public Short getWidth() {
        return width;
    }

    public void setWidth(Short width) {
        this.width = width;
    }

    public Short getHeight() {
        return height;
    }

    public void setHeight(Short height) {
        this.height = height;
    }

    public String getApplicablePeople() {
        return applicablePeople;
    }

    public void setApplicablePeople(String applicablePeople) {
        this.applicablePeople = applicablePeople;
    }

    public boolean isCanCustomized() {
        return canCustomized;
    }

    public void setCanCustomized(boolean canCustomized) {
        this.canCustomized = canCustomized;
    }

    public List<String> getApplicableSceneList() {
        return applicableSceneList;
    }

    public void setApplicableSceneList(List<String> applicableSceneList) {
        this.applicableSceneList = applicableSceneList;
    }

    public List<Integer> getMaterialList() {
        return materialList;
    }

    public void setMaterialList(List<Integer> materialList) {
        this.materialList = materialList;
    }

    public String getDetailDescription() {
        return detailDescription;
    }

    public void setDetailDescription(String detailDescription) {
        this.detailDescription = detailDescription;
    }

    public List<DesignerVo> getDesignerVoList() {
        return designerVoList;
    }

    public void setDesignerVoList(List<DesignerVo> designerVoList) {
        this.designerVoList = designerVoList;
    }

    public List<ColorSpecVo> getColorSpecVoList() {
        return colorSpecVoList;
    }

    public void setColorSpecVoList(List<ColorSpecVo> colorSpecVoList) {
        this.colorSpecVoList = colorSpecVoList;
    }

    public List<ProductImgVo> getProductImgVoList() {
        return productImgVoList;
    }

    public void setProductImgVoList(List<ProductImgVo> productImgVoList) {
        this.productImgVoList = productImgVoList;
    }
}
