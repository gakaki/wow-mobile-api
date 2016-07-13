package com.wow.user.vo.request;

import com.wow.common.request.ApiRequest;
import com.wow.user.model.EndUser;

/**
 * Created by zhengzhiqing on 16/7/12.
 */
public class UserUpdateRequest extends ApiRequest {
    private EndUser endUser;

    public EndUser getEndUser() {
        return endUser;
    }

    public void setEndUser(EndUser endUser) {
        this.endUser = endUser;
    }
}
