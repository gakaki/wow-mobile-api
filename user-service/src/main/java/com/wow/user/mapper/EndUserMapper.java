package com.wow.user.mapper;

import com.wow.user.model.EndUser;

public interface EndUserMapper {
    int insert(EndUser record);

    int insertSelective(EndUser record);

    EndUser selectByPrimaryKey(Integer id);
}