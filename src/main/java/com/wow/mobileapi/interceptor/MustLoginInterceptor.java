package com.wow.mobileapi.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        //验证用户是否登陆 - 从cookie或者请求体中获取token,通过redis或mysql检查该token是否有效
        String token = "";
        boolean isValidToken = false;
//        Object obj = request.getSession().getAttribute("cur_user");
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("session")) {
                token = cookie.getValue();
                break;
            }
        }
        if ("".equals(token)) {
            //从请求体中获取
            token = request.getParameter("token");
        }
        //check whether token is valid, by search it from redis or mysql
        if (! isValidToken) {
            logger.info("you must login to continue...");
            response.getWriter().write("You need to login to continue");
            return false;
        } else {
            //判断用户过期时间,如果快要过期了,延长过期时间
            loginService.refreshSession(token);
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