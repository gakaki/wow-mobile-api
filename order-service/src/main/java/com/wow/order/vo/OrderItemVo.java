package com.wow.order.vo;

import java.math.BigDecimal;

/**
 * Created by zhengzhiqing on 16/6/16.
 */
public class OrderItemVo {
    /**
     * 产品Id
     */
    private int productId;
    /**
     * 产品名
     */
    private String productName;
    /**
     * 是否需要安装
     */
    private boolean needAssemble;
    /**
     * 产品销售类型
     */
    private int productSaleType;
    /**
     * 产品件数
     */
    private int productNum;
    /**
     * 单价
     */
    private BigDecimal productUnitPrice;
    /**
     * 是否组合产品
     */
    private boolean isProductCombine;
    /**
     * 如果是组合产品的子品,设为组合主品的ID
     */
    private int parentProductI;
    /**
     * 产品供应商
     */
    private int productSupplierId;
}
