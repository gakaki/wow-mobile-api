package com.wow.product.vo.response;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.attribute.model.Category;
import com.wow.common.response.CommonResponse;
import com.wow.product.vo.ProductVo;

/**
 * Created by fangying@wowdsgn on 2016/7/14.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ProductResponse extends CommonResponse {

    private static final long serialVersionUID = 1L;

    //产品名
    private String productName;
    //卖点(短描述)
    private String sellingPoint;
    //细节图
    private String firstNonPrimaryImgUrl;
    //细节图描述
    private String firstNonPrimaryImgDesc;
    //产品参数
    private ProductParameter productParameter;
    //温馨提示
    private String tips;
    //详细信息
    private String verboseInfo;
    //重量
    private BigDecimal weight;
    //详细描述
    private String detailDescription;
    //品牌ID
    private int brandId;
    
    private List<ProductVo> productList;
    private String categorySmallImg;
    private List<Category> categoryList;

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getDetailDescription() {
        return detailDescription;
    }

    public void setDetailDescription(String detailDescription) {
        this.detailDescription = detailDescription;
    }

    public String getFirstNonPrimaryImgUrl() {
        return firstNonPrimaryImgUrl;
    }

    public void setFirstNonPrimaryImgUrl(String firstNonPrimaryImgUrl) {
        this.firstNonPrimaryImgUrl = firstNonPrimaryImgUrl;
    }

    public String getFirstNonPrimaryImgDesc() {
        return firstNonPrimaryImgDesc;
    }

    public void setFirstNonPrimaryImgDesc(String firstNonPrimaryImgDesc) {
        this.firstNonPrimaryImgDesc = firstNonPrimaryImgDesc;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public String getVerboseInfo() {
        return verboseInfo;
    }

    public void setVerboseInfo(String verboseInfo) {
        this.verboseInfo = verboseInfo;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getSellingPoint() {
        return sellingPoint;
    }

    public void setSellingPoint(String sellingPoint) {
        this.sellingPoint = sellingPoint;
    }

    public ProductParameter getProductParameter() {
        return productParameter;
    }

    public void setProductParameter(ProductParameter productParameter) {
        this.productParameter = productParameter;
    }

	public List<ProductVo> getProductList() {
		return productList;
	}

	public void setProductList(List<ProductVo> productList) {
		this.productList = productList;
	}

	public String getCategorySmallImg() {
		return categorySmallImg;
	}

	public void setCategorySmallImg(String categorySmallImg) {
		this.categorySmallImg = categorySmallImg;
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}
    
}
