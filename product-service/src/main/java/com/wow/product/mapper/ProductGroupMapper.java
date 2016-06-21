package com.wow.product.mapper;

import com.wow.product.model.ProductGroup;

public interface ProductGroupMapper {
    int insert(ProductGroup record);

    int insertSelective(ProductGroup record);

    ProductGroup selectByPrimaryKey(Integer id);
}