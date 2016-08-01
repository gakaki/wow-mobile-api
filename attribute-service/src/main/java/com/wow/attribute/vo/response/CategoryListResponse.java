package com.wow.attribute.vo.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.attribute.model.Category;
import com.wow.attribute.vo.CategoryFirstVo;
import com.wow.common.response.CommonResponse;

/**
 * Created by zhengzhiqing on 16/7/14.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class CategoryListResponse extends CommonResponse {

	private CategoryFirstVo categoryFirstVo;
	
    private List<Category> categoryList;
    
    public CategoryFirstVo getCategoryFirstVo() {
		return categoryFirstVo;
	}

	public void setCategoryFirstVo(CategoryFirstVo categoryFirstVo) {
		this.categoryFirstVo = categoryFirstVo;
	}

	public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }
}
