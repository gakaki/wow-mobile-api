package com.wow.product.vo.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;
import com.wow.product.vo.BrandListVo;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ProductBrandAllResponse extends CommonResponse {

	private static final long serialVersionUID = 1L;
	
	private List<BrandListVo> brandVoList;

	public List<BrandListVo> getBrandVoList() {
		return brandVoList;
	}

	public void setBrandVoList(List<BrandListVo> brandVoList) {
		this.brandVoList = brandVoList;
	}
		
}
