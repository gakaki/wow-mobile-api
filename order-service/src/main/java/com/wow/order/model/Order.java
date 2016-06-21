package com.wow.order.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Order implements Serializable {
    private Integer id;

    private Integer endUserId;

    private String orderCode;

    private BigDecimal orderAmount;

    private BigDecimal productAmount;

    private Byte orderSource;

    private Integer orderIp;

    private Date placeOrderTime;

    private String endUserRemarks;

    private String sellerRemarks;

    private Integer parentOrderId;

    private Boolean isLeaf;

    private Byte orderStatus;

    private Byte failureReason;

    private Byte goodsStatus;

    private Byte paymentStatus;

    private Byte paymentMethod;

    private Date paidTime;

    private String receiverName;

    private String receiverAddress;

    private String receiverProvince;

    private String receiverCity;

    private String receiverCounty;

    private String receiverTown;

    private String receiverPostcode;

    private String receiverMobile;

    private BigDecimal freightFee;

    private Byte deliveryMothod;

    private String deliveryCompanyName;

    private String deliveryOrderNo;

    private Date deliveryDate;

    private Date receiveDate;

    private Boolean returnOnDelivery;

    private Date cancelRequestTime;

    private String cancelReason;

    private Date cancelApprovedTime;

    private Byte refundApprovalStatus;

    private Date refundApprovalTime;

    private String operatorName;

    private Boolean isUseCoupon;

    private Integer endUserCouponId;

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

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
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

    public Byte getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(Byte orderSource) {
        this.orderSource = orderSource;
    }

    public Integer getOrderIp() {
        return orderIp;
    }

    public void setOrderIp(Integer orderIp) {
        this.orderIp = orderIp;
    }

    public Date getPlaceOrderTime() {
        return placeOrderTime;
    }

    public void setPlaceOrderTime(Date placeOrderTime) {
        this.placeOrderTime = placeOrderTime;
    }

    public String getEndUserRemarks() {
        return endUserRemarks;
    }

    public void setEndUserRemarks(String endUserRemarks) {
        this.endUserRemarks = endUserRemarks;
    }

    public String getSellerRemarks() {
        return sellerRemarks;
    }

    public void setSellerRemarks(String sellerRemarks) {
        this.sellerRemarks = sellerRemarks;
    }

    public Integer getParentOrderId() {
        return parentOrderId;
    }

    public void setParentOrderId(Integer parentOrderId) {
        this.parentOrderId = parentOrderId;
    }

    public Boolean getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(Boolean isLeaf) {
        this.isLeaf = isLeaf;
    }

    public Byte getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Byte orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Byte getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(Byte failureReason) {
        this.failureReason = failureReason;
    }

    public Byte getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(Byte goodsStatus) {
        this.goodsStatus = goodsStatus;
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

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getReceiverProvince() {
        return receiverProvince;
    }

    public void setReceiverProvince(String receiverProvince) {
        this.receiverProvince = receiverProvince;
    }

    public String getReceiverCity() {
        return receiverCity;
    }

    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
    }

    public String getReceiverCounty() {
        return receiverCounty;
    }

    public void setReceiverCounty(String receiverCounty) {
        this.receiverCounty = receiverCounty;
    }

    public String getReceiverTown() {
        return receiverTown;
    }

    public void setReceiverTown(String receiverTown) {
        this.receiverTown = receiverTown;
    }

    public String getReceiverPostcode() {
        return receiverPostcode;
    }

    public void setReceiverPostcode(String receiverPostcode) {
        this.receiverPostcode = receiverPostcode;
    }

    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    public BigDecimal getFreightFee() {
        return freightFee;
    }

    public void setFreightFee(BigDecimal freightFee) {
        this.freightFee = freightFee;
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
        this.deliveryCompanyName = deliveryCompanyName;
    }

    public String getDeliveryOrderNo() {
        return deliveryOrderNo;
    }

    public void setDeliveryOrderNo(String deliveryOrderNo) {
        this.deliveryOrderNo = deliveryOrderNo;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
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
        this.cancelReason = cancelReason;
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
        this.operatorName = operatorName;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", endUserId=").append(endUserId);
        sb.append(", orderCode=").append(orderCode);
        sb.append(", orderAmount=").append(orderAmount);
        sb.append(", productAmount=").append(productAmount);
        sb.append(", orderSource=").append(orderSource);
        sb.append(", orderIp=").append(orderIp);
        sb.append(", placeOrderTime=").append(placeOrderTime);
        sb.append(", endUserRemarks=").append(endUserRemarks);
        sb.append(", sellerRemarks=").append(sellerRemarks);
        sb.append(", parentOrderId=").append(parentOrderId);
        sb.append(", isLeaf=").append(isLeaf);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", failureReason=").append(failureReason);
        sb.append(", goodsStatus=").append(goodsStatus);
        sb.append(", paymentStatus=").append(paymentStatus);
        sb.append(", paymentMethod=").append(paymentMethod);
        sb.append(", paidTime=").append(paidTime);
        sb.append(", receiverName=").append(receiverName);
        sb.append(", receiverAddress=").append(receiverAddress);
        sb.append(", receiverProvince=").append(receiverProvince);
        sb.append(", receiverCity=").append(receiverCity);
        sb.append(", receiverCounty=").append(receiverCounty);
        sb.append(", receiverTown=").append(receiverTown);
        sb.append(", receiverPostcode=").append(receiverPostcode);
        sb.append(", receiverMobile=").append(receiverMobile);
        sb.append(", freightFee=").append(freightFee);
        sb.append(", deliveryMothod=").append(deliveryMothod);
        sb.append(", deliveryCompanyName=").append(deliveryCompanyName);
        sb.append(", deliveryOrderNo=").append(deliveryOrderNo);
        sb.append(", deliveryDate=").append(deliveryDate);
        sb.append(", receiveDate=").append(receiveDate);
        sb.append(", returnOnDelivery=").append(returnOnDelivery);
        sb.append(", cancelRequestTime=").append(cancelRequestTime);
        sb.append(", cancelReason=").append(cancelReason);
        sb.append(", cancelApprovedTime=").append(cancelApprovedTime);
        sb.append(", refundApprovalStatus=").append(refundApprovalStatus);
        sb.append(", refundApprovalTime=").append(refundApprovalTime);
        sb.append(", operatorName=").append(operatorName);
        sb.append(", isUseCoupon=").append(isUseCoupon);
        sb.append(", endUserCouponId=").append(endUserCouponId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}