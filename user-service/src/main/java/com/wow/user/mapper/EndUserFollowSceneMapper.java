package com.wow.user.mapper;

import com.wow.user.model.EndUserFollowScene;

public interface EndUserFollowSceneMapper {
    int insert(EndUserFollowScene record);

    int insertSelective(EndUserFollowScene record);

    EndUserFollowScene selectByPrimaryKey(Integer id);
}