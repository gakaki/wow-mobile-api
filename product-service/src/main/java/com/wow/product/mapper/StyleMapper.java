package com.wow.product.mapper;

import com.wow.product.model.Style;

public interface StyleMapper {
    int insert(Style record);

    int insertSelective(Style record);

    Style selectByPrimaryKey(Integer id);
}