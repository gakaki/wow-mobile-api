package com.wow.order.mapper;

import com.wow.order.model.ReturnOrder;

public interface ReturnOrderMapper {
    int insert(ReturnOrder record);

    int insertSelective(ReturnOrder record);

    ReturnOrder selectByPrimaryKey(Integer id);
}