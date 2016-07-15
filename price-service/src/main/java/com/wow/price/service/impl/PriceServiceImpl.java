package com.wow.price.service.impl;

import com.wow.price.mapper.ProductPriceChangeLogMapper;
import com.wow.price.mapper.ProductPriceMapper;
import com.wow.price.model.ProductPrice;
import com.wow.price.model.ProductPriceChangeLog;
import com.wow.price.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhengzhiqing on 16/6/17.
 */
@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    ProductPriceMapper productPriceMapper;

    @Autowired
    ProductPriceChangeLogMapper productPriceChangeLogMapper;

    /**
     * 创建产品价格(一般在首次产品上架的时候)
     *
     * @param productPrice
     * @return
     */
    public int createProductPrice(ProductPrice productPrice) {
        return productPriceMapper.insertSelective(productPrice);
    }

    /**
     * 更新产品价格
     *
     * @param productPrice
     * @return
     */
    public int updateProductPrice(ProductPrice productPrice) {
        return productPriceMapper.updateByPrimaryKeySelective(productPrice);
    }

    /**
     * 查询产品价格
     *
     * @param productId
     * @return
     */
    public ProductPrice queryProductPrice(int productId) {
        return productPriceMapper.selectByProductId(productId);
    }

    /**
     * 批量查询产品价格
     *
     * @param productIds
     * @return
     */
    public List<ProductPrice> queryProductPriceList(int[] productIds) {
        return productPriceMapper.selectByProductIds(productIds);
    }

    /**
     * 添加价格变更日志
     *
     * @param productPriceChangeLog
     * @return
     */
    public int createPriceChangeLog(ProductPriceChangeLog productPriceChangeLog) {
        return productPriceChangeLogMapper.insertSelective(productPriceChangeLog);
    }

    /**
     * 查询产品价格变更日志
     *
     * @param productId
     * @return
     */
    public List<ProductPriceChangeLog> queryPriceChangeLog(int productId) {
        return productPriceChangeLogMapper.selectPriceChangeLogsByProductId(productId);
    }

}
