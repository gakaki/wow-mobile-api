package com.wow.mobileapi.response.sdk;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;

/**
 * Created by zhengzhiqing on 16/7/21.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class QiniuResponse extends CommonResponse {

    private static final long serialVersionUID = 1L;

    //七牛token
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
