package com.wow.mobileapi.response.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;

/**
 * Created by zhengzhiqing on 16/7/21.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class BindWechatResponse extends CommonResponse {

    private static final long serialVersionUID = 1L;

    private String sessionToken;
    private String nickName;
    private boolean isNewUser;

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public boolean isNewUser() {
        return isNewUser;
    }

    public void setNewUser(boolean newUser) {
        isNewUser = newUser;
    }
}
