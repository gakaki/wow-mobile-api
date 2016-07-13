package com.wow.page.vo.response;

import com.sun.jmx.snmp.Timestamp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by fangying@wowdsgn on 2016/7/13.
 */
public class SerialResponse implements Serializable {
    /**
     * 商品名
     */
    private  String  productName;
    /**
     * 现价
     */
    private  BigDecimal sellPrice;
    /**
     * 原价
     */
    private  BigDecimal originalPrice;

    /**
     * 描述
     */
    private  String  describe;



    /**
     * 卖点
     */
    private  String sellingPoint;

    /**
     * 温馨提示
     */
    private String tips;

    /**
     * 设计师名
     */
    private  String designerName;

    /**
     * 品牌名
     */
    private  String brandName;

    /**
     * 设计师logo图
     */
    private  String designerLogo;
    /**
     * 品牌logo图
     */
    private  String brandLogo;

    /**
     * 图文详情
     */
    private String verboseInfo;
    /**
     * 重量
     */
    private BigDecimal weight;

    /**
     * 材料
     */
    private String material;
 /**
  *是否需要组装
  */
    private  Boolean needAssemble;

    /**
     *产地
     */
    private  String origin;

    /**
     * 发货时间
     */
    private Timestamp deliveryTime;

    /**
     * 风格
     */
    private  String style;

    /**
     * 适用场景
     */
    private  String applicableScene;
    /**
     *规格
     */
    private String spec;


    /**
     * 细节图+描述
     */
   private Map<String,String> detailsMap;




    /**
     *主图
     */
    private List<String> Banner;

    public Map<String, String> getDetailsMap() {
        return detailsMap;
    }

    public void setDetailsMap(Map<String, String> detailsMap) {
        this.detailsMap = detailsMap;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public String getDesignerName() {
        return designerName;
    }

    public void setDesignerName(String designerName) {
        this.designerName = designerName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getDesignerLogo() {
        return designerLogo;
    }

    public void setDesignerLogo(String designerLogo) {
        this.designerLogo = designerLogo;
    }

    public String getBrandLogo() {
        return brandLogo;
    }

    public void setBrandLogo(String brandLogo) {
        this.brandLogo = brandLogo;
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

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Boolean getNeedAssemble() {
        return needAssemble;
    }

    public void setNeedAssemble(Boolean needAssemble) {
        this.needAssemble = needAssemble;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Timestamp getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Timestamp deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getApplicableScene() {
        return applicableScene;
    }

    public void setApplicableScene(String applicableScene) {
        this.applicableScene = applicableScene;
    }

    public List<String> getBanner() {
        return Banner;
    }

    public void setBanner(List<String> banner) {
        Banner = banner;
    }

    public String getSellingPoint() {
        return sellingPoint;
    }

    public void setSellingPoint(String sellingPoint) {
        this.sellingPoint = sellingPoint;
    }

    @Override
    public String toString() {
        return "SerialResponse{" +
                "productName='" + productName + '\'' +
                ", sellPrice=" + sellPrice +
                ", originalPrice=" + originalPrice +
                ", describe='" + describe + '\'' +
                ", sellingPoint='" + sellingPoint + '\'' +
                ", tips='" + tips + '\'' +
                ", designerName='" + designerName + '\'' +
                ", brandName='" + brandName + '\'' +
                ", designerLogo='" + designerLogo + '\'' +
                ", brandLogo='" + brandLogo + '\'' +
                ", verboseInfo='" + verboseInfo + '\'' +
                ", weight=" + weight +
                ", material='" + material + '\'' +
                ", needAssemble=" + needAssemble +
                ", origin='" + origin + '\'' +
                ", deliveryTime=" + deliveryTime +
                ", style='" + style + '\'' +
                ", applicableScene='" + applicableScene + '\'' +
                ", spec='" + spec + '\'' +
                ", detailsMap=" + detailsMap +
                ", Banner=" + Banner +
                '}';
    }

}

