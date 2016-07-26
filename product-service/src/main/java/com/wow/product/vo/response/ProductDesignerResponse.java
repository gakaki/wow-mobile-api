package com.wow.product.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;
import com.wow.product.model.Designer;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ProductDesignerResponse extends CommonResponse {
	private static final long serialVersionUID = 1L;
	
	private Designer designer;

	public Designer getDesigner() {
		return designer;
	}

	public void setDesigner(Designer designer) {
		this.designer = designer;
	}
	
}
