package com.wow.user.mapper;

import com.wow.user.model.EndUserFollowDesigner;

public interface EndUserFollowDesignerMapper {
    int insert(EndUserFollowDesigner record);

    int insertSelective(EndUserFollowDesigner record);

    EndUserFollowDesigner selectByPrimaryKey(Integer id);
}