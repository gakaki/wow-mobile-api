package com.wow.price.mapper;

import com.wow.price.model.ProductPrice;

public interface ProductPriceMapper {
    int insert(ProductPrice record);

    int insertSelective(ProductPrice record);

    ProductPrice selectByPrimaryKey(Integer id);
}