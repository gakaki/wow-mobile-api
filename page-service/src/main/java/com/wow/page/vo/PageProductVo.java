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
	private BigDecimal costPrice;
	private String detailDescription;
	private Byte moduleType;
	
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
	public BigDecimal getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
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
	public Byte getModuleType() {
		return moduleType;
	}
	public void setModuleType(Byte moduleType) {
		this.moduleType = moduleType;
	}
	
	
	
}
