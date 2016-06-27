package com.wow.product.service;

import com.wow.product.model.ProductCombine;

import java.util.List;

/**
 * 组合产品服务
 * Created by zhengzhiqing on 16/6/24.
 */
public interface ProductCombineService {
    //table: product_combine
    /**
     * 创建组合产品
     *
     * @param productCombines
     * @return
     */
    int createProductCombines(List<ProductCombine> productCombines);

    /**
     * 往已有组合产品中添加产品
     *
     * @param productCombine
     * @return
     */
    int addProductIntoCombine(ProductCombine productCombine);

    /**
     * 修改组合产品
     *
     * @param productCombines
     * @return
     */
    int updateProductCombines(List<ProductCombine> productCombines);

    /**
     * 从已有组合产品中删除产品
     *
     * @param productCombine
     * @return
     */
    int removeProductFromCombine(ProductCombine productCombine);

    /**
     * 检查产品是否为组合主品
     * @param productId
     * @return
     */
    boolean isProductCombine(int productId);

    /**
     * 根据组合主品,查找组合子品信息
     *
     * @param productId 组合品ID
     * @return List<ProductCombine> 子品列表
     */
    List<ProductCombine> getSubProductInfo(int productId);
}
