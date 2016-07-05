package com.wow.user.vo;

import com.wow.user.model.EndUserSession;

/**
 * Created by zhengzhiqing on 16/6/28.
 */
public class LoginResultVo {
    private String userName;
    private boolean isValidUser;
    private String errorMsg;
    private EndUserSession endUserSession;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isValidUser() {
        return isValidUser;
    }

    public void setValidUser(boolean validUser) {
        isValidUser = validUser;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public EndUserSession getEndUserSession() {
        return endUserSession;
    }

    public void setEndUserSession(EndUserSession endUserSession) {
        this.endUserSession = endUserSession;
    }
}
