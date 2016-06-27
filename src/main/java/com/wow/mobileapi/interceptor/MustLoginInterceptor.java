package com.wow.mobileapi.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wow.mobileapi.constant.ApiConstant;
import com.wow.user.model.EndUser;
import com.wow.user.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.ActuatorMetricWriter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 拦截未登录的用户
 */
public class MustLoginInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(MustLoginInterceptor.class);

    @Autowired
    private LoginService loginService;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        logger.info("must login interceptor:preHandle:" + request);
        //验证用户是否登陆 - 从Header中获取token,通过redis或mysql检查该token是否有效
        String token = request.getHeader(ApiConstant.TOKEN_HEADER_NAME);
        logger.info("user token in header is:" + token);
//        boolean isValidToken = "2ee12f01-be6b-4eb8-b1cb-cefd9ce176bb".endsWith(token);
        boolean isValidToken = true;
//        Object obj = request.getSession().getAttribute("cur_user");
//        Cookie[] cookies = request.getCookies();
//        for (Cookie cookie : cookies) {
//            if (cookie.getName().equals("session")) {
//                token = cookie.getValue();
//                break;
//            }
//        }
//        if ("".equals(token)) {
//            //从请求体中获取
//            token = request.getParameter("token");
//        }
        //check whether token is valid, by search it from redis or mysql
        if (! isValidToken) {
            logger.info("token is invalid, please login");
            response.getWriter().write("您的会话已过期,请重新登录");
            return false;
        } else {
            //判断用户过期时间,如果快要过期了,延长过期时间
//            loginService.refreshSession(token);
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