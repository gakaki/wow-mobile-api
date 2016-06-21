package com.wow.order.mapper;

import com.wow.order.model.Order;

public interface OrderMapper {
    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);
}