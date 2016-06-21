package com.wow.user.mapper;

import com.wow.user.model.EndUserShareProduct;

public interface EndUserShareProductMapper {
    int insert(EndUserShareProduct record);

    int insertSelective(EndUserShareProduct record);

    EndUserShareProduct selectByPrimaryKey(Integer id);
}