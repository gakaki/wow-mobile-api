package com.wow.attribute.vo;

import java.io.Serializable;

public class SubCategoryVoList implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String categoryName;

    private Byte categoryLevel;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Byte getCategoryLevel() {
		return categoryLevel;
	}

	public void setCategoryLevel(Byte categoryLevel) {
		this.categoryLevel = categoryLevel;
	}
    
    
}
