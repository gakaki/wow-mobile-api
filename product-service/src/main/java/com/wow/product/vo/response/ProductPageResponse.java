package com.wow.product.vo.response;

import java.util.List;

import com.wow.common.response.ApiResponse;
import com.wow.product.vo.ProductListPageVo;

public class ProductPageResponse extends ApiResponse {
	private static final long serialVersionUID = 1L;

    //每页显示记录数
    private Integer pageSize;

    //总页数
    private Integer totalPage;

    //总记录数
    private Integer totalResult;

    //当前页
    private Integer currentPage;
    
	private List<ProductListPageVo> productListPageVo;
	
	public List<ProductListPageVo> getProductListPageVo() {
		return productListPageVo;
	}
	public void setProductListPageVo(List<ProductListPageVo> productListPageVo) {
		this.productListPageVo = productListPageVo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getTotalResult() {
		return totalResult;
	}
	public void setTotalResult(Integer totalResult) {
		this.totalResult = totalResult;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	
	
}
