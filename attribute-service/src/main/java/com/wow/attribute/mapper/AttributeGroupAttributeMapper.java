package com.wow.attribute.mapper;

import com.wow.attribute.model.AttributeGroupAttribute;

public interface AttributeGroupAttributeMapper {
    int insert(AttributeGroupAttribute record);

    int insertSelective(AttributeGroupAttribute record);

    AttributeGroupAttribute selectByPrimaryKey(Integer id);
}