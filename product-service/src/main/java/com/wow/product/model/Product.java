package com.wow.product.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Product implements Serializable {
    private Integer id;

    private String code;

    private String productName;

    private String productCode;

    private Byte productType;

    private Integer categoryId;

    private Integer brandId;

    private String productModel;

    private String materialText;

    private String sellingPoint;

    private String detailDescription;

    private Boolean canSale;

    private Boolean canShow;

    private Byte viewPlatform;

    private String originCountry;

    private String originCity;

    private Boolean isImport;

    private Short length;

    private Short width;

    private Short height;

    private String sizeText;

    private BigDecimal weight;

    private String weightText;

    private String spec;

    private String specImg;

    private String color;

    private String style;

    private String verboseInfo;

    private String tips;

    private String applicableSceneText;

    private String postSaleServiceDesc;

    private Byte deliveryFeeType;

    private Boolean needAssemble;

    private String assembleTips;

    private Boolean isFragile;

    private Boolean isPresale;

    private Boolean isBundling;

    private Short productStatus;

    private String rejectReason;

    private Date onShelfTime;

    private Date createTime;

    private Date approvalTime;

    private Date updateTime;

    private Boolean isDeleted;

    private String seoTitle;

    private String seoDesc;

    private String seoKey;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    public Byte getProductType() {
        return productType;
    }

    public void setProductType(Byte productType) {
        this.productType = productType;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel == null ? null : productModel.trim();
    }

    public String getMaterialText() {
        return materialText;
    }

    public void setMaterialText(String materialText) {
        this.materialText = materialText == null ? null : materialText.trim();
    }

    public String getSellingPoint() {
        return sellingPoint;
    }

    public void setSellingPoint(String sellingPoint) {
        this.sellingPoint = sellingPoint == null ? null : sellingPoint.trim();
    }

    public String getDetailDescription() {
        return detailDescription;
    }

    public void setDetailDescription(String detailDescription) {
        this.detailDescription = detailDescription == null ? null : detailDescription.trim();
    }

    public Boolean getCanSale() {
        return canSale;
    }

    public void setCanSale(Boolean canSale) {
        this.canSale = canSale;
    }

    public Boolean getCanShow() {
        return canShow;
    }

    public void setCanShow(Boolean canShow) {
        this.canShow = canShow;
    }

    public Byte getViewPlatform() {
        return viewPlatform;
    }

    public void setViewPlatform(Byte viewPlatform) {
        this.viewPlatform = viewPlatform;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry == null ? null : originCountry.trim();
    }

    public String getOriginCity() {
        return originCity;
    }

    public void setOriginCity(String originCity) {
        this.originCity = originCity == null ? null : originCity.trim();
    }

    public Boolean getIsImport() {
        return isImport;
    }

    public void setIsImport(Boolean isImport) {
        this.isImport = isImport;
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

    public String getSizeText() {
        return sizeText;
    }

    public void setSizeText(String sizeText) {
        this.sizeText = sizeText == null ? null : sizeText.trim();
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getWeightText() {
        return weightText;
    }

    public void setWeightText(String weightText) {
        this.weightText = weightText == null ? null : weightText.trim();
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec == null ? null : spec.trim();
    }

    public String getSpecImg() {
        return specImg;
    }

    public void setSpecImg(String specImg) {
        this.specImg = specImg == null ? null : specImg.trim();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style == null ? null : style.trim();
    }

    public String getVerboseInfo() {
        return verboseInfo;
    }

    public void setVerboseInfo(String verboseInfo) {
        this.verboseInfo = verboseInfo == null ? null : verboseInfo.trim();
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips == null ? null : tips.trim();
    }

    public String getApplicableSceneText() {
        return applicableSceneText;
    }

    public void setApplicableSceneText(String applicableSceneText) {
        this.applicableSceneText = applicableSceneText == null ? null : applicableSceneText.trim();
    }

    public String getPostSaleServiceDesc() {
        return postSaleServiceDesc;
    }

    public void setPostSaleServiceDesc(String postSaleServiceDesc) {
        this.postSaleServiceDesc = postSaleServiceDesc == null ? null : postSaleServiceDesc.trim();
    }

    public Byte getDeliveryFeeType() {
        return deliveryFeeType;
    }

    public void setDeliveryFeeType(Byte deliveryFeeType) {
        this.deliveryFeeType = deliveryFeeType;
    }

    public Boolean getNeedAssemble() {
        return needAssemble;
    }

    public void setNeedAssemble(Boolean needAssemble) {
        this.needAssemble = needAssemble;
    }

    public String getAssembleTips() {
        return assembleTips;
    }

    public void setAssembleTips(String assembleTips) {
        this.assembleTips = assembleTips == null ? null : assembleTips.trim();
    }

    public Boolean getIsFragile() {
        return isFragile;
    }

    public void setIsFragile(Boolean isFragile) {
        this.isFragile = isFragile;
    }

    public Boolean getIsPresale() {
        return isPresale;
    }

    public void setIsPresale(Boolean isPresale) {
        this.isPresale = isPresale;
    }

    public Boolean getIsBundling() {
        return isBundling;
    }

    public void setIsBundling(Boolean isBundling) {
        this.isBundling = isBundling;
    }

    public Short getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Short productStatus) {
        this.productStatus = productStatus;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason == null ? null : rejectReason.trim();
    }

    public Date getOnShelfTime() {
        return onShelfTime;
    }

    public void setOnShelfTime(Date onShelfTime) {
        this.onShelfTime = onShelfTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getApprovalTime() {
        return approvalTime;
    }

    public void setApprovalTime(Date approvalTime) {
        this.approvalTime = approvalTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getSeoTitle() {
        return seoTitle;
    }

    public void setSeoTitle(String seoTitle) {
        this.seoTitle = seoTitle == null ? null : seoTitle.trim();
    }

    public String getSeoDesc() {
        return seoDesc;
    }

    public void setSeoDesc(String seoDesc) {
        this.seoDesc = seoDesc == null ? null : seoDesc.trim();
    }

    public String getSeoKey() {
        return seoKey;
    }

    public void setSeoKey(String seoKey) {
        this.seoKey = seoKey == null ? null : seoKey.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", code=").append(code);
        sb.append(", productName=").append(productName);
        sb.append(", productCode=").append(productCode);
        sb.append(", productType=").append(productType);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", brandId=").append(brandId);
        sb.append(", productModel=").append(productModel);
        sb.append(", materialText=").append(materialText);
        sb.append(", sellingPoint=").append(sellingPoint);
        sb.append(", detailDescription=").append(detailDescription);
        sb.append(", canSale=").append(canSale);
        sb.append(", canShow=").append(canShow);
        sb.append(", viewPlatform=").append(viewPlatform);
        sb.append(", originCountry=").append(originCountry);
        sb.append(", originCity=").append(originCity);
        sb.append(", isImport=").append(isImport);
        sb.append(", length=").append(length);
        sb.append(", width=").append(width);
        sb.append(", height=").append(height);
        sb.append(", sizeText=").append(sizeText);
        sb.append(", weight=").append(weight);
        sb.append(", weightText=").append(weightText);
        sb.append(", spec=").append(spec);
        sb.append(", specImg=").append(specImg);
        sb.append(", color=").append(color);
        sb.append(", style=").append(style);
        sb.append(", verboseInfo=").append(verboseInfo);
        sb.append(", tips=").append(tips);
        sb.append(", applicableSceneText=").append(applicableSceneText);
        sb.append(", postSaleServiceDesc=").append(postSaleServiceDesc);
        sb.append(", deliveryFeeType=").append(deliveryFeeType);
        sb.append(", needAssemble=").append(needAssemble);
        sb.append(", assembleTips=").append(assembleTips);
        sb.append(", isFragile=").append(isFragile);
        sb.append(", isPresale=").append(isPresale);
        sb.append(", isBundling=").append(isBundling);
        sb.append(", productStatus=").append(productStatus);
        sb.append(", rejectReason=").append(rejectReason);
        sb.append(", onShelfTime=").append(onShelfTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", approvalTime=").append(approvalTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", seoTitle=").append(seoTitle);
        sb.append(", seoDesc=").append(seoDesc);
        sb.append(", seoKey=").append(seoKey);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}