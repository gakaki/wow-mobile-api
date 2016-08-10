package com.wow.attribute.vo.response;

import com.wow.attribute.model.Material;
import com.wow.common.response.CommonResponse;

import java.util.List;

public class MaterialResponse extends CommonResponse {

	private static final long serialVersionUID = 1L;
	
	private List<Material> materialList;

	public List<Material> getMaterialList() {
		return materialList;
	}

	public void setMaterialList(List<Material> materialList) {
		this.materialList = materialList;
	}
}
