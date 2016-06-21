package com.wow.product.mapper;

import com.wow.product.model.Warehouse;

public interface WarehouseMapper {
    int insert(Warehouse record);

    int insertSelective(Warehouse record);

    Warehouse selectByPrimaryKey(Integer id);
}