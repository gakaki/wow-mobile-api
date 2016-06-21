package com.wow.user.mapper;

import com.wow.user.model.EndUserShareBrand;

public interface EndUserShareBrandMapper {
    int insert(EndUserShareBrand record);

    int insertSelective(EndUserShareBrand record);

    EndUserShareBrand selectByPrimaryKey(Integer id);
}