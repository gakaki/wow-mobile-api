package com.wow.product.mapper;

import com.wow.product.model.ProductSummary;

public interface ProductSummaryMapper {
    int insert(ProductSummary record);

    int insertSelective(ProductSummary record);

    ProductSummary selectByPrimaryKey(Integer id);
}