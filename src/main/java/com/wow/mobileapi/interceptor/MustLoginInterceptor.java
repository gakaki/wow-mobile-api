package com.wow.mobileapi.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wow.mobileapi.constant.ApiConstant;
import com.wow.user.service.SessionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 拦截未登录的用户
 */
public class MustLoginInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(MustLoginInterceptor.class);

    @Autowired
    private SessionService sessionService;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        logger.info("must login interceptor:preHandle:" + request);
        String token = getSessionToken(request, response);
        byte loginChannel = getLoginChannel(request, response);

        //check whether token is valid, by search it from redis or mysql
        if (! sessionService.isValidSessionToken(token,loginChannel)) {
            logger.info("token is invalid, please login");
            response.getWriter().write("您的会话已过期,请重新登录");
            return false;
        }
        return true;
    }

    /**
     * 获取传入的会话Token - 可从header, cookie或者request中获取
     * @param request
     * @param response
     * @return
     */
    private String getSessionToken(HttpServletRequest request, HttpServletResponse response) {
        //验证用户是否登陆 - 从Header中获取token,通过redis或mysql检查该token是否有效
        String token = request.getHeader(ApiConstant.TOKEN_HEADER_NAME);
        //get from request
//        if ("".equals(token) || token == null) {
//            //从请求体中获取
//            token = request.getParameter("token");
//        }
        //get from cookie
//        Object obj = request.getSession().getAttribute("cur_user");
//        Cookie[] cookies = request.getCookies();
//        for (Cookie cookie : cookies) {
//            if (cookie.getName().equals("session")) {
//                token = cookie.getValue();
//                break;
//            }
//        }
        if (token==null) {
            token = "";
        }
        logger.info("user token in header is:" + token);
        return token;
    }

    /**
     * 获取传入的会话Token - 可从header, cookie或者request中获取
     * @param request
     * @param response
     * @return
     */
    private byte getLoginChannel(HttpServletRequest request, HttpServletResponse response) {
        //验证用户是否登陆 - 从Header中获取token,通过redis或mysql检查该token是否有效
        byte loginChannel = 1 ; //代表PC
        String userAgent = request.getHeader("User-Agent");
        if (userAgent.contains("iOS")) {
            loginChannel = 2; //iOS
        } else if (userAgent.contains("Android")) {
            loginChannel = 3; //Android
        }
        logger.info("loginChannel=" + loginChannel);
        return loginChannel;
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