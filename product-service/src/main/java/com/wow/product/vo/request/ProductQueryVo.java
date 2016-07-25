package com.wow.product.vo.request;

import java.util.List;

public class ProductQueryVo {

	private Integer categoryId;
	private Integer sortBy;
	private Boolean asc;
	private List<Integer> categoryIdList;

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
	
	public String getAscText(){
		
		if(asc){
			return "asc";
		}else{
			return "desc";
		}
	}

	public void setAsc(Boolean asc) {
		this.asc = asc;
	}

	public List<Integer> getCategoryIdList() {
		return categoryIdList;
	}

	public void setCategoryIdList(List<Integer> categoryIdList) {
		this.categoryIdList = categoryIdList;
	}

	
}
