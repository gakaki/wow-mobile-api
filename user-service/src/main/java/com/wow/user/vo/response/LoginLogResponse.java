package com.wow.user.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;
import com.wow.user.model.EndUserLoginLog;

import java.util.List;

/**
 * Created by zhengzhiqing on 16/6/28.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class LoginLogResponse extends CommonResponse {

    private static final long serialVersionUID = 1L;

    private List<EndUserLoginLog> endUserLoginLogList;

    public List<EndUserLoginLog> getEndUserLoginLogList() {
        return endUserLoginLogList;
    }

    public void setEndUserLoginLogList(List<EndUserLoginLog> endUserLoginLogList) {
        this.endUserLoginLogList = endUserLoginLogList;
    }
}
