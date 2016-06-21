package com.wow.product.model;

import java.io.Serializable;
import java.util.Date;

public class ProductComment implements Serializable {
    private Integer id;

    private Integer orderId;

    private Integer productId;

    private Integer endUserId;

    private Byte packagingScore;

    private Byte deliverySpeedScore;

    private Byte deliveryServiceAttituteScore;

    private Byte productSatisfactionScore;

    private String comments;

    private Date commentTime;

    private Boolean isApproved;

    private String csReply;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getEndUserId() {
        return endUserId;
    }

    public void setEndUserId(Integer endUserId) {
        this.endUserId = endUserId;
    }

    public Byte getPackagingScore() {
        return packagingScore;
    }

    public void setPackagingScore(Byte packagingScore) {
        this.packagingScore = packagingScore;
    }

    public Byte getDeliverySpeedScore() {
        return deliverySpeedScore;
    }

    public void setDeliverySpeedScore(Byte deliverySpeedScore) {
        this.deliverySpeedScore = deliverySpeedScore;
    }

    public Byte getDeliveryServiceAttituteScore() {
        return deliveryServiceAttituteScore;
    }

    public void setDeliveryServiceAttituteScore(Byte deliveryServiceAttituteScore) {
        this.deliveryServiceAttituteScore = deliveryServiceAttituteScore;
    }

    public Byte getProductSatisfactionScore() {
        return productSatisfactionScore;
    }

    public void setProductSatisfactionScore(Byte productSatisfactionScore) {
        this.productSatisfactionScore = productSatisfactionScore;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public Boolean getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(Boolean isApproved) {
        this.isApproved = isApproved;
    }

    public String getCsReply() {
        return csReply;
    }

    public void setCsReply(String csReply) {
        this.csReply = csReply;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderId=").append(orderId);
        sb.append(", productId=").append(productId);
        sb.append(", endUserId=").append(endUserId);
        sb.append(", packagingScore=").append(packagingScore);
        sb.append(", deliverySpeedScore=").append(deliverySpeedScore);
        sb.append(", deliveryServiceAttituteScore=").append(deliveryServiceAttituteScore);
        sb.append(", productSatisfactionScore=").append(productSatisfactionScore);
        sb.append(", comments=").append(comments);
        sb.append(", commentTime=").append(commentTime);
        sb.append(", isApproved=").append(isApproved);
        sb.append(", csReply=").append(csReply);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}