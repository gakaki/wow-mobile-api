package com.wow.product.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductListVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer productId;//产品ID
	private Integer subProductId;//子品ID
	private String productName;//产品名称
    private String specName;//规格名称
    private String productCode;//sku
    private BigDecimal sellPrice;//售价
    private Integer stockQty;//库存数
    private Integer totalSoldQty;//销量
    private Byte productStatus;//产品状态
    
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getSubProductId() {
		return subProductId;
	}
	public void setSubProductId(Integer subProductId) {
		this.subProductId = subProductId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getSpecName() {
		return specName;
	}
	public void setSpecName(String specName) {
		this.specName = specName;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public BigDecimal getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(BigDecimal sellPrice) {
		this.sellPrice = sellPrice;
	}
	public Integer getStockQty() {
		return stockQty;
	}
	public void setStockQty(Integer stockQty) {
		this.stockQty = stockQty;
	}
	public Integer getTotalSoldQty() {
		return totalSoldQty;
	}
	public void setTotalSoldQty(Integer totalSoldQty) {
		this.totalSoldQty = totalSoldQty;
	}
	public Byte getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(Byte productStatus) {
		this.productStatus = productStatus;
	}
    
    
}
