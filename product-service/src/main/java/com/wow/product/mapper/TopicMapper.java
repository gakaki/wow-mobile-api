package com.wow.product.mapper;

import com.wow.product.model.Topic;

public interface TopicMapper {
    int insert(Topic record);

    int insertSelective(Topic record);

    Topic selectByPrimaryKey(Integer id);
}