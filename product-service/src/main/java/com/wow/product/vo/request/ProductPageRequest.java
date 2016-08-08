package com.wow.product.vo.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.wow.common.page.PageQuery;

public class ProductPageRequest extends PageQuery implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String productName;
    private Integer categoryId;
    private List<Integer> categoryIds;
    private String productCode;
    private String brandName;
    private String designerName;
    private Integer productStatus;
    private BigDecimal beginSellPrice;
    private BigDecimal endSellPrice;
    
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public List<Integer> getCategoryIds() {
		return categoryIds;
	}
	public void setCategoryIds(List<Integer> categoryIds) {
		this.categoryIds = categoryIds;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getDesignerName() {
		return designerName;
	}
	public void setDesignerName(String designerName) {
		this.designerName = designerName;
	}
	public Integer getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(Integer productStatus) {
		this.productStatus = productStatus;
	}
	public BigDecimal getBeginSellPrice() {
		return beginSellPrice;
	}
	public void setBeginSellPrice(BigDecimal beginSellPrice) {
		this.beginSellPrice = beginSellPrice;
	}
	public BigDecimal getEndSellPrice() {
		return endSellPrice;
	}
	public void setEndSellPrice(BigDecimal endSellPrice) {
		this.endSellPrice = endSellPrice;
	}
    
    
}
