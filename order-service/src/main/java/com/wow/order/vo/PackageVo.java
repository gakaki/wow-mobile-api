package com.wow.order.vo;

import com.wow.user.model.ShoppingCart;

import java.math.BigDecimal;
import java.util.List;

/**
 * 包裹信息
 * Created by zhengzhiqing on 16/6/16.
 */
public class PackageVo {
    /**
     * 包裹名
     */
    private String packageName;
    /**
     * 包裹包含的商品信息
     */
    List<ShoppingCart> productList;
    /**
     * 配送方式(由包裹的配送商能力决定)
     */
    private String deliveryMethod;
    /**
     * 包裹总重量 kg
     */
    private BigDecimal totalPackageWeight;
    /**
     * 运费(元)
     */
    private int freight;
    /**
     * 备注
     */
    private String remarks;
    public String getPackageName() {
        return packageName;
    }
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
    public List<ShoppingCart> getProductList() {
        return productList;
    }
    public void setProductList(List<ShoppingCart> productList) {
        this.productList = productList;
    }
    public String getDeliveryMethod() {
        return deliveryMethod;
    }
    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }
    public BigDecimal getTotalPackageWeight() {
        return totalPackageWeight;
    }
    public void setTotalPackageWeight(BigDecimal totalPackageWeight) {
        this.totalPackageWeight = totalPackageWeight;
    }
    public int getFreight() {
        return freight;
    }
    public void setFreight(int freight) {
        this.freight = freight;
    }
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    
    
}
