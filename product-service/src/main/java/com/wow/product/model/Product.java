package com.wow.product.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Product implements Serializable {
    private Integer id;

    private String productName;

    private Integer categoryId;

    private Integer brandId;

    private Byte productType;

    private Boolean isCombine;

    private Boolean isBundling;

    private Boolean canSale;

    private Boolean canShow;

    private Byte viewPlatform;

    private String detailDescription;

    private String shortDescription;

    private String seoTitle;

    private String seoDesc;

    private String seoKey;

    private Boolean isImport;

    private String productModel;

    private String originCountry;

    private Integer originAreaId;

    private Short length;

    private Short width;

    private Short height;

    private BigDecimal weight;

    private String specImg;

    private String verboseInfo;

    private Boolean needAssemble;

    private Boolean isFragile;

    private String postSaleServiceDesc;

    private Boolean isPresale;

    private Short productStatus;

    private String rejectReason;

    private Date onShelfTime;

    private Date addedAt;

    private Date approvalAt;

    private Date updateAt;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public Byte getProductType() {
        return productType;
    }

    public void setProductType(Byte productType) {
        this.productType = productType;
    }

    public Boolean getIsCombine() {
        return isCombine;
    }

    public void setIsCombine(Boolean isCombine) {
        this.isCombine = isCombine;
    }

    public Boolean getIsBundling() {
        return isBundling;
    }

    public void setIsBundling(Boolean isBundling) {
        this.isBundling = isBundling;
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

    public String getDetailDescription() {
        return detailDescription;
    }

    public void setDetailDescription(String detailDescription) {
        this.detailDescription = detailDescription;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getSeoTitle() {
        return seoTitle;
    }

    public void setSeoTitle(String seoTitle) {
        this.seoTitle = seoTitle;
    }

    public String getSeoDesc() {
        return seoDesc;
    }

    public void setSeoDesc(String seoDesc) {
        this.seoDesc = seoDesc;
    }

    public String getSeoKey() {
        return seoKey;
    }

    public void setSeoKey(String seoKey) {
        this.seoKey = seoKey;
    }

    public Boolean getIsImport() {
        return isImport;
    }

    public void setIsImport(Boolean isImport) {
        this.isImport = isImport;
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public Integer getOriginAreaId() {
        return originAreaId;
    }

    public void setOriginAreaId(Integer originAreaId) {
        this.originAreaId = originAreaId;
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

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getSpecImg() {
        return specImg;
    }

    public void setSpecImg(String specImg) {
        this.specImg = specImg;
    }

    public String getVerboseInfo() {
        return verboseInfo;
    }

    public void setVerboseInfo(String verboseInfo) {
        this.verboseInfo = verboseInfo;
    }

    public Boolean getNeedAssemble() {
        return needAssemble;
    }

    public void setNeedAssemble(Boolean needAssemble) {
        this.needAssemble = needAssemble;
    }

    public Boolean getIsFragile() {
        return isFragile;
    }

    public void setIsFragile(Boolean isFragile) {
        this.isFragile = isFragile;
    }

    public String getPostSaleServiceDesc() {
        return postSaleServiceDesc;
    }

    public void setPostSaleServiceDesc(String postSaleServiceDesc) {
        this.postSaleServiceDesc = postSaleServiceDesc;
    }

    public Boolean getIsPresale() {
        return isPresale;
    }

    public void setIsPresale(Boolean isPresale) {
        this.isPresale = isPresale;
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
        this.rejectReason = rejectReason;
    }

    public Date getOnShelfTime() {
        return onShelfTime;
    }

    public void setOnShelfTime(Date onShelfTime) {
        this.onShelfTime = onShelfTime;
    }

    public Date getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(Date addedAt) {
        this.addedAt = addedAt;
    }

    public Date getApprovalAt() {
        return approvalAt;
    }

    public void setApprovalAt(Date approvalAt) {
        this.approvalAt = approvalAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", productName=").append(productName);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", brandId=").append(brandId);
        sb.append(", productType=").append(productType);
        sb.append(", isCombine=").append(isCombine);
        sb.append(", isBundling=").append(isBundling);
        sb.append(", canSale=").append(canSale);
        sb.append(", canShow=").append(canShow);
        sb.append(", viewPlatform=").append(viewPlatform);
        sb.append(", detailDescription=").append(detailDescription);
        sb.append(", shortDescription=").append(shortDescription);
        sb.append(", seoTitle=").append(seoTitle);
        sb.append(", seoDesc=").append(seoDesc);
        sb.append(", seoKey=").append(seoKey);
        sb.append(", isImport=").append(isImport);
        sb.append(", productModel=").append(productModel);
        sb.append(", originCountry=").append(originCountry);
        sb.append(", originAreaId=").append(originAreaId);
        sb.append(", length=").append(length);
        sb.append(", width=").append(width);
        sb.append(", height=").append(height);
        sb.append(", weight=").append(weight);
        sb.append(", specImg=").append(specImg);
        sb.append(", verboseInfo=").append(verboseInfo);
        sb.append(", needAssemble=").append(needAssemble);
        sb.append(", isFragile=").append(isFragile);
        sb.append(", postSaleServiceDesc=").append(postSaleServiceDesc);
        sb.append(", isPresale=").append(isPresale);
        sb.append(", productStatus=").append(productStatus);
        sb.append(", rejectReason=").append(rejectReason);
        sb.append(", onShelfTime=").append(onShelfTime);
        sb.append(", addedAt=").append(addedAt);
        sb.append(", approvalAt=").append(approvalAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}