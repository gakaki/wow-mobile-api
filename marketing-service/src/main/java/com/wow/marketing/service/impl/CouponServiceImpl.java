package com.wow.marketing.service.impl;

import com.wow.common.response.ApiResponse;
import com.wow.common.response.CommonResponse;
import com.wow.common.util.ErrorResponseUtil;
import com.wow.marketing.mapper.CouponMapper;
import com.wow.marketing.model.Coupon;
import com.wow.marketing.model.EndUserCoupon;
import com.wow.marketing.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 抵用券服务
 * <p>
 * Created by zhengzhiqing on 16/6/16.
 */
@Service
public class CouponServiceImpl implements CouponService {
    //table: coupon

    @Autowired
    private CouponMapper couponMapper;
    /**
     * 创建抵用券
     *
     * @param coupon
     * @return
     */
    public ApiResponse createCoupon(Coupon coupon) {
        ApiResponse apiResp = new ApiResponse();
        if(couponMapper.insert(coupon)!=1){
            ErrorResponseUtil.setErrorResponse(apiResp, "40201");
            return apiResp;
        }
        return apiResp;
    }

    /**
     * 更新抵用券
     *
     * @param coupon
     * @return
     */
    public int updateCoupon(Coupon coupon) {
        return 1;
    }

    /**
     * 查询抵用券
     *
     * @param couponId
     * @return
     */
    public Coupon getCouponById(int couponId) {
        return new Coupon();
    }

    /**
     * 查询特定类型抵用券
     *
     * @param couponType
     * @return
     */
    public List<Coupon> getCouponsByType(int couponType) {
        return new ArrayList<Coupon>();
    }

    //table: end_user_coupon

    /**
     * 绑定抵用券到用户
     *
     * @param endUserCoupon
     * @return
     */
    public int createEndUserCoupon(EndUserCoupon endUserCoupon) {
        return 1;
    }

    /**
     * 查询用户所有抵用券
     *
     * @param endUserId
     * @return
     */
    public List<Coupon> getCouponsByEndUserId(int endUserId) {
        return new ArrayList<Coupon>();
    }

    /**
     * 查询用户已使用抵用券
     *
     * @param endUserId
     * @return
     */
    public List<Coupon> getValidCouponsByEndUserId(int endUserId) {
        return new ArrayList<Coupon>();
    }

    /**
     * 查询用户已过期抵用券
     *
     * @param endUserId
     * @return
     */
    public List<Coupon> getExpiredCouponsByEndUserId(int endUserId) {
        return new ArrayList<Coupon>();
    }

}
