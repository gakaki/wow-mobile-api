package com.wow.mobileapi.controller;

import com.wow.common.request.ApiRequest;
import com.wow.common.response.ApiResponse;
import com.wow.common.response.CommonResponse;
import com.wow.common.util.BeanUtil;
import com.wow.common.util.JsonUtil;
import com.wow.common.util.StringUtil;
import com.wow.common.util.ValidatorUtil;
import com.wow.mobileapi.request.user.*;
import com.wow.user.constant.CaptchaTemplate;
import com.wow.user.model.EndUser;
import com.wow.user.model.EndUserWechat;
import com.wow.user.service.CaptchaService;
import com.wow.user.service.UserService;
import com.wow.user.vo.response.RegisterResponse;
import com.wow.user.vo.response.UserCheckResponse;
import com.wow.user.vo.response.UserResponse;
import com.wow.user.vo.response.WechatBindStatusResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private CaptchaService captchaService;

    @Value("${redis.captcha.register.timeout}")
    private long registerCaptchaTimeout;

    /**
     * 根据ID查找用户信息
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/user", method = RequestMethod.GET)
    public ApiResponse getEndUserById(ApiRequest apiRequest) {
        ApiResponse apiResponse = new ApiResponse();
        UserQueryRequest userQueryRequest = JsonUtil.fromJSON(apiRequest.getParamJson(), UserQueryRequest.class);
        //判断json格式参数是否有误
        if (userQueryRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }

        String errorMsg = ValidatorUtil.getError(userQueryRequest);
        //如果校验错误 则返回
        if (StringUtil.isNotEmpty(errorMsg)) {
            setInvalidParameterResponse(apiResponse, errorMsg);
            return apiResponse;
        }

        int endUserId = userQueryRequest.getEndUserId();

        logger.info("根据ID查询用户:" + endUserId);
        try {
            UserResponse userResponse = userService.getEndUserById(endUserId);
            //如果处理失败 则返回错误信息
            if (!isServiceCallSuccess(userResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, userResponse);
            } else {
                apiResponse.setData(userResponse.getEndUser());
            }
        } catch (Exception e) {
            logger.error("根据ID查找用户错误---" + e);
            e.printStackTrace();
            setInternalErrorResponse(apiResponse);
        }
        logger.info("根据ID查询用户,返回结果:" + JsonUtil.pojo2Json(apiResponse));
        return apiResponse;
    }

    /**
     * 用户注册(创建新用户)
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/user", method = RequestMethod.POST)
    public ApiResponse register(ApiRequest apiRequest) {

        ApiResponse apiResponse = new ApiResponse();

        RegisterRequest registerRequest = JsonUtil.fromJSON(apiRequest.getParamJson(), RegisterRequest.class);
        //判断json格式参数是否有误
        if (registerRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }

        String errorMsg = ValidatorUtil.getError(registerRequest);
        //如果校验错误 则返回
        if (StringUtil.isNotEmpty(errorMsg)) {
            setInvalidParameterResponse(apiResponse, errorMsg);
            return apiResponse;
        }

        EndUser endUser = new EndUser();
        BeanUtil.copyProperties(registerRequest,endUser);

        try {
            RegisterResponse registerResponse = userService.register(endUser, registerRequest.getCaptcha());
            //如果处理失败 则返回错误信息
            if (!isServiceCallSuccess(registerResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, registerResponse);
            } else {
                apiResponse.setData(registerResponse.getEndUserId());
            }
        } catch (Exception e) {
            logger.error("注册发生错误---" + e);
            setInternalErrorResponse(apiResponse);
        }
        logger.info("用户注册,返回结果:" + JsonUtil.pojo2Json(apiResponse));
        return apiResponse;
    }

    /**
     * 修改用户信息
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/user/change", method = RequestMethod.POST)
    public ApiResponse updateUser(ApiRequest apiRequest) {
        ApiResponse apiResponse = new ApiResponse();
        logger.info("paramJson=" + apiRequest.getParamJson());
        UserUpdateRequest userUpdateRequest = JsonUtil.fromJSON(apiRequest.getParamJson(), UserUpdateRequest.class);
        //判断json格式参数是否有误
        if (userUpdateRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }

        String errorMsg = ValidatorUtil.getError(userUpdateRequest);
        //如果校验错误 则返回
        if (StringUtil.isNotEmpty(errorMsg)) {
            setInvalidParameterResponse(apiResponse, errorMsg);
            return apiResponse;
        }

        EndUser endUser = new EndUser();
        BeanUtil.copyProperties(userUpdateRequest,endUser);
        try {
            CommonResponse commonResponse = userService.updateEndUser(endUser);
            //如果处理失败 则返回错误信息
            if (!isServiceCallSuccess(commonResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, commonResponse);
            }
        } catch (Exception e) {
            logger.error("修改用户发生错误---" + e);
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;

    }

    /**
     *
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/user/is-mobile-existed", method = RequestMethod.GET)
    public ApiResponse isExistedUserByMobile(ApiRequest apiRequest) {
        ApiResponse apiResponse = new ApiResponse();
        UserCheckRequest userCheckRequest = JsonUtil.fromJSON(apiRequest.getParamJson(), UserCheckRequest.class);
        //判断json格式参数是否有误
        if (userCheckRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }

        String errorMsg = null;
        if(userCheckRequest.getMobile()==null) {
            errorMsg = "手机号不能为空";
        }
        //如果校验错误 则返回
        if (StringUtil.isNotEmpty(errorMsg)) {
            setInvalidParameterResponse(apiResponse, errorMsg);
            return apiResponse;
        }

        logger.info("检查是否存在指定手机号的用户:" + userCheckRequest.getMobile());

        try {
            UserCheckResponse userCheckResponse = userService.isExistedUserByMobile(userCheckRequest.getMobile());
            //如果处理失败 则返回错误信息
            if (!isServiceCallSuccess(userCheckResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, userCheckResponse);
            } else {
                apiResponse.setData(userCheckResponse.isExistedUser());
            }
        } catch (Exception e) {
            logger.error("根据手机号判断用户是否存在发生错误---" + e);
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }

    @RequestMapping(value = "/v1/user/is-nickname-existed", method = RequestMethod.GET)
    public ApiResponse isExistedUserByNickName(ApiRequest apiRequest) {
        ApiResponse apiResponse = new ApiResponse();
        UserCheckRequest userCheckRequest = JsonUtil.fromJSON(apiRequest.getParamJson(), UserCheckRequest.class);
        //判断json格式参数是否有误
        if (userCheckRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }

        String errorMsg = null;
        if(StringUtil.isEmpty(userCheckRequest.getNickName())) {
            errorMsg = "昵称不能为空";
        }

        //如果校验错误 则返回
        if (StringUtil.isNotEmpty(errorMsg)) {
            setInvalidParameterResponse(apiResponse, errorMsg);
            return apiResponse;
        }

        try {
            UserCheckResponse userCheckResponse = userService.isExistedUserByNickName(userCheckRequest.getNickName());
            //如果处理失败 则返回错误信息
            if (!isServiceCallSuccess(userCheckResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, userCheckResponse);
            } else {
                apiResponse.setData(userCheckResponse.isExistedUser());
            }
        } catch (Exception e) {
            logger.error("根据昵称判断用户是否存在发生错误---" + e);
            setInternalErrorResponse(apiResponse);
        }

        return apiResponse;
    }

    @RequestMapping(value = "/v1/user/captcha", method = RequestMethod.POST)
    public ApiResponse requestCaptcha(ApiRequest apiRequest) {

        ApiResponse apiResponse = new ApiResponse();
        CaptchaRequest captchaRequest = JsonUtil.fromJSON(apiRequest.getParamJson(), CaptchaRequest.class);
        //判断json格式参数是否有误
        if (captchaRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }

        String errorMsg = ValidatorUtil.getError(captchaRequest);
        //如果校验错误 则返回
        if (StringUtil.isNotEmpty(errorMsg)) {
            setInvalidParameterResponse(apiResponse, errorMsg);
            return apiResponse;
        }

        try {
            CommonResponse commonResponse = captchaService.sendCaptcha(
                    captchaRequest.getMobile(), CaptchaTemplate.TEMPLATE_REGISTER, registerCaptchaTimeout);
            //如果处理失败 则返回错误信息
            if (!isServiceCallSuccess(commonResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, commonResponse);
            }
        } catch (Exception e) {
            logger.error("发送验证码发生错误---" + e);
            setInternalErrorResponse(apiResponse);
        }

        return apiResponse;
    }

    /**
     * 检查是否绑定微信
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/user/wechat-bind-status", method = RequestMethod.GET)
    public ApiResponse checkWechatBindStatus(ApiRequest apiRequest) {
        ApiResponse apiResponse = new ApiResponse();
        WechatBindQueryRequest wechatBindQueryRequest = JsonUtil.fromJSON(apiRequest.getParamJson(), WechatBindQueryRequest.class);
        //判断json格式参数是否有误
        if (wechatBindQueryRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }

        String errorMsg = ValidatorUtil.getError(wechatBindQueryRequest);
        //如果校验错误 则返回
        if (StringUtil.isNotEmpty(errorMsg)) {
            setInvalidParameterResponse(apiResponse, errorMsg);
            return apiResponse;
        }

        try {
            WechatBindStatusResponse wechatBindStatusResponse = userService.checkWechatBindStatus(wechatBindQueryRequest.getMobile());
            //如果处理失败 则返回错误信息
            if (!isServiceCallSuccess(wechatBindStatusResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, wechatBindStatusResponse);
            } else {
                apiResponse.setData(wechatBindStatusResponse.getWechatBindStatusVo());
            }
        } catch (Exception e) {
            logger.error("发送验证码发生错误---" + e);
            setInternalErrorResponse(apiResponse);
        }

        return apiResponse;
    }

    /**
     * 绑定微信
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/user/wechat-bind", method = RequestMethod.POST)
    public ApiResponse bindWechat(ApiRequest apiRequest) {

        ApiResponse apiResponse = new ApiResponse();
        WechatBindRequest wechatBindRequest = JsonUtil.fromJSON(apiRequest.getParamJson(), WechatBindRequest.class);
        //判断json格式参数是否有误
        if (wechatBindRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }

        String errorMsg = ValidatorUtil.getError(wechatBindRequest);
        //如果校验错误 则返回
        if (StringUtil.isNotEmpty(errorMsg)) {
            setInvalidParameterResponse(apiResponse, errorMsg);
            return apiResponse;
        }

        EndUserWechat endUserWechat = new EndUserWechat();
        BeanUtil.copyProperties(wechatBindRequest,endUserWechat);
        try {
            WechatBindStatusResponse wechatBindStatusResponse = userService.bindWechatToUser(endUserWechat);
            //如果处理失败 则返回错误信息
            if (!isServiceCallSuccess(wechatBindStatusResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, wechatBindStatusResponse);
            } else {
                apiResponse.setData(wechatBindStatusResponse);
            }
        } catch (Exception e) {
            logger.error("绑定微信发生错误---" + e);
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }


    /**
     * 微信是否已绑定用户
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/user/is-wechat-bind-user", method = RequestMethod.POST)
    public ApiResponse checkIfWechatBindToUser(ApiRequest apiRequest) {

        ApiResponse apiResponse = new ApiResponse();
        WechatBindQueryRequest wechatBindQueryRequest = JsonUtil.fromJSON(apiRequest.getParamJson(), WechatBindQueryRequest.class);
        //判断json格式参数是否有误
        if (wechatBindQueryRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }

//        String errorMsg = ValidatorUtil.getError(wechatBindQueryRequest);
        String errorMsg  = null;
        String openId = wechatBindQueryRequest.getOpenId();
        if (StringUtil.isEmpty(openId)) {
            errorMsg = "请传入openId";
        }
        //如果校验错误 则返回
        if (StringUtil.isNotEmpty(errorMsg)) {
            setInvalidParameterResponse(apiResponse, errorMsg);
            return apiResponse;
        }
        try {
            WechatBindStatusResponse wechatBindStatusResponse = userService.checkIfWechatIdBindToUserId(openId);
            //如果处理失败 则返回错误信息
            if (!isServiceCallSuccess(wechatBindStatusResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, wechatBindStatusResponse);
            } else {
                apiResponse.setData(wechatBindStatusResponse);
            }
        } catch (Exception e) {
            logger.error("检查微信是否已绑定用户发生错误---" + e);
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }

    /**
     * 修改用户信息
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/user/reset-password", method = RequestMethod.POST)
    public ApiResponse resetPassword(ApiRequest apiRequest) {
        ApiResponse apiResponse = new ApiResponse();
        logger.info("paramJson=" + apiRequest.getParamJson());
        ResetPwdRequest resetPwdRequest = JsonUtil.fromJSON(apiRequest.getParamJson(), ResetPwdRequest.class);
        //判断json格式参数是否有误
        if (resetPwdRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }

        String errorMsg = ValidatorUtil.getError(resetPwdRequest);
        //如果校验错误 则返回
        if (StringUtil.isNotEmpty(errorMsg)) {
            setInvalidParameterResponse(apiResponse, errorMsg);
            return apiResponse;
        }

        try {
            CommonResponse commonResponse = userService.resetPassword(
                    resetPwdRequest.getMobile(),resetPwdRequest.getCaptcha(),resetPwdRequest.getNewPwd());
            //如果处理失败 则返回错误信息
            if (!isServiceCallSuccess(commonResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, commonResponse);
            }
        } catch (Exception e) {
            logger.error("重置密码发生错误---" + e);
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;

    }
}