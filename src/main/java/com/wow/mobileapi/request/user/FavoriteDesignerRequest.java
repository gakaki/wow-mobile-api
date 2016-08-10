package com.wow.mobileapi.request.user;

import com.wow.common.request.ApiRequest;

import javax.validation.constraints.NotNull;

public class FavoriteDesignerRequest extends ApiRequest {
	private static final long serialVersionUID = 1L;

	@NotNull
    private Integer designerId;
    private Integer id;
    
	public Integer getDesignerId() {
		return designerId;
	}
	public void setDesignerId(Integer designerId) {
		this.designerId = designerId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

    
}
