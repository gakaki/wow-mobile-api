package com.wow.user.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;

/**
 * Created by zhengzhiqing on 16/7/9.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class WechatBindingStatusResponse extends CommonResponse {

    private boolean registered;
    private boolean binded;
    private String mobile;
    private String wechatId;

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    public boolean isBinded() {
        return binded;
    }

    public void setBinded(boolean binded) {
        this.binded = binded;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }
}
