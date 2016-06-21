package com.wow.attribute.mapper;

import com.wow.attribute.model.AttributeGroup;

public interface AttributeGroupMapper {
    int insert(AttributeGroup record);

    int insertSelective(AttributeGroup record);

    AttributeGroup selectByPrimaryKey(Integer id);
}