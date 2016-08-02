package com.wow.product.vo;

import java.io.Serializable;

public class BrandListVo implements Serializable {

	private static final long serialVersionUID = 1L;
	

    private Integer id;

    private String brandCname;

    private String brandEname;

    private String brandLogoImg;

    private String brandNameFirstLetter;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBrandCname() {
		return brandCname;
	}

	public void setBrandCname(String brandCname) {
		this.brandCname = brandCname;
	}

	public String getBrandEname() {
		return brandEname;
	}

	public void setBrandEname(String brandEname) {
		this.brandEname = brandEname;
	}

	public String getBrandLogoImg() {
		return brandLogoImg;
	}

	public void setBrandLogoImg(String brandLogoImg) {
		this.brandLogoImg = brandLogoImg;
	}

	public String getBrandNameFirstLetter() {
		return brandNameFirstLetter;
	}

	public void setBrandNameFirstLetter(String brandNameFirstLetter) {
		this.brandNameFirstLetter = brandNameFirstLetter;
	}
}
