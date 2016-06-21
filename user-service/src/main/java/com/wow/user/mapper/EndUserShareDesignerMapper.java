package com.wow.user.mapper;

import com.wow.user.model.EndUserShareDesigner;

public interface EndUserShareDesignerMapper {
    int insert(EndUserShareDesigner record);

    int insertSelective(EndUserShareDesigner record);

    EndUserShareDesigner selectByPrimaryKey(Integer id);
}