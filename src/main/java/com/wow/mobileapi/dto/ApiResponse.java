package com.wow.mobileapi.dto;

import java.io.Serializable;

/**
 * Created by zhengzhiqing on 16/6/27.
 */
public class ApiResponse implements Serializable {

    private String resCode;
    private String resMsg;
    private Object data;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String toString() {
        return "resCode:" + resCode + ",resMsg:" + resMsg + ",data:" + data;
    }
}
