package com.wow.mobileapi.response.product;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by zhengzhiqing on 16/7/23.
 */
public class SubProductInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    //子品ID
    private int subProductId;
    //颜色ID
//    private Byte colorId;
    //颜色显示名
//    private String colorDisplayName;
    //颜色规格图片
    private String productColorImg;
    //规格名称
//    private String specName;

    //尺寸文本
    private String sizeText;
    //重量
    private BigDecimal weight;

    //销售价
    private BigDecimal sellPrice;
    //可用库存数
    private int availableStock;
    //是否还有可用库存
    private boolean hasStock;

    public int getSubProductId() {
        return subProductId;
    }

    public void setSubProductId(int subProductId) {
        this.subProductId = subProductId;
    }

//    public String getColorDisplayName() {
//        return colorDisplayName;
//    }
//
//    public void setColorDisplayName(String colorDisplayName) {
//        this.colorDisplayName = colorDisplayName;
//    }

    public String getProductColorImg() {
        return productColorImg;
    }

    public void setProductColorImg(String productColorImg) {
        this.productColorImg = productColorImg;
    }

//    public String getSpecName() {
//        return specName;
//    }
//
//    public void setSpecName(String specName) {
//        this.specName = specName;
//    }

    public String getSizeText() {
        return sizeText;
    }

    public void setSizeText(String sizeText) {
        this.sizeText = sizeText;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    public int getAvailableStock() {
        return availableStock;
    }

    public void setAvailableStock(int availableStock) {
        this.availableStock = availableStock;
    }

    public boolean isHasStock() {
        return hasStock;
    }

    public void setHasStock(boolean hasStock) {
        this.hasStock = hasStock;
    }
}
