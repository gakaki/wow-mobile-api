package com.wow.user.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * Created by zhengzhiqing on 16/7/13.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class LikedBrandVo implements Serializable{

    private static final long serialVersionUID = 1L;

    private int brandId;

    private String brandCName;

    private String brandLogoImg;
    
    private String brandDesc;

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getBrandCName() {
        return brandCName;
    }

    public void setBrandCName(String brandCName) {
        this.brandCName = brandCName;
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
