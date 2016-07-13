package com.wow.user.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;
import com.wow.user.model.EndUserSession;

/**
 * Created by zhengzhiqing on 16/6/28.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class LoginResponse extends CommonResponse {
    private EndUserSession endUserSession;

    public EndUserSession getEndUserSession() {
        return endUserSession;
    }

    public void setEndUserSession(EndUserSession endUserSession) {
        this.endUserSession = endUserSession;
    }
}
