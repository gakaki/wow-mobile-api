package com.wow.product.vo.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;
import com.wow.product.vo.ProductVo;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ProductVoResponse extends CommonResponse {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<ProductVo> productVoList;

	public List<ProductVo> getProductVoList() {
		return productVoList;
	}

	public void setProductVoList(List<ProductVo> productVoList) {
		this.productVoList = productVoList;
	}
	
	
}
