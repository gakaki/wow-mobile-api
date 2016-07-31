package com.wow.attribute.vo.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.attribute.vo.SubCategoryVoList;
import com.wow.common.response.CommonResponse;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class CategorySecondResponse extends CommonResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
//	private CategoryFirstVo categoryFirstVo;
	private List<SubCategoryVoList> subCategoryList;

	public List<SubCategoryVoList> getSubCategoryList() {
		return subCategoryList;
	}

	public void setSubCategoryList(List<SubCategoryVoList> subCategoryList) {
		this.subCategoryList = subCategoryList;
	}
	
//	public CategoryFirstVo getCategoryFirstVo() {
//		return categoryFirstVo;
//	}
//	public void setCategoryFirstVo(CategoryFirstVo categoryFirstVo) {
//		this.categoryFirstVo = categoryFirstVo;
//	}
	
	
}
