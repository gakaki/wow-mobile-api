package com.wow.order.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * 订单vo
 * @author kaiwei
 * @version V1.0 2016年8月9日 上午11:20:30 Exp
 */
public class SaleOrderVo implements Serializable {
    private Integer id;

    private String orderCode;

    private Integer endUserId;

    private BigDecimal productAmount;

    private BigDecimal deliveryFee;

    private BigDecimal orderAmount;

    private Integer totalProductQty;

    private Integer unShipOutQty;

    private String receiverName;

    private String receiverProvince;

    private String receiverCity;

    private String receiverCounty;

    private String receiverTown;

    private String receiverAddress;

    private String receiverPostcode;

    private String receiverMobile;

    private String endUserRemark;

    private Byte orderStatus;

    //期望订单状态
    private Byte expectOrderStatus;
    
    //期望订单支付状态
    private Byte expectPaymentStatus;

    private Byte paymentStatus;

    private Byte paymentMethod;

    private Date paidTime;

    private Boolean isUseCoupon;

    private BigDecimal preferentialAmount;

    private Integer endUserCouponId;

    private Date cancelRequestTime;

    private String cancelReason;

    private Date cancelApprovedTime;

    private Byte refundApprovalStatus;

    private Date refundApprovalTime;

    private String operatorName;

    private Byte orderSource;

    private Long orderIp;

    private String sellerRemark;

    private Date orderCreateTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
    
    public Byte getExpectPaymentStatus() {
        return expectPaymentStatus;
    }

    public void setExpectPaymentStatus(Byte expectPaymentStatus) {
        this.expectPaymentStatus = expectPaymentStatus;
    }

    public Byte getExpectOrderStatus() {
        return expectOrderStatus;
    }

    public void setExpectOrderStatus(Byte expectOrderStatus) {
        this.expectOrderStatus = expectOrderStatus;
    }

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

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Integer getTotalProductQty() {
        return totalProductQty;
    }

    public void setTotalProductQty(Integer totalProductQty) {
        this.totalProductQty = totalProductQty;
    }

    public Integer getUnShipOutQty() {
        return unShipOutQty;
    }

    public void setUnShipOutQty(Integer unShipOutQty) {
        this.unShipOutQty = unShipOutQty;
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

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress == null ? null : receiverAddress.trim();
    }

    public String getReceiverPostcode() {
        return receiverPostcode;
    }

    public void setReceiverPostcode(String receiverPostcode) {
        this.receiverPostcode = receiverPostcode == null ? null : receiverPostcode.trim();
    }

    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile == null ? null : receiverMobile.trim();
    }

    public String getEndUserRemark() {
        return endUserRemark;
    }

    public void setEndUserRemark(String endUserRemark) {
        this.endUserRemark = endUserRemark == null ? null : endUserRemark.trim();
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

    public BigDecimal getPreferentialAmount() {
        return preferentialAmount;
    }

    public void setPreferentialAmount(BigDecimal preferentialAmount) {
        this.preferentialAmount = preferentialAmount;
    }

    public Integer getEndUserCouponId() {
        return endUserCouponId;
    }

    public void setEndUserCouponId(Integer endUserCouponId) {
        this.endUserCouponId = endUserCouponId;
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

    public String getSellerRemark() {
        return sellerRemark;
    }

    public void setSellerRemark(String sellerRemark) {
        this.sellerRemark = sellerRemark == null ? null : sellerRemark.trim();
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

}