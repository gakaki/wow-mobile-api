package com.wow.user.vo.request;

import com.wow.common.request.ApiRequest;

/**
 * Created by zhengzhiqing on 16/7/12.
 */
public class UserCheckRequest extends ApiRequest {

    private String mobile;
    private String nickName;
    private String userName;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
