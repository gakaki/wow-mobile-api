package com.wow.user.vo.request;

import com.wow.common.request.ApiRequest;

/**
 * Created by zhengzhiqing on 16/7/6.
 */
public class CaptchaRequest extends ApiRequest {

    private String mobile;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

}
