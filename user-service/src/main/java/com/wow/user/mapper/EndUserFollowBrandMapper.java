package com.wow.user.mapper;

import com.wow.user.model.EndUserFollowBrand;

public interface EndUserFollowBrandMapper {
    int insert(EndUserFollowBrand record);

    int insertSelective(EndUserFollowBrand record);

    EndUserFollowBrand selectByPrimaryKey(Integer id);
}