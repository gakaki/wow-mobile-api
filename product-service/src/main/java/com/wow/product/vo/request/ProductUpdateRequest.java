package com.wow.product.vo.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.product.vo.ProductDetailImage;
import com.wow.product.vo.ProductDetailInfo;
import com.wow.product.vo.ProductDetailSerial;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductUpdateRequest {
    private int productId;

    private ProductDetailInfo info;

    private List<ProductDetailImage> images;

    private List<ProductDetailSerial> serials;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public ProductDetailInfo getInfo() {
        return info;
    }

    public void setInfo(ProductDetailInfo info) {
        this.info = info;
    }

    public List<ProductDetailImage> getImages() {
        return images;
    }

    public void setImages(List<ProductDetailImage> images) {
        this.images = images;
    }

    public List<ProductDetailSerial> getSerials() {
        return serials;
    }

    public void setSerials(List<ProductDetailSerial> serials) {
        this.serials = serials;
    }
}
