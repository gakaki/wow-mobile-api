package com.wow.product.mapper;

import com.wow.product.model.Supplier;

public interface SupplierMapper {
    int insert(Supplier record);

    int insertSelective(Supplier record);

    Supplier selectByPrimaryKey(Integer id);
}