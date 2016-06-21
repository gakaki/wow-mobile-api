package com.wow.user.mapper;

import com.wow.user.model.Area;

public interface AreaMapper {
    int insert(Area record);

    int insertSelective(Area record);

    Area selectByPrimaryKey(Integer id);
}