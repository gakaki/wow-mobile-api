package com.wow.product.vo.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by fangying@wowdsgn on 2016/7/14.
 */
public class ProductResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    //产品名
    private String productName;
    //温馨提示
    private String tips;
    //详细信息
    private String verboseInfo;
    //使用场景,多个用文本表示,逗号分隔
    private String applicableSceneText;
    //产地
    private String  origin;
    //重量
    private BigDecimal weight;
    //材质,多个用文本表示,逗号分隔
    private String materialText;
    //规格
    private String spec;
    //是否需要安装
    private Boolean needAssemble;
    //风格
    private String style;
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
    //销售价
    private BigDecimal sellPrice;
    //原价
    private BigDecimal originalPrice;
    //详细描述
    private String detailDescription;
    //主图轮播
    private List<String> primaryImgs;
    //细节描述
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

    public List<String> getPrimaryImgs() {
        return primaryImgs;
    }

    public void setPrimaryImgs(List<String> primaryImgs) {
        this.primaryImgs = primaryImgs;
    }
}
