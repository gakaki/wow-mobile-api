package com.wow.product.mapper;

import com.wow.product.model.TopicProductDisplayRule;

public interface TopicProductDisplayRuleMapper {
    int insert(TopicProductDisplayRule record);

    int insertSelective(TopicProductDisplayRule record);

    TopicProductDisplayRule selectByPrimaryKey(Integer id);
}