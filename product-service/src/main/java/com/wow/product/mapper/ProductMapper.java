package com.wow.product.mapper;

import com.wow.product.model.Product;

public interface ProductMapper {
    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);
}