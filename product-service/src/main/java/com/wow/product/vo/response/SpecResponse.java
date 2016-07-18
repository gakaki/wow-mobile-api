package com.wow.product.vo.response;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by fangying@wowdsgn on 2016/7/14.
 */
public class SpecResponse implements Serializable {

    private  String color;

    private String sizeText;

    private String spec;

    private int qty;

    private String detailDescription;

    private BigDecimal sellPrice;

    private BigDecimal originalPrice;

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSizeText() {
        return sizeText;
    }

    public void setSizeText(String sizeText) {
        this.sizeText = sizeText;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getDetailDescription() {
        return detailDescription;
    }

    public void setDetailDescription(String detailDescription) {
        this.detailDescription = detailDescription;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    @Override
    public String toString() {
        return "SpecResponse{" +
                "color='" + color + '\'' +
                ", sizeText='" + sizeText + '\'' +
                ", spec='" + spec + '\'' +
                ", qty=" + qty +
                ", detailDescription='" + detailDescription + '\'' +
                ", sellPrice=" + sellPrice +
                ", originalPrice=" + originalPrice +
                '}';
    }

}
