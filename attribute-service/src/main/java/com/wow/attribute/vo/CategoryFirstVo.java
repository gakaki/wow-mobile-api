package com.wow.attribute.vo;

import com.wow.common.response.CommonResponse;

public class CategoryFirstVo extends CommonResponse {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
    
    private String categoryIconSmall;

    private String categoryIconBig;

    private Byte categoryLevel;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoryIconSmall() {
		return categoryIconSmall;
	}

	public void setCategoryIconSmall(String categoryIconSmall) {
		this.categoryIconSmall = categoryIconSmall;
	}

	public String getCategoryIconBig() {
		return categoryIconBig;
	}

	public void setCategoryIconBig(String categoryIconBig) {
		this.categoryIconBig = categoryIconBig;
	}

	public Byte getCategoryLevel() {
		return categoryLevel;
	}

	public void setCategoryLevel(Byte categoryLevel) {
		this.categoryLevel = categoryLevel;
	}
    
    
}
