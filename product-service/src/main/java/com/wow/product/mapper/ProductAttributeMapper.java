package com.wow.product.mapper;

import com.wow.product.model.ProductAttribute;

public interface ProductAttributeMapper {
    int insert(ProductAttribute record);

    int insertSelective(ProductAttribute record);

    ProductAttribute selectByPrimaryKey(Integer id);
}