package com.wow.user.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;

/**
 * Created by zhengzhiqing on 16/7/12.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class UserCheckResponse extends CommonResponse {

    private static final long serialVersionUID = 1L;

    private boolean existedUser;

    public boolean isExistedUser() {
        return existedUser;
    }

    public void setExistedUser(boolean existedUser) {
        this.existedUser = existedUser;
    }
}
