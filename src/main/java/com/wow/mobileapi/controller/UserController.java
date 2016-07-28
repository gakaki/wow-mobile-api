package com.wow.mobileapi.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wow.common.request.ApiRequest;
import com.wow.common.response.ApiResponse;
import com.wow.common.response.CommonResponse;
import com.wow.common.util.BeanUtil;
import com.wow.common.util.EncodeDecodeUtil;
import com.wow.common.util.ErrorCodeUtil;
import com.wow.common.util.ErrorResponseUtil;
import com.wow.common.util.JsonUtil;
import com.wow.common.util.StringUtil;
import com.wow.common.util.ValidatorUtil;
import com.wow.mobileapi.constant.ErrorCodeConstant;
import com.wow.mobileapi.request.user.CaptchaRequest;
import com.wow.mobileapi.request.user.RegisterAndBindWechatRequest;
import com.wow.mobileapi.request.user.RegisterRequest;
import com.wow.mobileapi.request.user.ResetPwdRequest;
import com.wow.mobileapi.request.user.UserCheckRequest;
import com.wow.mobileapi.request.user.UserUpdateRequest;
import com.wow.mobileapi.response.user.BindWechatResponse;
import com.wow.mobileapi.util.HttpRequestUtil;
import com.wow.user.constant.SmsTemplate;
import com.wow.user.model.EndUser;
import com.wow.user.model.EndUserWechat;
import com.wow.user.service.CaptchaService;
import com.wow.user.service.SessionService;
import com.wow.user.service.UserService;
import com.wow.user.vo.LoginResponseVo;
import com.wow.user.vo.LoginVo;
import com.wow.user.vo.response.LoginResponse;
import com.wow.user.vo.response.RegisterBindStatusResponse;
import com.wow.user.vo.response.RegisterResponse;
import com.wow.user.vo.response.UserCheckResponse;
import com.wow.user.vo.response.UserResponse;

@RestController
public class UserController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private SessionService sessionService;

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
    public ApiResponse getUserInfo(ApiRequest apiRequest) {
        ApiResponse apiResponse = new ApiResponse();
        String errorMsg = checkTokenChannel(apiRequest);
        //如果校验错误 则返回
        if (StringUtil.isNotEmpty(errorMsg)) {
            setInvalidParameterResponse(apiResponse, errorMsg);
            return apiResponse;
        }
        Integer endUserId = getUserIdByTokenChannel(apiRequest);
        if (endUserId == null) {
            ErrorResponseUtil.setErrorResponse(apiResponse, ErrorCodeConstant.INVALID_TOKEN);
            return apiResponse;
        }

        try {
            UserResponse userResponse = userService.getUserById(endUserId);
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(userResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, userResponse);
            } else {
                apiResponse.setData(userResponse.getEndUser());
            }
        } catch (Exception e) {
            logger.error("查找用户信息错误---" + e);
            e.printStackTrace();
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }

    /**
     *
     * @param mobile
     * @return
     */
    private String getCaptchaOnServer(String mobile) {
        String captchaOnServer = "111111"; //TODO, hard code for test only
//        //get from redis
//        Object captcha = RedisUtil.get(mobile);
//        if (captcha != null) {
//            captchaOnServer = (String) captcha;
//        }
        return captchaOnServer;
    }

    /**
     * 用户注册,并自动登录
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/user/register", method = RequestMethod.POST)
    public ApiResponse registerAndLogin(ApiRequest apiRequest, HttpServletRequest request) {

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

        String mobile = registerRequest.getMobile();
        String captcha = registerRequest.getCaptcha();
        EndUser endUser = new EndUser();
        BeanUtil.copyProperties(registerRequest,endUser);

        //判断验证码是否与服务端一致,且服务端验证码未过期
        String captchaOnServer = getCaptchaOnServer(mobile);
        if (StringUtil.isEmpty(captchaOnServer)) {
            ErrorResponseUtil.setErrorResponse(apiResponse,"40102");
        } else if (!captcha.equals(captchaOnServer)) {
            ErrorResponseUtil.setErrorResponse(apiResponse, "40103");
        }

        try {
            UserCheckResponse userCheckResponse = userService.isExistedUserByMobile(mobile);
            if (userCheckResponse.isExistedUser()) {
                ErrorResponseUtil.setErrorResponse(apiResponse,"50111");
                return apiResponse;
            }

            CommonResponse commonResponse = userService.register(endUser);
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(commonResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, commonResponse);
                return apiResponse;
            } else {
                //做一次自动登录
                LoginVo loginVo = new LoginVo();
                BeanUtil.copyProperties(registerRequest, loginVo);
                loginVo.setLoginIp(HttpRequestUtil.getIpAddr(request));
                loginVo.setUserAgent(HttpRequestUtil.getUserAgent(request));
                loginVo.setLoginChannel(apiRequest.getChannel());

                try {
                    LoginResponse loginResponse = sessionService.login(loginVo);
                    //如果处理失败 则返回错误信息
                    if (ErrorCodeUtil.isFailedResponse(loginResponse.getResCode())) {
                        setServiceErrorResponse(apiResponse, loginResponse);
                    } else {
                        apiResponse.setData(loginResponse.getLoginResponseVo());
                    }
                } catch (Exception e) {
                    logger.error("login发生错误---" + e);
                    e.printStackTrace();
                    setInternalErrorResponse(apiResponse);
                }
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
        if (StringUtil.isEmpty(errorMsg)) {
            errorMsg = checkTokenChannel(apiRequest);
        }
        //如果校验错误 则返回
        if (StringUtil.isNotEmpty(errorMsg)) {
            setInvalidParameterResponse(apiResponse, errorMsg);
            return apiResponse;
        }

        EndUser endUser = new EndUser();
        BeanUtil.copyProperties(userUpdateRequest,endUser);

        Integer endUserId = getUserIdByTokenChannel(apiRequest);
        if (endUserId != null) {
            endUser.setId(endUserId);
        } else {
            ErrorResponseUtil.setErrorResponse(apiResponse,ErrorCodeConstant.INVALID_TOKEN);
            return apiResponse;
        }

        if(StringUtil.isNotEmpty(endUser.getNickName())) {
            String encodedNickName = EncodeDecodeUtil.encodeStr(endUser.getNickName());
            endUser.setNickName(encodedNickName);
        }

        try {
            CommonResponse commonResponse = userService.updateUser(endUser);
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(commonResponse.getResCode())) {
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
            if (ErrorCodeUtil.isFailedResponse(userCheckResponse.getResCode())) {
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
            if (ErrorCodeUtil.isFailedResponse(userCheckResponse.getResCode())) {
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

    /**
     * 重置密码获取验证码
     * 如果手机号已注册,直接返回,不发验证码
     * 如果手机号未注册,发验证码
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/user/captcha/pwd-reset", method = RequestMethod.POST)
    public ApiResponse requestResetPwdCaptcha(ApiRequest apiRequest) {

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

        String mobile = captchaRequest.getMobile();

        try {
            //如果手机号未注册,报错返回
            UserCheckResponse userCheckResponse = userService.isExistedUserByMobile(mobile);
            if (!userCheckResponse.isExistedUser()) {
                ErrorResponseUtil.setErrorResponse(apiResponse,"40105");
                return apiResponse;
            }

            CommonResponse commonResponse = captchaService.sendCaptcha(
                    captchaRequest.getMobile(), SmsTemplate.TEMPLATE_RESETPWD, registerCaptchaTimeout);
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(commonResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, commonResponse);
            }
        } catch (Exception e) {
            logger.error("发送验证码发生错误---" + e);
            setInternalErrorResponse(apiResponse);
        }

        return apiResponse;
    }

    /**
     * 手机注册页面获取验证码
     * 如果手机号已注册,直接返回,不发验证码
     * 如果手机号未注册,发验证码
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/user/captcha/register", method = RequestMethod.POST)
    public ApiResponse requestRegisterCaptcha(ApiRequest apiRequest) {

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

        String mobile = captchaRequest.getMobile();

        try {

            UserCheckResponse userCheckResponse = userService.isExistedUserByMobile(mobile);
            if (userCheckResponse.isExistedUser()) {//如果是已注册用户,直接返回,不发送验证码
                ErrorResponseUtil.setErrorResponse(apiResponse,"50111");
                return apiResponse;
            }

            CommonResponse commonResponse = captchaService.sendCaptcha(
                    captchaRequest.getMobile(), SmsTemplate.TEMPLATE_REGISTER, registerCaptchaTimeout);
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(commonResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, commonResponse);
            }
        } catch (Exception e) {
            logger.error("发送验证码发生错误---" + e);
            setInternalErrorResponse(apiResponse);
        }

        return apiResponse;
    }

    /**
     * 绑定微信页面获取验证码
     * 检查手机号是否已注册,是否已绑定微信。
     * 如果已注册且已绑定,则不发送验证码,提示此手机号已被注册
     * 如果未注册或者已注册但未绑定账号,则发送验证码
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/user/captcha/wechat-bind", method = RequestMethod.POST)
    public ApiResponse requestCaptchaBindWechat(ApiRequest apiRequest) {

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

        String mobile = captchaRequest.getMobile();

        try {
            RegisterBindStatusResponse registerBindStatusResponse = userService.getRegisterBindStatus(mobile);
            //如果已注册且已绑定,则不发送验证码,直接返回:此手机号已被注册
            if (registerBindStatusResponse.isRegistered() && registerBindStatusResponse.isBinded()) {
                ErrorResponseUtil.setErrorResponse(apiResponse,"50111");
                return apiResponse;
            }
            //如果未注册或者已注册但未绑定账号,则发送验证码
            CommonResponse commonResponse = captchaService.sendCaptcha(
                    captchaRequest.getMobile(), SmsTemplate.TEMPLATE_REGISTER, registerCaptchaTimeout);
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(commonResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, commonResponse);
            }
        } catch (Exception e) {
            logger.error("发送验证码发生错误---" + e);
            setInternalErrorResponse(apiResponse);
        }

        return apiResponse;
    }

    /**
     * 绑定微信
     * 1. 先判断手机号是否已注册,如果未注册,先注册
     * 2. 然后绑定微信
     * 3. 然后自动登录
     *
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/user/wechat-bind", method = RequestMethod.POST)
    public ApiResponse bindWechat(ApiRequest apiRequest, HttpServletRequest request) {

        ApiResponse apiResponse = new ApiResponse();

        RegisterAndBindWechatRequest registerAndBindWechatRequest = JsonUtil.fromJSON(apiRequest.getParamJson(), RegisterAndBindWechatRequest.class);
        //判断json格式参数是否有误
        if (registerAndBindWechatRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }

        String errorMsg = ValidatorUtil.getError(registerAndBindWechatRequest);
        //如果校验错误 则返回
        if (StringUtil.isNotEmpty(errorMsg)) {
            setInvalidParameterResponse(apiResponse, errorMsg);
            return apiResponse;
        }

        String mobile = registerAndBindWechatRequest.getMobile();
        String password = registerAndBindWechatRequest.getPassword();
        String captcha = registerAndBindWechatRequest.getCaptcha();
        boolean isNewUser = false;

        String captchaOnServer = getCaptchaOnServer(mobile);
        if (StringUtil.isEmpty(captchaOnServer)) {
            ErrorResponseUtil.setErrorResponse(apiResponse,"40102");
            return apiResponse;
        } else if (!captcha.equals(captchaOnServer)) {
            ErrorResponseUtil.setErrorResponse(apiResponse,"40103");
            return apiResponse;
        }

        EndUser endUser = new EndUser();
        endUser.setMobile(mobile);
        endUser.setPassword(password);

        EndUserWechat endUserWechat = new EndUserWechat();
        BeanUtil.copyProperties(registerAndBindWechatRequest.getUserInfoFromWechat(),endUserWechat);

        //判断手机号是否已注册/已绑定微信
        RegisterBindStatusResponse registerBindStatusResponse = userService.getRegisterBindStatus(mobile);
        boolean isRegistered = registerBindStatusResponse.isRegistered();
        boolean isBinded = registerBindStatusResponse.isBinded();

        //如果已经绑定,返回错误:该手机已经绑定微信
        if (isBinded) {
            ErrorResponseUtil.setErrorResponse(apiResponse,"50107");
            return apiResponse;
        }

        int endUserId;

        //未注册的情况下,先注册
        if(!isRegistered) {
            isNewUser = true;
            try {
                RegisterResponse registerResponse = userService.register(endUser);
                if (registerResponse == null || !"0".equals(registerResponse.getResCode())) {
                    ErrorResponseUtil.setErrorResponse(apiResponse,registerResponse.getResCode());
                    return apiResponse;
                }
                endUserId = registerResponse.getEndUserId();
            } catch (Exception e) {
                logger.error("注册和绑定微信发生错误---" + e);
                setInternalErrorResponse(apiResponse);
                return apiResponse;
            }
        } else {
            //已注册的情况下获得end_user_id
            endUserId = userService.getUserByMobile(mobile).getEndUser().getId();
        }

        //注册之后绑定微信(要先检查该微信是否已绑定已有用户)
        endUserWechat.setMobile(endUser.getMobile());
        endUserWechat.setEndUserId(endUserId);
        String encodedNickName = EncodeDecodeUtil.encodeStr(endUserWechat.getWechatNickName());
        endUserWechat.setWechatNickName(encodedNickName);
        //已有用户绑定微信
        try {
            CommonResponse commonResponse = userService.bindWechat(endUserWechat);
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(commonResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, commonResponse);
                return apiResponse;
            }
        } catch (Exception e) {
            logger.error("绑定微信发生错误---" + e);
            setInternalErrorResponse(apiResponse);
            return apiResponse;
        }

        //判断用户是否有昵称和头像,如果没有,用微信的覆盖
        try {
            UserResponse userResponse = userService.getUserById(endUserId);
            if (userResponse != null && userResponse.getEndUser() != null) {
                String nickName = userResponse.getEndUser().getNickName();
                String avatar = userResponse.getEndUser().getAvatar();

                EndUser endUserToBeUpdate = new EndUser();
                endUserToBeUpdate.setId(endUserId);
                if (StringUtil.isEmpty(nickName)) {
                    endUserToBeUpdate.setNickName(encodedNickName);
                }
                if (StringUtil.isEmpty(avatar)) {
                    endUserToBeUpdate.setAvatar(endUserWechat.getWechatAvatar());
                }
                if (StringUtil.isNotEmpty(endUserToBeUpdate.getAvatar()) || StringUtil.isNotEmpty(endUserToBeUpdate.getNickName())) {
                    userService.updateUser(endUserToBeUpdate);
                }
            }
        } catch (Exception ignore) {
            logger.error("覆写昵称和头像错误--" + ignore);
        }

        //进行一次自动登录
        LoginVo loginVo = new LoginVo();
        BeanUtil.copyProperties(registerAndBindWechatRequest, loginVo);
        loginVo.setLoginIp(HttpRequestUtil.getIpAddr(request));
        loginVo.setUserAgent(HttpRequestUtil.getUserAgent(request));
        loginVo.setLoginChannel(apiRequest.getChannel());

        try {
            LoginResponse loginResponse = sessionService.login(loginVo);
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(loginResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, loginResponse);
                return apiResponse;
            } else {
                LoginResponseVo loginResponseVo = loginResponse.getLoginResponseVo();

                BindWechatResponse bindWechatResponse = new BindWechatResponse();
                bindWechatResponse.setNewUser(isNewUser);
                bindWechatResponse.setSessionToken(loginResponseVo.getSessionToken());
                bindWechatResponse.setNickName(EncodeDecodeUtil.decodeStr(loginResponseVo.getNickName()));

                apiResponse.setData(bindWechatResponse);
            }
        } catch (Exception e) {
            logger.error("login发生错误---" + e);
            e.printStackTrace();
            setInternalErrorResponse(apiResponse);
            return apiResponse;
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

        String mobile = resetPwdRequest.getMobile();
        String captcha = resetPwdRequest.getCaptcha();

        String captchaOnServer = getCaptchaOnServer(mobile);
        if (StringUtil.isEmpty(captchaOnServer)) {
            ErrorResponseUtil.setErrorResponse(apiResponse,"40102");
            return apiResponse;
        } else if (!captcha.equals(captchaOnServer)) {
            ErrorResponseUtil.setErrorResponse(apiResponse,"40103");
            return apiResponse;
        }

        try {
            CommonResponse commonResponse = userService.resetPassword(
                    resetPwdRequest.getMobile(),resetPwdRequest.getNewPwd());
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(commonResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, commonResponse);
            }
        } catch (Exception e) {
            logger.error("重置密码发生错误---" + e);
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }
}