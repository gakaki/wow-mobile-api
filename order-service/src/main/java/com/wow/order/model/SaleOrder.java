package com.wow.order.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SaleOrder implements Serializable {
    private Integer id;

    private String orderCode;

    private Integer endUserId;

    private BigDecimal orderAmount;

    private BigDecimal productAmount;

    private BigDecimal deliveryFee;

    private BigDecimal couponAmount;

    private String receiverName;

    private String receiverProvince;

    private String receiverCity;

    private String receiverCounty;

    private String receiverTown;

    private String receiverPostcode;

    private String receiverAddress;

    private String receiverMobile;

    private String endUserRemarks;

    private Byte orderStatus;

    private Byte paymentStatus;

    private Byte paymentMethod;

    private Date paidTime;

    private Boolean isUseCoupon;

    private Integer endUserCouponId;
    
    private Integer totalPackages;

    private Byte deliveryMothod;

    private String deliveryCompanyName;

    private String deliveryOrderNo;

    private Date deliveryDate;

    private Byte goodsStatus;

    private Byte deliveryFailureReason;

    private Date receiveDate;

    private Boolean returnOnDelivery;

    private Date cancelRequestTime;

    private String cancelReason;

    private Date cancelApprovedTime;

    private Byte refundApprovalStatus;

    private Date refundApprovalTime;

    private String operatorName;

    private Boolean isLeaf;

    private Integer parentOrderId;

    private Byte orderSource;

    private Long orderIp;

    private String sellerRemarks;

    private Date orderCreateTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
    }

    public Integer getEndUserId() {
        return endUserId;
    }

    public void setEndUserId(Integer endUserId) {
        this.endUserId = endUserId;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public BigDecimal getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(BigDecimal productAmount) {
        this.productAmount = productAmount;
    }

    public BigDecimal getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(BigDecimal deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public BigDecimal getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(BigDecimal couponAmount) {
        this.couponAmount = couponAmount;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName == null ? null : receiverName.trim();
    }

    public String getReceiverProvince() {
        return receiverProvince;
    }

    public void setReceiverProvince(String receiverProvince) {
        this.receiverProvince = receiverProvince == null ? null : receiverProvince.trim();
    }

    public String getReceiverCity() {
        return receiverCity;
    }

    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity == null ? null : receiverCity.trim();
    }

    public String getReceiverCounty() {
        return receiverCounty;
    }

    public void setReceiverCounty(String receiverCounty) {
        this.receiverCounty = receiverCounty == null ? null : receiverCounty.trim();
    }

    public String getReceiverTown() {
        return receiverTown;
    }

    public void setReceiverTown(String receiverTown) {
        this.receiverTown = receiverTown == null ? null : receiverTown.trim();
    }

    public String getReceiverPostcode() {
        return receiverPostcode;
    }

    public void setReceiverPostcode(String receiverPostcode) {
        this.receiverPostcode = receiverPostcode == null ? null : receiverPostcode.trim();
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress == null ? null : receiverAddress.trim();
    }

    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile == null ? null : receiverMobile.trim();
    }

    public String getEndUserRemarks() {
        return endUserRemarks;
    }

    public void setEndUserRemarks(String endUserRemarks) {
        this.endUserRemarks = endUserRemarks == null ? null : endUserRemarks.trim();
    }

    public Byte getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Byte orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Byte getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Byte paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Byte getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Byte paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Date getPaidTime() {
        return paidTime;
    }

    public void setPaidTime(Date paidTime) {
        this.paidTime = paidTime;
    }

    public Boolean getIsUseCoupon() {
        return isUseCoupon;
    }

    public void setIsUseCoupon(Boolean isUseCoupon) {
        this.isUseCoupon = isUseCoupon;
    }

    public Integer getEndUserCouponId() {
        return endUserCouponId;
    }

    public void setEndUserCouponId(Integer endUserCouponId) {
        this.endUserCouponId = endUserCouponId;
    }

    public Byte getDeliveryMothod() {
        return deliveryMothod;
    }

    public void setDeliveryMothod(Byte deliveryMothod) {
        this.deliveryMothod = deliveryMothod;
    }

    public String getDeliveryCompanyName() {
        return deliveryCompanyName;
    }

    public void setDeliveryCompanyName(String deliveryCompanyName) {
        this.deliveryCompanyName = deliveryCompanyName == null ? null : deliveryCompanyName.trim();
    }

    public String getDeliveryOrderNo() {
        return deliveryOrderNo;
    }

    public void setDeliveryOrderNo(String deliveryOrderNo) {
        this.deliveryOrderNo = deliveryOrderNo == null ? null : deliveryOrderNo.trim();
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Byte getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(Byte goodsStatus) {
        this.goodsStatus = goodsStatus;
    }

    public Byte getDeliveryFailureReason() {
        return deliveryFailureReason;
    }

    public void setDeliveryFailureReason(Byte deliveryFailureReason) {
        this.deliveryFailureReason = deliveryFailureReason;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    public Boolean getReturnOnDelivery() {
        return returnOnDelivery;
    }

    public void setReturnOnDelivery(Boolean returnOnDelivery) {
        this.returnOnDelivery = returnOnDelivery;
    }

    public Date getCancelRequestTime() {
        return cancelRequestTime;
    }

    public void setCancelRequestTime(Date cancelRequestTime) {
        this.cancelRequestTime = cancelRequestTime;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason == null ? null : cancelReason.trim();
    }

    public Date getCancelApprovedTime() {
        return cancelApprovedTime;
    }

    public void setCancelApprovedTime(Date cancelApprovedTime) {
        this.cancelApprovedTime = cancelApprovedTime;
    }

    public Byte getRefundApprovalStatus() {
        return refundApprovalStatus;
    }

    public void setRefundApprovalStatus(Byte refundApprovalStatus) {
        this.refundApprovalStatus = refundApprovalStatus;
    }

    public Date getRefundApprovalTime() {
        return refundApprovalTime;
    }

    public void setRefundApprovalTime(Date refundApprovalTime) {
        this.refundApprovalTime = refundApprovalTime;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName == null ? null : operatorName.trim();
    }

    public Boolean getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(Boolean isLeaf) {
        this.isLeaf = isLeaf;
    }

    public Integer getParentOrderId() {
        return parentOrderId;
    }

    public void setParentOrderId(Integer parentOrderId) {
        this.parentOrderId = parentOrderId;
    }

    public Byte getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(Byte orderSource) {
        this.orderSource = orderSource;
    }

    public Long getOrderIp() {
        return orderIp;
    }

    public void setOrderIp(Long orderIp) {
        this.orderIp = orderIp;
    }

    public String getSellerRemarks() {
        return sellerRemarks;
    }

    public void setSellerRemarks(String sellerRemarks) {
        this.sellerRemarks = sellerRemarks == null ? null : sellerRemarks.trim();
    }

    public Date getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(Date orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getTotalPackages() {
        return totalPackages;
    }

    public void setTotalPackages(Integer totalPackages) {
        this.totalPackages = totalPackages;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderCode=").append(orderCode);
        sb.append(", endUserId=").append(endUserId);
        sb.append(", orderAmount=").append(orderAmount);
        sb.append(", productAmount=").append(productAmount);
        sb.append(", deliveryFee=").append(deliveryFee);
        sb.append(", couponAmount=").append(couponAmount);
        sb.append(", receiverName=").append(receiverName);
        sb.append(", receiverProvince=").append(receiverProvince);
        sb.append(", receiverCity=").append(receiverCity);
        sb.append(", receiverCounty=").append(receiverCounty);
        sb.append(", receiverTown=").append(receiverTown);
        sb.append(", receiverPostcode=").append(receiverPostcode);
        sb.append(", receiverAddress=").append(receiverAddress);
        sb.append(", receiverMobile=").append(receiverMobile);
        sb.append(", endUserRemarks=").append(endUserRemarks);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", paymentStatus=").append(paymentStatus);
        sb.append(", paymentMethod=").append(paymentMethod);
        sb.append(", paidTime=").append(paidTime);
        sb.append(", isUseCoupon=").append(isUseCoupon);
        sb.append(", endUserCouponId=").append(endUserCouponId);
        sb.append(", deliveryMothod=").append(deliveryMothod);
        sb.append(", deliveryCompanyName=").append(deliveryCompanyName);
        sb.append(", deliveryOrderNo=").append(deliveryOrderNo);
        sb.append(", deliveryDate=").append(deliveryDate);
        sb.append(", goodsStatus=").append(goodsStatus);
        sb.append(", deliveryFailureReason=").append(deliveryFailureReason);
        sb.append(", receiveDate=").append(receiveDate);
        sb.append(", returnOnDelivery=").append(returnOnDelivery);
        sb.append(", cancelRequestTime=").append(cancelRequestTime);
        sb.append(", cancelReason=").append(cancelReason);
        sb.append(", cancelApprovedTime=").append(cancelApprovedTime);
        sb.append(", refundApprovalStatus=").append(refundApprovalStatus);
        sb.append(", refundApprovalTime=").append(refundApprovalTime);
        sb.append(", operatorName=").append(operatorName);
        sb.append(", isLeaf=").append(isLeaf);
        sb.append(", parentOrderId=").append(parentOrderId);
        sb.append(", orderSource=").append(orderSource);
        sb.append(", orderIp=").append(orderIp);
        sb.append(", sellerRemarks=").append(sellerRemarks);
        sb.append(", orderCreateTime=").append(orderCreateTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}