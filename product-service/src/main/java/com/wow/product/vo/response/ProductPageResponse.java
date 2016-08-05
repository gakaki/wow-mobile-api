package com.wow.product.vo.response;

import java.util.List;

import com.wow.common.response.CommonResponse;
import com.wow.product.vo.ProductListPageVo;

public class ProductPageResponse extends CommonResponse {
	private static final long serialVersionUID = 1L;
	private List<ProductListPageVo> productListPageVo;
	public List<ProductListPageVo> getProductListPageVo() {
		return productListPageVo;
	}
	public void setProductListPageVo(List<ProductListPageVo> productListPageVo) {
		this.productListPageVo = productListPageVo;
	}
		
}
