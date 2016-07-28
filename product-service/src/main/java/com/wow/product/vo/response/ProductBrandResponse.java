package com.wow.product.vo.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;
import com.wow.product.model.Brand;
import com.wow.product.vo.BrandVo;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ProductBrandResponse extends CommonResponse {

	private static final long serialVersionUID = 1L;
	
	private Brand brand;
	private List<Brand> brandList;
	private List<String> brandFirstLetterList;
	
	public List<Brand> getBrandList() {
		return brandList;
	}
	public void setBrandList(List<Brand> brandList) {
		this.brandList = brandList;
	}
	public List<String> getBrandFirstLetterList() {
		return brandFirstLetterList;
	}
	public void setBrandFirstLetterList(List<String> brandFirstLetterList) {
		this.brandFirstLetterList = brandFirstLetterList;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	
	
	
}
