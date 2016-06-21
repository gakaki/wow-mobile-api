package com.wow.stock.mapper;

import com.wow.stock.model.ProductStockChangeLog;

public interface ProductStockChangeLogMapper {
    int insert(ProductStockChangeLog record);

    int insertSelective(ProductStockChangeLog record);

    ProductStockChangeLog selectByPrimaryKey(Integer id);
}