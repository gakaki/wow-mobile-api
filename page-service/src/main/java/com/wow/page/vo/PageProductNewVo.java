package com.wow.page.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class PageProductNewVo implements Serializable {

	/** **/
	private static final long serialVersionUID = 1L;

	private Integer productId;
	private String productName;
	private String productImg;
	private BigDecimal sellPrice;
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductImg() {
		return productImg;
	}
	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}
	public BigDecimal getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(BigDecimal sellPrice) {
		this.sellPrice = sellPrice;
	}
}
