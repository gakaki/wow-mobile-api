package com.wow.attribute.vo;

public class CategorySecondVo {

	private Integer id;
    private String categoryName;
	private String categoryIconSmall;
	private String categoryIconBig;
	private String categoryDesc;

	public String getCategoryIconBig() {
		return categoryIconBig;
	}

	public void setCategoryIconBig(String categoryIconBig) {
		this.categoryIconBig = categoryIconBig;
	}



	public String getCategoryDesc() {
		return categoryDesc;
	}

	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}


	public String getCategoryIconSmall() { return categoryIconSmall; }

	public void setCategoryIconSmall(String categoryIconSmall) { this.categoryIconSmall = categoryIconSmall; }


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

    
}
