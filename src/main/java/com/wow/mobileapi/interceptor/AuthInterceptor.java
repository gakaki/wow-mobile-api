package com.wow.mobileapi.interceptor;

import com.wow.common.response.ApiResponse;
import com.wow.common.util.ErrorResponseUtil;
import com.wow.common.util.JsonUtil;
import com.wow.common.util.StringUtil;
import com.wow.mobileapi.constant.ApiConstant;
import com.wow.mobileapi.constant.ErrorCodeConstant;
import com.wow.user.service.SessionService;
import com.wow.user.vo.response.TokenValidateResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截未登录的用户
 */
@Configuration
public class AuthInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);
    @Autowired
    private SessionService sessionService;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        logger.info("AuthInterceptor preHandle:" + request);
        
        ApiResponse apiResponse = new ApiResponse();

        // 从请求体中获取token
        String token = request.getParameter(ApiConstant.REQUEST_PARAMETER_TOKEN);
        String channel = request.getParameter(ApiConstant.REQUEST_PARAMETER_CHANNEL);

        if (StringUtil.isEmpty(token) || StringUtil.isEmpty(channel)) {
            apiResponse.setResCode(ErrorCodeConstant.INVALID_PARAMETER);
            apiResponse.setResMsg("请传入sessionToken和channel");
            response.setContentType("application/json");
            response.getWriter().write(JsonUtil.pojo2Json(apiResponse));
            return false;
        }

        byte loginChannel = Byte.valueOf(channel);

        try {
            //check whether token is valid, by search it from redis or mysql
            TokenValidateResponse tokenValidateResponse = sessionService.isValidSessionToken(token,loginChannel);
            if (tokenValidateResponse==null || !tokenValidateResponse.isValid()) {
                logger.warn("session token is invalid:" + token);
                ErrorResponseUtil.setErrorResponse(apiResponse,ErrorCodeConstant.INVALID_TOKEN);
                response.setContentType("application/json");
                response.getWriter().write(JsonUtil.pojo2Json(apiResponse));
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询Token发生错误---" + e);
            ErrorResponseUtil.setErrorResponse(apiResponse,ErrorCodeConstant.INTERNAL_ERROR);
            response.setContentType("application/json");
            response.getWriter().write(JsonUtil.pojo2Json(apiResponse));
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }

}