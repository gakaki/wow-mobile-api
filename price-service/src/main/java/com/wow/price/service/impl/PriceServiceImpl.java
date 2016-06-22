package com.wow.price.service.impl;

import com.wow.price.model.ProductPrice;
import com.wow.price.model.ProductPriceChangeLog;
import com.wow.price.service.PriceService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhengzhiqing on 16/6/17.
 */
@Service
public class PriceServiceImpl implements PriceService {
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
    public int createProductPrice(ProductPrice productPrice) {
        return 1;
    }

    /**
     * 更新产品价格
     *
     * @param productPrice
     * @return
     */
    public int updateProductPrice(ProductPrice productPrice) {
        return 1;
    }

    /**
     * 查询产品价格
     *
     * @param productId
     * @return
     */
    public ProductPrice queryProductPrice(int productId) {
        return null;
    }

    /**
     * 批量查询产品价格
     *
     * @param productIds
     * @return
     */
    public List<ProductPrice> queryProductPriceList(int[] productIds) {
        return null;
    }

    /**
     * 添加价格变更日志
     *
     * @param productPriceChangeLog
     * @return
     */
    public int createPriceChangeLog(ProductPriceChangeLog productPriceChangeLog) {
        return 1;
    }

    /**
     * 查询产品价格变更日志
     *
     * @param productId
     * @return
     */
    public List<ProductPriceChangeLog> queryPriceChangeLog(int productId) {
        return null;
    }

}
