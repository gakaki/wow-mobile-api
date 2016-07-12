package com.wow.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by zhengzhiqing on 16/6/27.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ApiResponse extends CommonResponse {

    private static final long serialVersionUID = 1L;

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String toString() {
        return "data:" + data;
    }
}
