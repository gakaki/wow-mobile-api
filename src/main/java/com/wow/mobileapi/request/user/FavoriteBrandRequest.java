package com.wow.mobileapi.request.user;

import com.wow.common.request.ApiRequest;

public class FavoriteBrandRequest extends ApiRequest {
	private static final long serialVersionUID = 1L;

    private Integer brandId;
    private Integer id;

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
    
    
}
