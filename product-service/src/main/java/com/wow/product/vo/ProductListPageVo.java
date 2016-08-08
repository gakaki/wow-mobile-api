package com.wow.product.vo;

import java.io.Serializable;
import java.util.List;

public class ProductListPageVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private ProductPageVo productPageVo;
	
	private List<ProductListVo> productListVo;

	public ProductPageVo getProductPageVo() {
		return productPageVo;
	}

	public void setProductPageVo(ProductPageVo productPageVo) {
		this.productPageVo = productPageVo;
	}

	public List<ProductListVo> getProductListVo() {
		return productListVo;
	}

	public void setProductListVo(List<ProductListVo> productListVo) {
		this.productListVo = productListVo;
	}

	
}
