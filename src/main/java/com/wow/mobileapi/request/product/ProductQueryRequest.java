package com.wow.mobileapi.request.product;

import com.wow.common.request.ApiRequest;

/**
 * Created by zhengzhiqing on 16/7/21.
 */
public class ProductQueryRequest extends ApiRequest {

    private static final long serialVersionUID = 1L;

    private int productId;
    private Integer brandId;
    private Integer designerId;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public Integer getDesignerId() {
		return designerId;
	}

	public void setDesignerId(Integer designerId) {
		this.designerId = designerId;
	}
    
    
}
