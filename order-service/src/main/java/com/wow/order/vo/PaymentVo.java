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
    public boolean isUseCoupon() {
        return isUseCoupon;
    }
    public void setUseCoupon(boolean isUseCoupon) {
        this.isUseCoupon = isUseCoupon;
    }
    public List<EndUserCoupon> getCouponList() {
        return couponList;
    }
    public void setCouponList(List<EndUserCoupon> couponList) {
        this.couponList = couponList;
    }
    public int getPaymentMethod() {
        return paymentMethod;
    }
    public void setPaymentMethod(int paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    

}
