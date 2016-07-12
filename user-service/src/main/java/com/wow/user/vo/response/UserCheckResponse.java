package com.wow.user.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;

/**
 * Created by zhengzhiqing on 16/7/12.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class UserCheckResponse extends CommonResponse {
    private boolean isExistedUser;

    public boolean isExistedUser() {
        return isExistedUser;
    }

    public void setExistedUser(boolean existedUser) {
        isExistedUser = existedUser;
    }
}
