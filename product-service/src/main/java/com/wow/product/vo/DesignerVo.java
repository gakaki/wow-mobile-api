package com.wow.product.vo;

import java.io.Serializable;

public class DesignerVo implements Serializable {

	private static final long serialVersionUID = 1L;
	
    private Integer id;

    private String designerName;

    private String designerPhoto;

    private String designerDesc;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDesignerName() {
		return designerName;
	}

	public void setDesignerName(String designerName) {
		this.designerName = designerName;
	}

	public String getDesignerPhoto() {
		return designerPhoto;
	}

	public void setDesignerPhoto(String designerPhoto) {
		this.designerPhoto = designerPhoto;
	}

	public String getDesignerDesc() {
		return designerDesc;
	}

	public void setDesignerDesc(String designerDesc) {
		this.designerDesc = designerDesc;
	}
	
	

}
