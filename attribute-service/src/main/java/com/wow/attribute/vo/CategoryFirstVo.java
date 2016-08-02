package com.wow.attribute.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class CategoryFirstVo {

	private Integer id;
    
    private String categoryIconSmall;

    private String categoryIconBg;

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

	public String getCategoryIconBg() {
		return categoryIconBg;
	}

	public void setCategoryIconBg(String categoryIconBg) {
		this.categoryIconBg = categoryIconBg;
	}   
    
}
