package com.wow.price.service;

import com.wow.price.model.ProductPrice;
import com.wow.price.model.ProductPriceChangeLog;

import java.util.List;

/**
 * Created by zhengzhiqing on 16/6/17.
 */
public interface PriceService {
    /**
     * @param productPrice
     * @return
     */
    //table: product_price, product_price_change_log

    /**
     * 创建产品价格(一般在首次产品上架的时候)
     *
     * @param productPrice
     * @return
     */
    int createProductPrice(ProductPrice productPrice);

    /**
     * 更新产品价格
     *
     * @param productPrice
     * @return
     */
    int updateProductPrice(ProductPrice productPrice);

    /**
     * 查询产品价格
     *
     * @param productId
     * @return
     */
    ProductPrice queryProductPrice(int productId);

    /**
     * 批量查询产品价格
     *
     * @param productIds
     * @return
     */
    List<ProductPrice> queryProductPriceList(int[] productIds);

    /**
     * 添加价格变更日志
     *
     * @param productPriceChangeLog
     * @return
     */
    int createPriceChangeLog(ProductPriceChangeLog productPriceChangeLog);

    /**
     * 查询产品价格变更日志
     *
     * @param productId
     * @return
     */
    List<ProductPriceChangeLog> queryPriceChangeLog(int productId);

}
