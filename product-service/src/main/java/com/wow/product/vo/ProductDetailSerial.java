package com.wow.product.vo;

import com.wow.price.model.ProductPrice;
import com.wow.product.model.Product;

import java.math.BigDecimal;
import java.util.Map;

public class ProductDetailSerial {
    private Integer productId;

    private Byte colorId;

    private String colorImg;

    private String colorName;

    private String specName;

    private BigDecimal weight;

    private BigDecimal sellPrice;

    public static ProductDetailSerial createFromProduct(Product product) {
        ProductDetailSerial serial = new ProductDetailSerial();
        serial.copyFromProduct(product);
        return serial;
    }

    public void copyFromProduct(Product product) {
        setProductId(product.getId());
        setColorId(product.getColorId());
        setColorImg(product.getProductColorImg());
        setColorName(product.getColorDisplayName());
        setSpecName(product.getSpecName());
        setWeight(product.getWeight());
    }

    public void setupPriceFromPriceMap(Map<Integer, ProductPrice> prices) {
        ProductPrice productPrice = prices.get(getProductId());
        if (productPrice == null) {
            return;
        }
        setSellPrice(productPrice.getSellPrice());
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Byte getColorId() {
        return colorId;
    }

    public void setColorId(Byte colorId) {
        this.colorId = colorId;
    }

    public String getColorImg() {
        return colorImg;
    }

    public void setColorImg(String colorImg) {
        this.colorImg = colorImg;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
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
}
