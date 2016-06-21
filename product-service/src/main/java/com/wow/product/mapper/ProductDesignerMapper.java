package com.wow.product.mapper;

import com.wow.product.model.ProductDesigner;

public interface ProductDesignerMapper {
    int insert(ProductDesigner record);

    int insertSelective(ProductDesigner record);

    ProductDesigner selectByPrimaryKey(Integer id);
}