package com.wow.product.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;
import com.wow.product.vo.DesignerVo;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ProductDesignerVoResponse extends CommonResponse {
	private static final long serialVersionUID = 1L;
	
	private DesignerVo designerVo;

	public DesignerVo getDesignerVo() {
		return designerVo;
	}

	public void setDesignerVo(DesignerVo designerVo) {
		this.designerVo = designerVo;
	}
	
}
