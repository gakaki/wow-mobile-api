package com.wow.product.mapper;

import com.wow.product.model.ProductImage;

public interface ProductImageMapper {
    int insert(ProductImage record);

    int insertSelective(ProductImage record);

    ProductImage selectByPrimaryKey(Integer id);
}