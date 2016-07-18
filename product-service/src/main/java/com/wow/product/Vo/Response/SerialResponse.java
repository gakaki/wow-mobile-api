package com.wow.product.vo.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by fangying@wowdsgn on 2016/7/14.
 */
public class SerialResponse implements Serializable {

    /**  */
    private static final long serialVersionUID = 1L;
    private String productName;
    private String tips;
    private String verboseInfo;
    private String applicableSceneText;
    private String  origin;
    private BigDecimal weight;
    private String materialText;
    private String spec;
    private Boolean needAssemble;
    private String style;
    private String sellingPoint;
    private String brandCname;
    private String brandLogoImg;
    private String designerName;
    private String designerPhoto;
    private BigDecimal sellPrice;
    private BigDecimal originalPrice;
    private String detailDescription;
    private List<String> banner;
    Map<String,String> details;


    public String getDetailDescription() {
        return detailDescription;
    }

    public void setDetailDescription(String detailDescription) {
        this.detailDescription = detailDescription;
    }

    public Map<String, String> getDetails() {
        return details;
    }

    public void setDetails(Map<String, String> details) {
        this.details = details;
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

    public String getApplicableSceneText() {
        return applicableSceneText;
    }

    public void setApplicableSceneText(String applicableSceneText) {
        this.applicableSceneText = applicableSceneText;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getMaterialText() {
        return materialText;
    }

    public void setMaterialText(String materialText) {
        this.materialText = materialText;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public Boolean getNeedAssemble() {
        return needAssemble;
    }

    public void setNeedAssemble(Boolean needAssemble) {
        this.needAssemble = needAssemble;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
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

    public List<String> getBanner() {
        return banner;
    }

    public void setBanner(List<String> banner) {
        this.banner = banner;
    }



}
