package com.wow.stock.mapper;

import com.wow.stock.model.ProductVirtualStock;

public interface ProductVirtualStockMapper {
    int insert(ProductVirtualStock record);

    int insertSelective(ProductVirtualStock record);

    ProductVirtualStock selectByPrimaryKey(Integer id);
}