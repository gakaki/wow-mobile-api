package com.wow.price.service.impl;

import com.wow.common.response.CommonResponse;
import com.wow.common.util.CollectionUtil;
import com.wow.common.util.ErrorCodeUtil;
import com.wow.price.mapper.ProductPriceChangeLogMapper;
import com.wow.price.mapper.ProductPriceMapper;
import com.wow.price.model.ProductPrice;
import com.wow.price.model.ProductPriceChangeLog;
import com.wow.price.service.PriceService;
import com.wow.price.vo.ProductListPriceResponse;
import com.wow.price.vo.ProductPriceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public CommonResponse createProductPrice(ProductPrice productPrice) {
        CommonResponse commonResponse = new CommonResponse();
        int i =  productPriceMapper.insertSelective(productPrice);
        if (i < 1) {
            commonResponse.setResCode("50501");
            commonResponse.setResMsg(ErrorCodeUtil.getErrorMsg("50501"));
        }
        return commonResponse;
    }

    /**
     * 更新产品价格
     *
     * @param productPrice
     * @return
     */
    public CommonResponse updateProductPrice(ProductPrice productPrice) {
        CommonResponse commonResponse = new CommonResponse();
        //可以考虑做一下价格预警校验,满足阈值的不允许修改并报出警告
        int i = productPriceMapper.updateByPrimaryKeySelective(productPrice);
        if (i < 1) {
            commonResponse.setResCode("50502");
            commonResponse.setResMsg(ErrorCodeUtil.getErrorMsg("50502"));
        }
        return commonResponse;
    }

    /**
     * 查询产品价格
     *
     * @param productId
     * @return
     */
    public ProductPriceResponse getProductPrice(int productId) {
        ProductPriceResponse productPriceResponse = new ProductPriceResponse();
        ProductPrice productPrice = productPriceMapper.selectByProductId(productId);
        if (productPrice == null) {
            productPriceResponse.setResCode("50504");
            productPriceResponse.setResMsg(ErrorCodeUtil.getErrorMsg("50504"));
        } else if (productPrice.getSellPrice()==new BigDecimal(0.0)) {
            productPriceResponse.setResCode("50505");
            productPriceResponse.setResMsg(ErrorCodeUtil.getErrorMsg("50505"));
        }
        productPriceResponse.setProductPrice(productPrice);
        return productPriceResponse;
    }

    /**
     * 批量查询产品价格
     *
     * @param productIds
     * @return
     */
    public ProductListPriceResponse getProductPriceList(List<Integer> productIds) {
        ProductListPriceResponse productListPriceResponse = new ProductListPriceResponse();
        List<ProductPrice> productPriceList = productPriceMapper.selectByProductIds(productIds);
        if (CollectionUtil.isEmpty(productPriceList)) {
            productListPriceResponse.setResCode("50506");
            productListPriceResponse.setResMsg(ErrorCodeUtil.getErrorMsg("50506"));
            return productListPriceResponse;
        }
        Map<Integer, ProductPrice> map = new HashMap<Integer, ProductPrice>();
        for (ProductPrice productPrice:productPriceList) {
            int productId = productPrice.getProductId();
            map.put(productId, productPrice);
        }
        productListPriceResponse.setMap(map);
        return productListPriceResponse;
    }

    /**
     * 添加价格变更日志
     *
     * @param productPriceChangeLog
     * @return
     */
    public CommonResponse createPriceChangeLog(ProductPriceChangeLog productPriceChangeLog) {
        CommonResponse commonResponse = new CommonResponse();
        int i = productPriceChangeLogMapper.insertSelective(productPriceChangeLog);
        if (i < 1) {
            commonResponse.setResCode("50503");
            commonResponse.setResMsg(ErrorCodeUtil.getErrorMsg("50503"));
        }
        return commonResponse;
    }

    /**
     * 查询产品价格变更日志
     *
     * @param productId
     * @return
     */
    public List<ProductPriceChangeLog> getPriceChangeLog(int productId) {
        return productPriceChangeLogMapper.selectPriceChangeLogsByProductId(productId);
    }

}
