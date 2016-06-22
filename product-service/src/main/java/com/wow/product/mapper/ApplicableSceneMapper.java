package com.wow.product.mapper;

import com.wow.product.model.ApplicableScene;

public interface ApplicableSceneMapper {
    int insert(ApplicableScene record);

    int insertSelective(ApplicableScene record);

    ApplicableScene selectByPrimaryKey(Integer id);
}