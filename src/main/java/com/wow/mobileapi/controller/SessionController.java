package com.wow.mobileapi.controller;

import com.wow.common.response.ApiResponse;
import com.wow.common.util.ValidatorUtil;
import com.wow.mobileapi.util.ResponseUtil;
import com.wow.user.service.SessionService;
import com.wow.user.vo.LoginRequestVo;
import com.wow.user.vo.LoginResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 登录、登出
 * Created by zhengzhiqing on 16/6/23.
 */
@RestController
@RequestMapping("/v1/sessions")
public class SessionController {

    private static final Logger logger = LoggerFactory.getLogger(SessionController.class);

    @Autowired
    private SessionService sessionService;
    @Autowired
    private ResponseUtil responseUtil;

    /**
     * 创建新的会话(登入)
     * @param loginRequestVo
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ApiResponse login(@Validated @RequestBody LoginRequestVo loginRequestVo,
                             BindingResult result) {
        ApiResponse apiResponse = new ApiResponse();
        if (result.hasErrors()) {
            apiResponse.setResCode("40000");
            apiResponse.setResMsg(ValidatorUtil.getError(result));
        } else {
            //TODO: 可能会需要从header中获取部分信息,放到LoginRequestVo,比如login channel
            LoginResultVo loginResultVo = sessionService.login(loginRequestVo);
            if (loginResultVo.isValidUser()) {
                responseUtil.setResponse(apiResponse,"0");
                apiResponse.setData(loginResultVo.getEndUserSession());
            } else {
                responseUtil.setResponse(apiResponse,"40203");
                apiResponse.setData(loginResultVo.getEndUserSession());
            }
        }
        return apiResponse;
    }

    /**
     * 销毁当前会话(登出)
     * @param endUserId
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE)
    public ApiResponse logout(@PathVariable Integer endUserId, @PathVariable byte loginChannel) {
        ApiResponse apiResponse = new ApiResponse();
        boolean isSuccess = (sessionService.logout(endUserId,loginChannel)==1);
        responseUtil.setResponse(apiResponse,"0");
        apiResponse.setData(isSuccess);
        return apiResponse;
    }
}
