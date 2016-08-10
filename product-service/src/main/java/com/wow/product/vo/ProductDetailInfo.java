package com.wow.product.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.product.model.Product;
import com.wow.product.model.ProductApplicableScene;
import com.wow.product.model.ProductDesigner;
import com.wow.product.model.ProductMaterial;
import com.wow.product.vo.request.DesignerVo;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDetailInfo {
    private Integer categoryId;
    private String productName;
    private String sellingPoint;
    private String productModel;
    private Integer brandId;
    private List<DesignerVo> designerVoList;
    private Integer originCountryId;
    private String originCity;
    private Integer originProvinceId;
    private Byte styleId;
    private Short length;
    private Short width;
    private Short height;
    private String applicablePeople;
    private Boolean canCustomized;
    private List<String> applicableSceneList;
    private List<Integer> materialList;
    private String detailDescription;

    public void setupBaseInfo(Product product) {
        setCategoryId(product.getCategoryId());
        setProductName(product.getProductName());
        setSellingPoint(product.getSellingPoint());
        setProductModel(product.getProductModel());
        setBrandId(product.getBrandId());
        setOriginCountryId(product.getOriginCountryId());
        setOriginCity(product.getOriginCity());
        setOriginProvinceId(product.getOriginProvinceId());
        setStyleId(product.getStyleId());
        setLength(product.getLength());
        setWidth(product.getWidth());
        setHeight(product.getHeight());
        setApplicablePeople(product.getApplicablePeople());
        setCanCustomized(product.getCanCustomized());
        setDetailDescription(product.getDetailDescription());
    }

    public void setupDesigners(List<ProductDesigner> designers) {
        List<DesignerVo> designerVoList = new ArrayList<>(designers.size());
        for (ProductDesigner designer : designers) {
            DesignerVo designerVo = new DesignerVo();
            designerVo.setDesignerId(designer.getDesignerId());
            designerVo.setPrimary(designer.getIsPrimary());
            designerVoList.add(designerVo);
        }
        setDesignerVoList(designerVoList);
    }

    public void setupMaterials(List<ProductMaterial> productMaterials) {
        List<Integer> materialList = new ArrayList<>(productMaterials.size());
        for (ProductMaterial productMaterial : productMaterials) {
            materialList.add(productMaterial.getMaterialId());
        }
        setMaterialList(materialList);
    }

    public void setupApplicableScenes(List<ProductApplicableScene> productApplicableScenes) {
        List<String> applicableSceneList = new ArrayList<>(productApplicableScenes.size());
        for (ProductApplicableScene applicableScene:productApplicableScenes) {
            applicableSceneList.add(applicableScene.getApplicableSceneId());
        }
        setApplicableSceneList(applicableSceneList);
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
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

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public List<DesignerVo> getDesignerVoList() {
        return designerVoList;
    }

    public void setDesignerVoList(List<DesignerVo> designerVoList) {
        this.designerVoList = designerVoList;
    }

    public Integer getOriginCountryId() {
        return originCountryId;
    }

    public void setOriginCountryId(Integer originCountryId) {
        this.originCountryId = originCountryId;
    }

    public String getOriginCity() {
        return originCity;
    }

    public void setOriginCity(String originCity) {
        this.originCity = originCity;
    }

    public Integer getOriginProvinceId() {
        return originProvinceId;
    }

    public void setOriginProvinceId(Integer originProvinceId) {
        this.originProvinceId = originProvinceId;
    }

    public Byte getStyleId() {
        return styleId;
    }

    public void setStyleId(Byte styleId) {
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

    public Boolean getCanCustomized() {
        return canCustomized;
    }

    public void setCanCustomized(Boolean canCustomized) {
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
}