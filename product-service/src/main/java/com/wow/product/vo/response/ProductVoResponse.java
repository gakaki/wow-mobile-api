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

	//每页显示记录数
	private Integer pageSize;

	//总页数
	private Integer totalPage;

	//总记录数
	private Integer totalResult;

	//当前页
	private Integer currentPage;

	public List<ProductVo> getProductVoList() {
		return productVoList;
	}

	public void setProductVoList(List<ProductVo> productVoList) {
		this.productVoList = productVoList;
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
