package com.wow.user.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;
import com.wow.user.vo.LoginResponseVo;

/**
 * Created by zhengzhiqing on 16/6/28.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class LoginResponse extends CommonResponse {

    private static final long serialVersionUID = 1L;

    private LoginResponseVo loginResponseVo;

    public LoginResponseVo getLoginResponseVo() {
        return loginResponseVo;
    }

    public void setLoginResponseVo(LoginResponseVo loginResponseVo) {
        this.loginResponseVo = loginResponseVo;
    }
}
