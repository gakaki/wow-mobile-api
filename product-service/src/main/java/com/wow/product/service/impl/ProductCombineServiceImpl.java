package com.wow.product.service.impl;

import com.wow.product.mapper.ProductCombineMapper;
import com.wow.product.model.ProductCombine;
import com.wow.product.model.ProductComment;
import com.wow.product.service.ProductCombineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by fangying@wowdsgn on 2016/7/4.
 */
@Service
@Transactional(value = "productTransactionManager")
public class ProductCombineServiceImpl  implements ProductCombineService{
    @Autowired
    ProductCombineMapper productCombineMapper;
    @Override
    public int createProductCombines(List<ProductCombine> productCombines) {
        return  0;
       // return productCombineMapper.insert();
    }

    @Override
    public int addProductIntoCombine(ProductCombine productCombine) {
        return 0;
    }

    @Override
    public int updateProductCombines(List<ProductCombine> productCombines) {
        return 0;
    }

    @Override
    public int removeProductFromCombine(ProductCombine productCombine) {
        return 0;
    }

    @Override
    public boolean isProductCombine(int productId) {
        return false;
    }

    @Override
    public List<ProductCombine> getSubProductInfo(int productId) {
        return null;
    }
}
