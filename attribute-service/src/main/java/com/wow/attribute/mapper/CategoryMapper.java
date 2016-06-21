package com.wow.attribute.mapper;

import com.wow.attribute.model.Category;

public interface CategoryMapper {
    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);
}