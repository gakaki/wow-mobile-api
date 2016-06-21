package com.wow.mobileapi.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wow.user.model.EndUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 拦截未登录的用户信息
 *
 * @author lance
 *         2014-6-10下午9:57:20
 */
public class MustLoginInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(MustLoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        logger.info("must login interceptor:preHandle:" + request);
        //验证用户是否登陆
        Object obj = request.getSession().getAttribute("cur_user");
        if (obj == null || !(obj instanceof EndUser)) {
            logger.info("you must login to continue...");
//            response.sendRedirect(request.getContextPath() + "/login");
            response.getWriter().write("You need to login to continue");
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