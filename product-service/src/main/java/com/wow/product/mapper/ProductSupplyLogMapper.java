package com.wow.product.mapper;

import com.wow.product.model.ProductSupplyLog;

public interface ProductSupplyLogMapper {
    int insert(ProductSupplyLog record);

    int insertSelective(ProductSupplyLog record);

    ProductSupplyLog selectByPrimaryKey(Integer id);
}