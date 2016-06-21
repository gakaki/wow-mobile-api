package com.wow.user.mapper;

import com.wow.user.model.EndUserLoginLog;

public interface EndUserLoginLogMapper {
    int insert(EndUserLoginLog record);

    int insertSelective(EndUserLoginLog record);

    EndUserLoginLog selectByPrimaryKey(Integer id);
}