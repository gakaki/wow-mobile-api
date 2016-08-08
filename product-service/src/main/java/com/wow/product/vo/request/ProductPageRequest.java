package com.wow.product.vo.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.wow.common.page.PageQuery;

public class ProductPageRequest extends PageQuery implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String productName;//产品名称
    private Integer categoryId;//最子集产品分类ID
    private List<Integer> categoryIds;
    private String productCode;//SKU
    private String brandName;//品牌名称
    private String designerName;//设计师名称
    private Integer productStatus;//上架状态
    private BigDecimal beginSellPrice;//价格区间（小）
    private BigDecimal endSellPrice;//价格区间（大）
    
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
