package com.wow.product.vo;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.product.model.ProductImage;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDetailImage {
    private Integer id;

    private String imgUrl;

    private String imgDesc;

    private boolean isPrimary;

    private Byte sortOrder;

    public boolean isModifed() {
        return imgUrl != null || imgDesc != null || sortOrder != null;
    }

    public static ProductDetailImage createFromProductImage(ProductImage productImage) {
        ProductDetailImage image = new ProductDetailImage();
        image.setId(productImage.getId());
        image.setImgUrl(productImage.getImgUrl());
        image.setImgDesc(productImage.getImgDesc());
        image.setPrimary(productImage.getIsPrimary());
        image.setSortOrder(productImage.getSortOrder());
        return image;
    }

    public ProductImage buildProductImage() {
        ProductImage productImage = new ProductImage();
        productImage.setId(getId());
        productImage.setImgUrl(getImgUrl());
        productImage.setImgDesc(getImgDesc());
        productImage.setIsPrimary(isPrimary());
        productImage.setSortOrder(getSortOrder());
        return productImage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getImgDesc() {
        return imgDesc;
    }

    public void setImgDesc(String imgDesc) {
        this.imgDesc = imgDesc;
    }

    public boolean isPrimary() {
        return isPrimary;
    }

    public void setPrimary(boolean primary) {
        isPrimary = primary;
    }

    public Byte getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Byte sortOrder) {
        this.sortOrder = sortOrder;
    }
}
