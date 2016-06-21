package com.wow.order.model;

import java.io.Serializable;
import java.util.Date;

public class ReturnOrder implements Serializable {
    private Integer id;

    private Integer endUserId;

    private Integer orderId;

    private Integer orderItem;

    private Date orderCreateTime;

    private String receiverName;

    private String receiverMobile;

    private String receiverAddress;

    private Byte returnType;

    private Boolean isSubmitByEndUser;

    private Date submitTime;

    private Date approveTime;

    private Boolean isApproved;

    private String rejectReason;

    private String returnOrderCode;

    private Boolean needRefund;

    private Boolean isRefunded;

    private Integer isGoodsSentBack;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;

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

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(Integer orderItem) {
        this.orderItem = orderItem;
    }

    public Date getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(Date orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public Byte getReturnType() {
        return returnType;
    }

    public void setReturnType(Byte returnType) {
        this.returnType = returnType;
    }

    public Boolean getIsSubmitByEndUser() {
        return isSubmitByEndUser;
    }

    public void setIsSubmitByEndUser(Boolean isSubmitByEndUser) {
        this.isSubmitByEndUser = isSubmitByEndUser;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public Date getApproveTime() {
        return approveTime;
    }

    public void setApproveTime(Date approveTime) {
        this.approveTime = approveTime;
    }

    public Boolean getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(Boolean isApproved) {
        this.isApproved = isApproved;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    public String getReturnOrderCode() {
        return returnOrderCode;
    }

    public void setReturnOrderCode(String returnOrderCode) {
        this.returnOrderCode = returnOrderCode;
    }

    public Boolean getNeedRefund() {
        return needRefund;
    }

    public void setNeedRefund(Boolean needRefund) {
        this.needRefund = needRefund;
    }

    public Boolean getIsRefunded() {
        return isRefunded;
    }

    public void setIsRefunded(Boolean isRefunded) {
        this.isRefunded = isRefunded;
    }

    public Integer getIsGoodsSentBack() {
        return isGoodsSentBack;
    }

    public void setIsGoodsSentBack(Integer isGoodsSentBack) {
        this.isGoodsSentBack = isGoodsSentBack;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
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
        sb.append(", orderId=").append(orderId);
        sb.append(", orderItem=").append(orderItem);
        sb.append(", orderCreateTime=").append(orderCreateTime);
        sb.append(", receiverName=").append(receiverName);
        sb.append(", receiverMobile=").append(receiverMobile);
        sb.append(", receiverAddress=").append(receiverAddress);
        sb.append(", returnType=").append(returnType);
        sb.append(", isSubmitByEndUser=").append(isSubmitByEndUser);
        sb.append(", submitTime=").append(submitTime);
        sb.append(", approveTime=").append(approveTime);
        sb.append(", isApproved=").append(isApproved);
        sb.append(", rejectReason=").append(rejectReason);
        sb.append(", returnOrderCode=").append(returnOrderCode);
        sb.append(", needRefund=").append(needRefund);
        sb.append(", isRefunded=").append(isRefunded);
        sb.append(", isGoodsSentBack=").append(isGoodsSentBack);
        sb.append(", createTime=").append(createTime);
        sb.append(", createBy=").append(createBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}