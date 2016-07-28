package com.wow.attribute.vo.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.attribute.vo.CategorySecondListVo;
import com.wow.attribute.vo.CategoryFirstVo;
import com.wow.common.response.CommonResponse;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class CategorySecondResponse extends CommonResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CategoryFirstVo categoryFirstVo;
	private List<CategorySecondListVo> categorySecondListVo;
	
	public CategoryFirstVo getCategoryFirstVo() {
		return categoryFirstVo;
	}
	public void setCategoryFirstVo(CategoryFirstVo categoryFirstVo) {
		this.categoryFirstVo = categoryFirstVo;
	}
	public List<CategorySecondListVo> getCategorySecondListVo() {
		return categorySecondListVo;
	}
	public void setCategorySecondListVo(List<CategorySecondListVo> categorySecondListVo) {
		this.categorySecondListVo = categorySecondListVo;
	}
	
	
}
