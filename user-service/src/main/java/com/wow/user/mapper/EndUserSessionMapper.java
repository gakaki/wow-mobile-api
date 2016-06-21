package com.wow.user.mapper;

import com.wow.user.model.EndUserSession;

public interface EndUserSessionMapper {
    int insert(EndUserSession record);

    int insertSelective(EndUserSession record);

    EndUserSession selectByPrimaryKey(Integer id);
}