package com.wow.product.service.impl;

import com.wow.product.model.ProductSummary;
import com.wow.product.service.ProductSummaryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by fangying@wowdsgn on 2016/7/4.
 */
@Service
@Transactional(value = "productTransactionManager")
public class ProductSummaryServiceImpl implements ProductSummaryService {
    @Override
    public int createProductSummary(ProductSummary productSummary) {
        return 0;
    }

    @Override
    public List<ProductSummary> getProductSummary(int productId) {
        return null;
    }

    @Override
    public int updateProductSummary(ProductSummary productSummary) {
        return 0;
    }
}
