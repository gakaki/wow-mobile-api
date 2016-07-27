package com.wow.product.vo.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;
import com.wow.product.model.Designer;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ProductDesignerResponse extends CommonResponse {
	private static final long serialVersionUID = 1L;
	
	private Designer designer;
	private List<Designer> designerList;

	public Designer getDesigner() {
		return designer;
	}

	public void setDesigner(Designer designer) {
		this.designer = designer;
	}

	public List<Designer> getDesignerList() {
		return designerList;
	}

	public void setDesignerList(List<Designer> designerList) {
		this.designerList = designerList;
	}
	
}
