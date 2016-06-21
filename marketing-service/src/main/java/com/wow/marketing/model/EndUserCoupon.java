package com.wow.marketing.model;

import java.io.Serializable;
import java.util.Date;

public class EndUserCoupon implements Serializable {
    private Integer id;

    private Integer endUserId;

    private Integer couponId;

    private Boolean isUsed;

    private Boolean isExpired;

    private Date bindTime;

    private Date usedTime;

    private Boolean isReturn;

    private Date returnTime;

    private Integer bindOrderId;

    private Boolean isDeleted;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEndUserId() {
        return endUserId;
    }

    public void setEndUserId(Integer endUserId) {
        this.endUserId = endUserId;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public Boolean getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(Boolean isUsed) {
        this.isUsed = isUsed;
    }

    public Boolean getIsExpired() {
        return isExpired;
    }

    public void setIsExpired(Boolean isExpired) {
        this.isExpired = isExpired;
    }

    public Date getBindTime() {
        return bindTime;
    }

    public void setBindTime(Date bindTime) {
        this.bindTime = bindTime;
    }

    public Date getUsedTime() {
        return usedTime;
    }

    public void setUsedTime(Date usedTime) {
        this.usedTime = usedTime;
    }

    public Boolean getIsReturn() {
        return isReturn;
    }

    public void setIsReturn(Boolean isReturn) {
        this.isReturn = isReturn;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public Integer getBindOrderId() {
        return bindOrderId;
    }

    public void setBindOrderId(Integer bindOrderId) {
        this.bindOrderId = bindOrderId;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", endUserId=").append(endUserId);
        sb.append(", couponId=").append(couponId);
        sb.append(", isUsed=").append(isUsed);
        sb.append(", isExpired=").append(isExpired);
        sb.append(", bindTime=").append(bindTime);
        sb.append(", usedTime=").append(usedTime);
        sb.append(", isReturn=").append(isReturn);
        sb.append(", returnTime=").append(returnTime);
        sb.append(", bindOrderId=").append(bindOrderId);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}