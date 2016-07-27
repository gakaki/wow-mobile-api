package com.wow.order.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SaleOrderPay implements Serializable {
    private Integer id;

    private Integer saleOrderId;

    private String orderCode;

    private String transactionNo;

    private String chargeId;

    private String channel;

    private BigDecimal amount;

    private Date timePaid;

    private String description;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSaleOrderId() {
        return saleOrderId;
    }

    public void setSaleOrderId(Integer saleOrderId) {
        this.saleOrderId = saleOrderId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
    }

    public String getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo == null ? null : transactionNo.trim();
    }

    public String getChargeId() {
        return chargeId;
    }

    public void setChargeId(String chargeId) {
        this.chargeId = chargeId == null ? null : chargeId.trim();
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel == null ? null : channel.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getTimePaid() {
        return timePaid;
    }

    public void setTimePaid(Date timePaid) {
        this.timePaid = timePaid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", saleOrderId=").append(saleOrderId);
        sb.append(", orderCode=").append(orderCode);
        sb.append(", transactionNo=").append(transactionNo);
        sb.append(", chargeId=").append(chargeId);
        sb.append(", channel=").append(channel);
        sb.append(", amount=").append(amount);
        sb.append(", timePaid=").append(timePaid);
        sb.append(", description=").append(description);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}