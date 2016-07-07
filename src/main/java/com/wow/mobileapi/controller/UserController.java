package com.wow.mobileapi.controller;

import com.wow.common.error.ErrorRepositoryManager;
import com.wow.common.util.ValidatorUtil;
import com.wow.mobileapi.dto.ApiResponse;
import com.wow.mobileapi.util.ResponseUtil;
import com.wow.user.model.EndUser;
import com.wow.user.service.UserService;
import com.wow.user.vo.RegisterRequestVo;
import com.wow.user.vo.RegisterResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private ErrorRepositoryManager errorRepositoryManager;

    @Autowired
    private ResponseUtil responseUtil;

    @RequestMapping(value = "/{endUserId}", method = RequestMethod.GET)
    public ApiResponse getEndUserById(@PathVariable Integer endUserId) {
        ApiResponse apiResponse = new ApiResponse();
        if (endUserId == null) {
            apiResponse.setResCode("40000");
            apiResponse.setResMsg("请指定用户ID");
        } else {
            EndUser endUser = userService.getEndUserById(endUserId);
            apiResponse.setResCode("0");
            apiResponse.setResMsg("success");
            apiResponse.setData(endUser);
        }
        return apiResponse;
    }

    /**
     * 用户注册(创建新用户)
     * @param registerRequestVo
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ApiResponse register(@Validated @RequestBody RegisterRequestVo registerRequestVo,
                                BindingResult result) {
        ApiResponse apiResponse = new ApiResponse();

        if (result.hasErrors()) {
            responseUtil.setResponse(apiResponse,"40000");
            Map<String, String> map = ValidatorUtil.getErrors(result);
            apiResponse.setData(map);
        } else {
            RegisterResultVo registerResultVo = userService.register(registerRequestVo);
            if (registerResultVo.isSuccess()) {
                responseUtil.setResponse(apiResponse,"0");
                apiResponse.setData("注册成功");
            } else {
                apiResponse.setResCode(registerResultVo.getResCode());
                apiResponse.setResMsg(errorRepositoryManager.getErrorMsg(registerResultVo.getResCode()));
                apiResponse.setData("注册失败");
            }
        }
        return apiResponse;
    }

    /**
     * 修改用户信息
     * @param endUserId
     * @return
     */
    @RequestMapping(value = "/{endUserId}", method = RequestMethod.PUT)
    public ApiResponse updateUser(@RequestBody EndUser updatedEndUser, @PathVariable Integer endUserId) {
        ApiResponse apiResponse = new ApiResponse();
        if (updatedEndUser.getId() == null) {
            updatedEndUser.setId(endUserId);
        }
        boolean isSuccess =  (userService.updateEndUser(updatedEndUser) == 1);
        responseUtil.setResponse(apiResponse,"0");
        apiResponse.setData(isSuccess);
        return apiResponse;
    }

    @RequestMapping(value = "/{endUserId}", method = RequestMethod.DELETE)
    public ApiResponse deleteUser(@PathVariable Integer endUserId) {
        ApiResponse apiResponse = new ApiResponse();
        boolean isSuccess = (userService.deleteUser(endUserId)==1);
        responseUtil.setResponse(apiResponse,"0");
        apiResponse.setData(isSuccess);
        return apiResponse;
    }

    @RequestMapping(value = "/mobile", method = RequestMethod.GET)
    public ApiResponse isExistedUserByMobile(
            @RequestParam(value = "mobile", required = true) String mobile) {
        ApiResponse apiResponse = new ApiResponse();
        boolean isSuccess = (userService.isExistedUserByMobile(mobile));
        responseUtil.setResponse(apiResponse,"0");
        apiResponse.setData(isSuccess);
        return apiResponse;
    }

    @RequestMapping(value = "/nickname", method = RequestMethod.GET)
    public ApiResponse isExistedUserByNickName(
            @RequestParam(value = "nickName", required = true) String nickName) {
        ApiResponse apiResponse = new ApiResponse();
        boolean isSuccess = (userService.isExistedUserByNickName(nickName));
        responseUtil.setResponse(apiResponse,"0");
        apiResponse.setData(isSuccess);
        return apiResponse;
    }

    @RequestMapping(value = "/captcha", method = RequestMethod.POST)
    public ApiResponse requestCaptcha(
            @RequestParam(value = "mobile", required = true) String mobile) {
        ApiResponse apiResponse = new ApiResponse();
        String captcha = (userService.getCaptcha(mobile));
        responseUtil.setResponse(apiResponse,"0");
        apiResponse.setData("验证码已发送,请查看手机短信之后输入");
        return apiResponse;
    }

}