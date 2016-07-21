package com.wow.page.vo;

import java.io.Serializable;

/**
 * Created by mahui@wowdsgn on 2016/7/21.
 */
public class PageCategoryVo implements Serializable {

	/** **/
	private static final long serialVersionUID = 1L;
	
	private Integer categoryId;
	private String categoryName;
	private String categoryBgImg;
	
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryBgImg() {
		return categoryBgImg;
	}
	public void setCategoryBgImg(String categoryBgImg) {
		this.categoryBgImg = categoryBgImg;
	}
	
	
}
