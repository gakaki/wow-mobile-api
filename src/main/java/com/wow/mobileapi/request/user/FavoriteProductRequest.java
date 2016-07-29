package com.wow.mobileapi.request.user;

import com.wow.common.request.ApiRequest;

public class FavoriteProductRequest extends ApiRequest {
	private static final long serialVersionUID = 1L;

    private Integer productId;
    private Integer id;
    
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

    
}
