package com.wow.user.mapper;

import com.wow.user.model.EndUserFollowProduct;

public interface EndUserFollowProductMapper {
    int insert(EndUserFollowProduct record);

    int insertSelective(EndUserFollowProduct record);

    EndUserFollowProduct selectByPrimaryKey(Integer id);
}