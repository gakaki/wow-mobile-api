package com.wow.product.mapper;

import com.wow.product.model.Group;

public interface GroupMapper {
    int insert(Group record);

    int insertSelective(Group record);

    Group selectByPrimaryKey(Integer id);
}