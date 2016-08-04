package com.wow.attribute.vo.response;

import com.wow.attribute.model.CategoryMaterial;
import com.wow.common.response.CommonResponse;

import java.util.List;

public class MaterialResponse extends CommonResponse {

	private static final long serialVersionUID = 1L;
	
	private CategoryMaterial categoryMaterial;

	public CategoryMaterial getCategoryMaterial() {
		return categoryMaterial;
	}

	public void setCategoryMaterial(CategoryMaterial categoryMaterial) {
		this.categoryMaterial = categoryMaterial;
	}
}
