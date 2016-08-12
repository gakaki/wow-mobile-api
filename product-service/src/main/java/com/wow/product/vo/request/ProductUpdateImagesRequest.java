package com.wow.product.vo.request;

import com.wow.product.vo.ProductDetailImage;

import java.util.List;

public class ProductUpdateImagesRequest {
    private Integer productId;

    private List<ProductDetailImage> updateds;

    private List<Integer> deleteds;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public List<ProductDetailImage> getUpdateds() {
        return updateds;
    }

    public void setUpdateds(List<ProductDetailImage> updateds) {
        this.updateds = updateds;
    }

    public List<Integer> getDeleteds() {
        return deleteds;
    }

    public void setDeleteds(List<Integer> deleteds) {
        this.deleteds = deleteds;
    }
}
