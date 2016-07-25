package com.wow.user.vo.request;

import com.wow.common.request.ApiRequest;

public class LikedDesignerRequest extends ApiRequest {
	private static final long serialVersionUID = 1L;

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
