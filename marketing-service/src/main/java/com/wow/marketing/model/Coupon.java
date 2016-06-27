package com.wow.marketing.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Coupon implements Serializable {
    private Integer id;

    private Byte couponType;

    private String couponTitle;

    private String couponDesc;

    private Byte couponLimitType;

    private BigDecimal discountRate;

    private Short minAmountLimit;

    private Date effectiveFrom;

    private Date effectiveTo;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getCouponType() {
        return couponType;
    }

    public void setCouponType(Byte couponType) {
        this.couponType = couponType;
    }

    public String getCouponTitle() {
        return couponTitle;
    }

    public void setCouponTitle(String couponTitle) {
        this.couponTitle = couponTitle;
    }

    public String getCouponDesc() {
        return couponDesc;
    }

    public void setCouponDesc(String couponDesc) {
        this.couponDesc = couponDesc;
    }

    public Byte getCouponLimitType() {
        return couponLimitType;
    }

    public void setCouponLimitType(Byte couponLimitType) {
        this.couponLimitType = couponLimitType;
    }

    public BigDecimal getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(BigDecimal discountRate) {
        this.discountRate = discountRate;
    }

    public Short getMinAmountLimit() {
        return minAmountLimit;
    }

    public void setMinAmountLimit(Short minAmountLimit) {
        this.minAmountLimit = minAmountLimit;
    }

    public Date getEffectiveFrom() {
        return effectiveFrom;
    }

    public void setEffectiveFrom(Date effectiveFrom) {
        this.effectiveFrom = effectiveFrom;
    }

    public Date getEffectiveTo() {
        return effectiveTo;
    }

    public void setEffectiveTo(Date effectiveTo) {
        this.effectiveTo = effectiveTo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", couponType=").append(couponType);
        sb.append(", couponTitle=").append(couponTitle);
        sb.append(", couponDesc=").append(couponDesc);
        sb.append(", couponLimitType=").append(couponLimitType);
        sb.append(", discountRate=").append(discountRate);
        sb.append(", minAmountLimit=").append(minAmountLimit);
        sb.append(", effectiveFrom=").append(effectiveFrom);
        sb.append(", effectiveTo=").append(effectiveTo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}