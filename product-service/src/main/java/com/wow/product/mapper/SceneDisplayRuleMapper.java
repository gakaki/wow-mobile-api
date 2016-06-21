package com.wow.product.mapper;

import com.wow.product.model.SceneDisplayRule;

public interface SceneDisplayRuleMapper {
    int insert(SceneDisplayRule record);

    int insertSelective(SceneDisplayRule record);

    SceneDisplayRule selectByPrimaryKey(Integer id);
}