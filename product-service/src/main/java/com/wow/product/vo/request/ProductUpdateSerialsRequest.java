package com.wow.product.vo.request;

import com.wow.product.vo.ProductDetailSerial;

import java.util.List;

public class ProductUpdateSerialsRequest {
    private Integer productId;

    private List<ProductDetailSerial> addeds;

    private List<ProductDetailSerial> updateds;

    private List<Integer> deleteds;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public List<ProductDetailSerial> getAddeds() {
        return addeds;
    }

    public void setAddeds(List<ProductDetailSerial> addeds) {
        this.addeds = addeds;
    }

    public List<ProductDetailSerial> getUpdateds() {
        return updateds;
    }

    public void setUpdateds(List<ProductDetailSerial> updateds) {
        this.updateds = updateds;
    }

    public List<Integer> getDeleteds() {
        return deleteds;
    }

    public void setDeleteds(List<Integer> deleteds) {
        this.deleteds = deleteds;
    }
}
