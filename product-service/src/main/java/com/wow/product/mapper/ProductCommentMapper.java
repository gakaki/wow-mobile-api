package com.wow.product.mapper;

import com.wow.product.model.ProductComment;

public interface ProductCommentMapper {
    int insert(ProductComment record);

    int insertSelective(ProductComment record);

    ProductComment selectByPrimaryKey(Integer id);
}