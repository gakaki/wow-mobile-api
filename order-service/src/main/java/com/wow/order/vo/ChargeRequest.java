package com.wow.order.vo;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by zhengzhiqing on 16/7/25.
 */
public class ChargeRequest implements Serializable {

    /**  */
    private static final long serialVersionUID = 1L;
    private String orderNo;
    private String channel;
    private Integer amount;
    private String clientIp;
    private String subject;
    private String body;
    private Map<String, Object> extra;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Map<String, Object> getExtra() {
        return extra;
    }

    public void setExtra(Map<String, Object> extra) {
        this.extra = extra;
    }
}
