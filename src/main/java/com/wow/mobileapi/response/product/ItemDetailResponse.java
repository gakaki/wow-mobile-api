package com.wow.mobileapi.response.product;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;
import com.wow.product.vo.response.ProductParameter;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by fangying@wowdsgn on 2016/7/14.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ItemDetailResponse extends CommonResponse {

    private static final long serialVersionUID = 1L;

    //主图轮播
    private List<String> primaryImgs;
    //产品名
    private String productName;
    //销售价
    private BigDecimal sellPrice;
    //原价
    private BigDecimal originalPrice;
    //卖点(短描述)
    private String sellingPoint;
    //品牌中文名
    private String brandCname;
    //品牌LOGO图片
    private String brandLogoImg;
    //设计师姓名
    private String designerName;
    //设计师头像
    private String designerPhoto;
    //细节图
    private String firstNonPrimaryImgUrl;
    //细节图描述
    private String firstNonPrimaryImgDesc;
    //产品参数
    private ProductParameter productParameter;
    //温馨提示
    private String tips;

    //详细信息
    private String verboseInfo;
    //重量
    private BigDecimal weight;
    //详细描述
    private String detailDescription;

    public String getDetailDescription() {
        return detailDescription;
    }

    public void setDetailDescription(String detailDescription) {
        this.detailDescription = detailDescription;
    }

    public String getFirstNonPrimaryImgUrl() {
        return firstNonPrimaryImgUrl;
    }

    public void setFirstNonPrimaryImgUrl(String firstNonPrimaryImgUrl) {
        this.firstNonPrimaryImgUrl = firstNonPrimaryImgUrl;
    }

    public String getFirstNonPrimaryImgDesc() {
        return firstNonPrimaryImgDesc;
    }

    public void setFirstNonPrimaryImgDesc(String firstNonPrimaryImgDesc) {
        this.firstNonPrimaryImgDesc = firstNonPrimaryImgDesc;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public String getVerboseInfo() {
        return verboseInfo;
    }

    public void setVerboseInfo(String verboseInfo) {
        this.verboseInfo = verboseInfo;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getSellingPoint() {
        return sellingPoint;
    }

    public void setSellingPoint(String sellingPoint) {
        this.sellingPoint = sellingPoint;
    }

    public String getBrandCname() {
        return brandCname;
    }

    public void setBrandCname(String brandCname) {
        this.brandCname = brandCname;
    }

    public String getBrandLogoImg() {
        return brandLogoImg;
    }

    public void setBrandLogoImg(String brandLogoImg) {
        this.brandLogoImg = brandLogoImg;
    }

    public String getDesignerName() {
        return designerName;
    }

    public void setDesignerName(String designerName) {
        this.designerName = designerName;
    }

    public String getDesignerPhoto() {
        return designerPhoto;
    }

    public void setDesignerPhoto(String designerPhoto) {
        this.designerPhoto = designerPhoto;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public ProductParameter getProductParameter() {
        return productParameter;
    }

    public void setProductParameter(ProductParameter productParameter) {
        this.productParameter = productParameter;
    }

    public List<String> getPrimaryImgs() {
        return primaryImgs;
    }

    public void setPrimaryImgs(List<String> primaryImgs) {
        this.primaryImgs = primaryImgs;
    }
}
