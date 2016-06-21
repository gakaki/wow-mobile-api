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
}
