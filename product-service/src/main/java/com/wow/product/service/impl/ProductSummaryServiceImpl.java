package com.wow.product.service.impl;

import com.wow.product.mapper.ProductSummaryMapper;
import com.wow.product.model.ProductSummary;
import com.wow.product.model.ProductSummaryExample;
import com.wow.product.service.ProductSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by fangying@wowdsgn on 2016/7/4.
 */
@Service
@Transactional(value = "productTransactionManager")
public class ProductSummaryServiceImpl implements ProductSummaryService {
    @Autowired
    private ProductSummaryMapper productSummaryMapper;
    @Override
    public int createProductSummary(ProductSummary productSummary) {
        if(productSummary!=null)
          return productSummaryMapper.insertSelective(productSummary);
        return 0;
    }

    @Override
    public List<ProductSummary> getProductSummary(int productId) {
        ProductSummaryExample productSummaryExample=new ProductSummaryExample();
        ProductSummaryExample.Criteria criteria=productSummaryExample.createCriteria();
        criteria.andProductIdEqualTo(productId);
        criteria.andIsDeletedEqualTo(false);
        return productSummaryMapper.selectByExample(productSummaryExample);
    }

    @Override
    public int updateProductSummary(ProductSummary productSummary) {
        return productSummaryMapper.updateByPrimaryKeySelective(productSummary);
    }
}
