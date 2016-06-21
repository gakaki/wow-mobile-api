package com.wow.product.mapper;

import com.wow.product.model.ProductSupplier;

public interface ProductSupplierMapper {
    int insert(ProductSupplier record);

    int insertSelective(ProductSupplier record);

    ProductSupplier selectByPrimaryKey(Integer id);
}