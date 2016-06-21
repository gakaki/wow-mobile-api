package com.wow.stock.mapper;

import com.wow.stock.model.ProductWarehouseStock;

public interface ProductWarehouseStockMapper {
    int insert(ProductWarehouseStock record);

    int insertSelective(ProductWarehouseStock record);

    ProductWarehouseStock selectByPrimaryKey(Integer id);
}