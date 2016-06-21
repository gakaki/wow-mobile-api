package com.wow.attribute.mapper;

import com.wow.attribute.model.Attribute;

public interface AttributeMapper {
    int insert(Attribute record);

    int insertSelective(Attribute record);

    Attribute selectByPrimaryKey(Integer id);
}