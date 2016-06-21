package com.wow.attribute.mapper;

import com.wow.attribute.model.AttributeValue;

public interface AttributeValueMapper {
    int insert(AttributeValue record);

    int insertSelective(AttributeValue record);

    AttributeValue selectByPrimaryKey(Integer id);
}