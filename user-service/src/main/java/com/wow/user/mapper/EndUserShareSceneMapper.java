package com.wow.user.mapper;

import com.wow.user.model.EndUserShareScene;

public interface EndUserShareSceneMapper {
    int insert(EndUserShareScene record);

    int insertSelective(EndUserShareScene record);

    EndUserShareScene selectByPrimaryKey(Integer id);
}