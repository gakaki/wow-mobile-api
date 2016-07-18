package com.wow.user.service;

import com.wow.common.response.CommonResponse;
import com.wow.user.model.EndUserLoginLog;
import com.wow.user.vo.response.LoginLogResponse;

/**
 * Created by zhengzhiqing on 16/7/16.
 */
public interface LoginLogService {

    CommonResponse addLoginLog(EndUserLoginLog endUserLoginLog);

    LoginLogResponse getLoginLogsByUserId(int endUserId);
}
