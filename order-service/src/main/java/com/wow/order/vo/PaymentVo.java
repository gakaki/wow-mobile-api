package com.wow.order.vo;

import com.wow.marketing.model.EndUserCoupon;

import java.util.List;

/**
 * Created by zhengzhiqing on 16/6/16.
 */
public class PaymentVo {
    private boolean isUseCoupon;
    private List<EndUserCoupon> couponList;
    /**
     * 支付方式,1:网上支付-微信 2.网上支付-支付宝 3.货到付现金 4.货到刷卡 5.货到支付宝扫码支付 6.货到微信扫码支付
     */
    private int paymentMethod;

}
