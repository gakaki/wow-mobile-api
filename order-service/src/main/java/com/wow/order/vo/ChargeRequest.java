package com.wow.order.vo;

import java.io.Serializable;

/**
 * Created by zhengzhiqing on 16/7/25.
 */
public class ChargeRequest implements Serializable {

    /**  */
    private static final long serialVersionUID = 1L;
    
    //订单号
    private String orderNo;
    
    //支付渠道
    private String channel;
    
    //客户端ip
    private String clientIp;

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

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }
}
