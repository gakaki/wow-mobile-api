package com.wow.user.vo;

/**
 * Created by zhengzhiqing on 16/7/6.
 */
public class RegisterResultVo {
    private boolean success;
    private String resCode;
    private String resMsg;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getResMsg() {
        return resMsg;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }
}
