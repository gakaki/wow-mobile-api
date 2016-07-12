package com.wow.user.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;
import com.wow.user.model.EndUser;

/**
 * Created by zhengzhiqing on 16/7/12.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class UserResponse extends CommonResponse {

    private EndUser endUser;

    public EndUser getEndUser() {
        return endUser;
    }

    public void setEndUser(EndUser endUser) {
        this.endUser = endUser;
    }
}
