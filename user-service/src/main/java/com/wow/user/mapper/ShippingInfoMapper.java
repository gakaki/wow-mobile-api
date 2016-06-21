package com.wow.user.mapper;

import com.wow.user.model.ShippingInfo;

public interface ShippingInfoMapper {
    int insert(ShippingInfo record);

    int insertSelective(ShippingInfo record);

    ShippingInfo selectByPrimaryKey(Integer id);
}