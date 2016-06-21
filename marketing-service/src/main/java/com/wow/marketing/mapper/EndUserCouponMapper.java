package com.wow.marketing.mapper;

import com.wow.marketing.model.EndUserCoupon;

public interface EndUserCouponMapper {
    int insert(EndUserCoupon record);

    int insertSelective(EndUserCoupon record);

    EndUserCoupon selectByPrimaryKey(Integer id);
}