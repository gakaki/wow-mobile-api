package com.wow.price.mapper;

import com.wow.price.model.ProductPriceChangeLog;

public interface ProductPriceChangeLogMapper {
    int insert(ProductPriceChangeLog record);

    int insertSelective(ProductPriceChangeLog record);
}