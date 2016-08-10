package com.wow.price.service;

import java.math.BigDecimal;
import java.util.List;

import com.wow.common.response.CommonResponse;
import com.wow.price.model.ProductPrice;
import com.wow.price.model.ProductPriceChangeLog;
import com.wow.price.vo.ProductListPriceResponse;
import com.wow.price.vo.ProductPriceResponse;

/**
 * Created by zhengzhiqing on 16/6/17.
 */
public interface PriceService {

    /**
     * 创建产品价格(一般在首次产品上架的时候)
     *
     * @param productPrice
     * @return
     */
    CommonResponse createProductPrice(ProductPrice productPrice);

    /**
     * 更新产品价格
     *
     * @param productPrice
     * @return
     */
    CommonResponse updateProductPrice(ProductPrice productPrice);

    /**
     * 查询产品价格
     *
     * @param productId
     * @return
     */
    ProductPriceResponse getProductPrice(int productId);

    /**
     * 标记产品价格为已删除
     * @param productIds
     * @return
     */
    int markProductPricesDeleted(List<Integer> productIds);

//    /**
//     * 查询系列产品价格(取子品中售价最低的)
//     *
//     * @param productId
//     * @return
//     */
//    ProductPriceResponse getProductSerialPrice(int productId);


    /**
     * 批量查询产品价格
     *
     * @param productIds
     * @return
     */
    ProductListPriceResponse batchGetProductPrice(List<Integer> productIds);

    /**
     * 添加价格变更日志
     *
     * @param productPriceChangeLog
     * @return
     */
    CommonResponse createPriceChangeLog(ProductPriceChangeLog productPriceChangeLog);

    /**
     * 查询产品价格变更日志
     *
     * @param productId
     * @return
     */
    List<ProductPriceChangeLog> getPriceChangeLog(int productId);
    
    /**
     * 更新时间
     * @param updateTime
     * @return
     */
    List<ProductPrice> selectPriceChangedProduct(String updateStartTime,String updateEndTime);
    
    /**
     * 修改系列品的最小价格
     * @param productId
     * @param sellPrice
     * @return
     */
    int updateProductMinPrice(int productId,BigDecimal sellPrice);

}
