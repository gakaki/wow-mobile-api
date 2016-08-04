package com.wow.product.vo.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ProductBrandFirstLetterResponse extends CommonResponse {

	private static final long serialVersionUID = 1L;
	
	private List<String> brandFirstLetterList;
	
	public List<String> getBrandFirstLetterList() {
		return brandFirstLetterList;
	}
	public void setBrandFirstLetterList(List<String> brandFirstLetterList) {
		this.brandFirstLetterList = brandFirstLetterList;
	}
}
