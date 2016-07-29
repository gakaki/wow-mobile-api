package com.wow.product.vo;

import java.io.Serializable;

public class BrandVo implements Serializable {

	private static final long serialVersionUID = 1L;
	

    private Integer id;

    private String brandCname;

    private String brandEname;

    private String brandLogoImg;

    private String brandDesc;

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

	public String getBrandDesc() {
		return brandDesc;
	}

	public void setBrandDesc(String brandDesc) {
		this.brandDesc = brandDesc;
	}
	
	
}
