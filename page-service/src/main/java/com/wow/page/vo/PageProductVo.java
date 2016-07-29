package com.wow.page.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by mahui@wowdsgn on 2016/7/21.
 */
public class PageProductVo implements Serializable {

	/** **/
	private static final long serialVersionUID = 1L;

	private Integer productId;
	private String productName;
	private String productImg;
	private BigDecimal sellPrice;
	private BigDecimal originalPrice;
	private String detailDescription;
	
	private Byte pageModuleType;
	
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
	public BigDecimal getOriginalPrice() {
		return originalPrice;
	}
	public void setOriginalPrice(BigDecimal originalPrice) {
		this.originalPrice = originalPrice;
	}
	public String getDetailDescription() {
		return detailDescription;
	}
	public void setDetailDescription(String detailDescription) {
		this.detailDescription = detailDescription;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Byte getPageModuleType() {
		return pageModuleType;
	}
	public void setPageModuleType(Byte pageModuleType) {
		this.pageModuleType = pageModuleType;
	}	
	
}
