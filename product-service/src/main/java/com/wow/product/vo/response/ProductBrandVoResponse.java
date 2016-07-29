package com.wow.product.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;
import com.wow.product.vo.BrandVo;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ProductBrandVoResponse extends CommonResponse {

	private static final long serialVersionUID = 1L;
	
	private BrandVo brandVo;

	public BrandVo getBrandVo() {
		return brandVo;
	}

	public void setBrandVo(BrandVo brandVo) {
		this.brandVo = brandVo;
	}
	
	
}
