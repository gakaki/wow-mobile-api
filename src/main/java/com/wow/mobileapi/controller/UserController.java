package com.wow.mobileapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wow.common.response.ApiResponse;
import com.wow.common.util.ErrorCodeUtil;
import com.wow.common.util.JsonUtil;
import com.wow.common.util.ValidatorUtil;
import com.wow.mobileapi.dto.MobileRequestVo;
import com.wow.mobileapi.util.ResponseUtil;
import com.wow.user.model.EndUser;
import com.wow.user.model.EndUserWechat;
import com.wow.user.service.UserService;
import com.wow.user.vo.RegisterRequestVo;
import com.wow.user.vo.RegisterResultVo;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private ResponseUtil responseUtil;

    @RequestMapping(value = "/{endUserId}", method = RequestMethod.GET)
    //TODO: 防止水平权限问题
    public ApiResponse getEndUserById(@PathVariable Integer endUserId) {
        logger.info("根据ID查询用户:" + endUserId);
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
        logger.info("根据ID查询用户,返回结果:" + JsonUtil.pojo2Json(apiResponse));
        return apiResponse;
    }

    /**
     * 用户注册(创建新用户)
     * @param registerRequestVo
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ApiResponse register(@Validated @RequestBody RegisterRequestVo registerRequestVo, BindingResult result) {
        ApiResponse apiResponse = new ApiResponse();
        logger.info("用户注册, request=" + registerRequestVo);
        if (result.hasErrors()) {
            apiResponse.setResCode("40000");
            apiResponse.setResMsg(ValidatorUtil.getError(result));
        } else {
            RegisterResultVo registerResultVo = userService.register(registerRequestVo);
            if (registerResultVo.isSuccess()) {
                responseUtil.setResponse(apiResponse, "0");
                apiResponse.setData(registerResultVo);
            } else {
                apiResponse.setResCode(registerResultVo.getResCode());
                apiResponse.setResMsg(ErrorCodeUtil.getErrorMsg(registerResultVo.getResCode()));
                apiResponse.setData(registerResultVo);
            }
        }
        logger.info("用户注册,返回结果:" + JsonUtil.pojo2Json(apiResponse));
        return apiResponse;
    }

    /**
     * 修改用户信息
     * @param updatedEndUser
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ApiResponse updateUser(@Validated @RequestBody EndUser updatedEndUser) {
        logger.info("更新用户:" + updatedEndUser);
        ApiResponse apiResponse = new ApiResponse();
        boolean isSuccess = (userService.updateEndUser(updatedEndUser) == 1);
        responseUtil.setResponse(apiResponse, "0");
        apiResponse.setData(isSuccess);
        logger.info("更新用户,返回结果:" + JsonUtil.pojo2Json(apiResponse));
        return apiResponse;
    }

    @RequestMapping(value = "/mobile", method = RequestMethod.GET)
    public ApiResponse isExistedUserByMobile(@RequestParam String mobile) {
        logger.info("检查是否存在指定手机号的用户:" + mobile);
        ApiResponse apiResponse = new ApiResponse();
        boolean isSuccess = (userService.isExistedUserByMobile(mobile));
        responseUtil.setResponse(apiResponse, "0");
        apiResponse.setData(isSuccess);
        logger.info("检查是否存在指定手机号的用户,返回结果:" + JsonUtil.pojo2Json(apiResponse));
        return apiResponse;
    }

    @RequestMapping(value = "/nickname", method = RequestMethod.GET)
    public ApiResponse isExistedUserByNickName(@RequestParam String nickName) {
        logger.info("检查是否存在指定昵称的用户:" + nickName);
        ApiResponse apiResponse = new ApiResponse();
        boolean isSuccess = (userService.isExistedUserByNickName(nickName));
        responseUtil.setResponse(apiResponse, "0");
        apiResponse.setData(isSuccess);
        logger.info("检查是否存在指定昵称的用户,返回结果:" + JsonUtil.pojo2Json(apiResponse));
        return apiResponse;
    }

    @RequestMapping(value = "/captcha", method = RequestMethod.POST)
    public ApiResponse requestCaptcha(@RequestBody MobileRequestVo mobileRequestVo) {
        logger.info("请求发送手机验证码:" + mobileRequestVo.getMobile());
        ApiResponse apiResponse = new ApiResponse();
        // String captcha = (userService.sendCaptcha(mobileRequestVo.getMobile()));
        responseUtil.setResponse(apiResponse, "0");
        apiResponse.setData("1");
        logger.info("请求发送手机验证码,返回结果:" + JsonUtil.pojo2Json(apiResponse));
        return apiResponse;
    }

    /**
     * 检查是否绑定微信
     * @param mobile
     * @return
     */
    @RequestMapping(value = "/wechat-bind-status", method = RequestMethod.GET)
    public ApiResponse checkWechatBindStatus(@RequestParam String mobile) {
        logger.info("检查手机是否已注册并绑定微信:" + mobile);
        ApiResponse apiResponse = new ApiResponse();
        //WechatBindingStatusVo wechatBindingStatusVo = userService.checkWechatBindStatus(mobile);
        responseUtil.setResponse(apiResponse, "0");
        // apiResponse.setData(wechatBindingStatusVo);
        logger.info("检查手机是否已注册并绑定微信,返回结果:" + JsonUtil.pojo2Json(apiResponse));
        return apiResponse;
    }

    /**
     * 绑定微信
     * @param endUserWechat
     * @return
     */
    @RequestMapping(value = "/wechat-bind", method = RequestMethod.POST)
    public ApiResponse bindWechat(@RequestBody EndUserWechat endUserWechat) {
        logger.info("绑定微信:" + endUserWechat);
        ApiResponse apiResponse = new ApiResponse();
        int i = userService.bindWechatToUser(endUserWechat);
        if (i == 1) {
            responseUtil.setResponse(apiResponse, "0");
            apiResponse.setData(endUserWechat);
        } else {
            responseUtil.setResponse(apiResponse, "50000");
        }
        logger.info("绑定微信,返回结果:" + JsonUtil.pojo2Json(apiResponse));
        return apiResponse;
    }

}