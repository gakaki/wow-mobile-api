package com.wow.product.service;

import com.wow.product.model.ProductSummary;

import java.util.List;

/**
 * 产品统计服务
 *
 * Created by zhengzhiqing on 16/6/24.
 */
public interface ProductSummaryService {
    //table: product_summary

    /**
     * 创建产品统计信息,包括总销量,评论数
     *
     * @param productSummary
     * @return
     */
    int createProductSummary(ProductSummary productSummary);

    /**
     * 查询产品统计信息,包括总销量,评论数
     *
     * @param productId
     * @return
     */
    List<ProductSummary> getProductSummary(int productId);

    /**
     * 更新产品统计信息,包括总销量,评论数(可以使用定时任务或者队列的方式来更新,注意并发)
     *
     * @param productSummary
     * @return
     */
    int updateProductSummary(ProductSummary productSummary);
}
