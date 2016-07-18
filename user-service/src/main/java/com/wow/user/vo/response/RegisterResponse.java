package com.wow.user.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;

/**
 * Created by zhengzhiqing on 16/7/6.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class RegisterResponse extends CommonResponse {

    private static final long serialVersionUID = 1L;

    private int endUserId;

    public int getEndUserId() {
        return endUserId;
    }

    public void setEndUserId(int endUserId) {
        this.endUserId = endUserId;
    }
}
