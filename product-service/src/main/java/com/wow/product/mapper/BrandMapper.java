package com.wow.product.mapper;

import com.wow.product.model.Brand;

public interface BrandMapper {
    int insert(Brand record);

    int insertSelective(Brand record);

    Brand selectByPrimaryKey(Integer id);
}