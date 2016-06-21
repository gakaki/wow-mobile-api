package com.wow.marketing.service;

import com.wow.marketing.model.Coupon;
import com.wow.marketing.model.EndUserCoupon;

import java.util.List;

/**
 * 抵用券服务
 * <p>
 * Created by zhengzhiqing on 16/6/16.
 */
public interface CouponService {
    //table: coupon

    /**
     * 创建抵用券
     *
     * @param coupon
     * @return
     */
    int createCoupon(Coupon coupon);

    /**
     * 更新抵用券
     *
     * @param coupon
     * @return
     */
    int updateCoupon(Coupon coupon);

    /**
     * 查询抵用券
     *
     * @param couponId
     * @return
     */
    Coupon getCouponById(int couponId);

    /**
     * 查询特定类型抵用券
     *
     * @param couponType
     * @return
     */
    List<Coupon> getCouponsByType(int couponType);

    //table: end_user_coupon

    /**
     * 绑定抵用券到用户
     *
     * @param endUserCoupon
     * @return
     */
    int createEndUserCoupon(EndUserCoupon endUserCoupon);

    /**
     * 查询用户所有抵用券
     *
     * @param endUserId
     * @return
     */
    List<Coupon> getCouponsByEndUserId(int endUserId);

    /**
     * 查询用户已使用抵用券
     *
     * @param endUserId
     * @return
     */
    List<Coupon> getValidCouponsByEndUserId(int endUserId);

    /**
     * 查询用户已过期抵用券
     *
     * @param endUserId
     * @return
     */
    List<Coupon> getExpiredCouponsByEndUserId(int endUserId);

}
