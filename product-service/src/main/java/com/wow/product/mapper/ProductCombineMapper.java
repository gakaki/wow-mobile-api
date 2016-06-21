package com.wow.product.mapper;

import com.wow.product.model.ProductCombine;

public interface ProductCombineMapper {
    int insert(ProductCombine record);

    int insertSelective(ProductCombine record);

    ProductCombine selectByPrimaryKey(Integer id);
}