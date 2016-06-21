package com.wow.order.mapper;

import com.wow.order.model.OrderLog;

public interface OrderLogMapper {
    int insert(OrderLog record);

    int insertSelective(OrderLog record);

    OrderLog selectByPrimaryKey(Integer id);
}