package com.wow.mobileapi.request.user;

import com.wow.common.request.ApiRequest;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by zhengzhiqing on 16/7/6.
 */
public class CaptchaRequest extends ApiRequest {

    private static final long serialVersionUID = 1L;

    @NotBlank
    private String mobile;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

}
