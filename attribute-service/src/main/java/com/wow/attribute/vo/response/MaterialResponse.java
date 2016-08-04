package com.wow.attribute.vo.response;

import com.wow.attribute.model.CategoryMaterial;
import com.wow.common.response.CommonResponse;

import java.util.List;

public class MaterialResponse extends CommonResponse {

	private static final long serialVersionUID = 1L;
	
	private List<CategoryMaterial> materialList;

	public List<CategoryMaterial> getMaterialList() {
		return materialList;
	}

	public void setMaterialList(List<CategoryMaterial> materialList) {
		this.materialList = materialList;
	}
}
