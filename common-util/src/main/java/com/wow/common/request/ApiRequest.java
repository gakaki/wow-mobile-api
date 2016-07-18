package com.wow.common.request;

import java.io.Serializable;

/**
 * 通用的请求类  包括系统级别的参数
 * 
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月11日 下午5:11:31 Exp $
 */
public class ApiRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    //token令牌 非必须
    private String sessionToken;

    //时间戳 格式为yyyy-MM-dd HH:mm:ss，例如：2011-06-16 13:23:30 非必须
    private String timestamp;
    
    //传递的参数 json格式表示
    private String paramJson;

    //1:android, 2:iOS, 3:others
    private byte channel;

    public byte getChannel() {
        return channel;
    }

    public void setChannel(byte channel) {
        this.channel = channel;
    }

    public String getParamJson() {
        return paramJson;
    }

    public void setParamJson(String paramJson) {
        this.paramJson = paramJson;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

}
