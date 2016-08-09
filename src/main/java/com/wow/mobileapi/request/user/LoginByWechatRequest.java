package com.wow.mobileapi.request.user;

import com.wow.common.request.ApiRequest;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by zhengzhiqing on 16/6/28.
 */
public class LoginByWechatRequest extends ApiRequest {

    private static final long serialVersionUID = 1L;

    @NotBlank
    private String openId;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}
