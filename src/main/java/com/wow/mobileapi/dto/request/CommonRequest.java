package com.wow.mobileapi.dto.request;

import java.io.Serializable;

/**
 * 通用的请求类  包括系统级别的参数
 * 
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月11日 下午5:11:31 Exp $
 */
public class CommonRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    //token令牌
    private String token;

    //app key每个客户端不一样
    private String appKey;

    //签名字段
    private String sign;

    //时间戳 格式为yyyy-MM-dd HH:mm:ss，例如：2011-06-16 13:23:30
    private String timestamp;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

}
