package com.wow.mobileapi.request.user;

import com.wow.common.request.ApiRequest;

/**
 * Created by zhengzhiqing on 16/7/12.
 */
public class UserQueryRequest extends ApiRequest {
    private int endUserId;

    public int getEndUserId() {
        return endUserId;
    }

    public void setEndUserId(int endUserId) {
        this.endUserId = endUserId;
    }
}
