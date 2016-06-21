package com.wow.user.mapper;

import com.wow.user.model.ShoppingCart;

public interface ShoppingCartMapper {
    int insert(ShoppingCart record);

    int insertSelective(ShoppingCart record);

    ShoppingCart selectByPrimaryKey(Integer id);
}