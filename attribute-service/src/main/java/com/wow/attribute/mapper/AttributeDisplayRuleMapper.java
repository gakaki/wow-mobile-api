package com.wow.attribute.mapper;

import com.wow.attribute.model.AttributeDisplayRule;

public interface AttributeDisplayRuleMapper {
    int insert(AttributeDisplayRule record);

    int insertSelective(AttributeDisplayRule record);

    AttributeDisplayRule selectByPrimaryKey(Integer id);
}