package com.wow.user.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;

/**
 * Created by zhengzhiqing on 16/6/28.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class LogoutResponse extends CommonResponse {

    private boolean success;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
