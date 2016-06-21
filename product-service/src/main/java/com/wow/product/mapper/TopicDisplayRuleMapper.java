package com.wow.product.mapper;

import com.wow.product.model.TopicDisplayRule;

public interface TopicDisplayRuleMapper {
    int insert(TopicDisplayRule record);

    int insertSelective(TopicDisplayRule record);

    TopicDisplayRule selectByPrimaryKey(Integer id);
}