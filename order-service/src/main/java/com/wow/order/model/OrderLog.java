package com.wow.order.model;

import java.io.Serializable;
import java.util.Date;

public class OrderLog implements Serializable {
    private Integer id;

    private Integer orderId;

    private String eventLog;

    private Date eventTime;

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

    public String getEventLog() {
        return eventLog;
    }

    public void setEventLog(String eventLog) {
        this.eventLog = eventLog;
    }

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderId=").append(orderId);
        sb.append(", eventLog=").append(eventLog);
        sb.append(", eventTime=").append(eventTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}