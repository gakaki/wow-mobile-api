package com.wow.product.vo;

import java.io.Serializable;
import java.util.List;

public class ProductListPageVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private ProductVo productVo;
	
	private List<ProductListVo> productListVo;

	public ProductVo getProductVo() {
		return productVo;
	}

	public void setProductVo(ProductVo productVo) {
		this.productVo = productVo;
	}

	public List<ProductListVo> getProductListVo() {
		return productListVo;
	}

	public void setProductListVo(List<ProductListVo> productListVo) {
		this.productListVo = productListVo;
	}

	
}
