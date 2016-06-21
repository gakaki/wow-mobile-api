package com.wow.product.mapper;

import com.wow.product.model.Scene;

public interface SceneMapper {
    int insert(Scene record);

    int insertSelective(Scene record);

    Scene selectByPrimaryKey(Integer id);
}