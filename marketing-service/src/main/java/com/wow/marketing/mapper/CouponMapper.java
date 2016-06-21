package com.wow.marketing.mapper;

import com.wow.marketing.model.Coupon;

public interface CouponMapper {
    int insert(Coupon record);

    int insertSelective(Coupon record);

    Coupon selectByPrimaryKey(Integer id);
}