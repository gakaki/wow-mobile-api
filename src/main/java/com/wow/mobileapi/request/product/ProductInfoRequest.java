package com.wow.mobileapi.request.product;

import com.wow.common.request.ApiRequest;

import javax.validation.constraints.NotNull;

/**
 * 产品查询
 * @author mh
 *
 */
public class ProductInfoRequest extends ApiRequest {

	private static final long serialVersionUID = 1L;

	@NotNull
	private Integer categoryId;
	private Integer sortBy;
	private Boolean asc;
	private Integer categoryLevel;//分类级别
	private Integer showCount; //每页显示记录数
    private Integer currentPage; //当前页
    
	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getSortBy() {
		return sortBy;
	}

	public void setSortBy(Integer sortBy) {
		this.sortBy = sortBy;
	}

	public Boolean getAsc() {
		return asc;
	}

	public void setAsc(Boolean asc) {
		this.asc = asc;
	}

	public Integer getCategoryLevel() {
		return categoryLevel;
	}

	public void setCategoryLevel(Integer categoryLevel) {
		this.categoryLevel = categoryLevel;
	}

	public Integer getShowCount() {
		return showCount;
	}

	public void setShowCount(Integer showCount) {
		this.showCount = showCount;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	
	

	
}
