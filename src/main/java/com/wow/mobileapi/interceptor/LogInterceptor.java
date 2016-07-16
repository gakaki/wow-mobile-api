package com.wow.mobileapi.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

/**
 * log request/response
 */
@Configuration
public class LogInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LogInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        logger.info(">>>>>>>>>>> http request info <<<<<<<<<<<<<<<");
        StringBuffer sb = new StringBuffer();
        sb.append("\n");
        sb.append(request.getMethod());
        sb.append(" ");
        sb.append(request.getRequestURL().toString());
        sb.append(" ");
        sb.append(request.getProtocol());
        sb.append("\n\n");

        Enumeration e = request.getHeaderNames();
        while (e.hasMoreElements()) {
            //取出信息名
            String name = (String) e.nextElement();
            //取出信息值
            String value = request.getHeader(name);
            sb.append(name + ": " + value + "\n");
        }
        sb.append("\n");

        Map paramMap = getParameterMap(request);
        printMap(paramMap, sb);
        String s = sb.toString();
        if (s.endsWith("&")) {
            s = s.substring(0, s.length() - 1);
        }
        sb = new StringBuffer(s);
        sb.append("\n");
        //Do not read the request body in interceptor or filter
//        String body = charReader(request);
//        sb.append("\n" + body + "\n");

        logger.info(sb.toString());

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        logger.info(">>>>>>>>>>> postHandle <<<<<<<<<<<<<<<");
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        logger.info(">>>>>>>>>>> afterCompletion <<<<<<<<<<<<<<<");
    }


    /**
     * 从request中获得参数Map，并返回可读的Map
     *
     * @param request
     * @return
     */
    @SuppressWarnings("unchecked")
    private Map getParameterMap(HttpServletRequest request) {
        // 参数Map
        Map properties = request.getParameterMap();
        // 返回值Map
        Map returnMap = new HashMap();
        Iterator entries = properties.entrySet().iterator();
        Map.Entry entry;
        String name = "";
        String value = "";
        while (entries.hasNext()) {
            entry = (Map.Entry) entries.next();
            name = (String) entry.getKey();
            Object valueObj = entry.getValue();
            if(null == valueObj){
                value = "";
            }else if(valueObj instanceof String[]){
                String[] values = (String[])valueObj;
                for(int i=0;i<values.length;i++){
                    value = values[i] + ",";
                }
                value = value.substring(0, value.length()-1);
            }else{
                value = valueObj.toString();
            }
            returnMap.put(name, value);
        }
        return returnMap;
    }

    public void printMap(Map<String, String> map, StringBuffer sb) {
        Set<String> keys = map.keySet();
        for (Iterator it = keys.iterator(); it.hasNext();) {
            String key = (String) it.next();
            String value = map.get(key);
            sb.append(key+"="+value+"&");
        }
    }

    public String charReader(HttpServletRequest request) throws IOException {
        BufferedReader br = request.getReader();
        String str, wholeStr = "";
        while((str = br.readLine()) != null){
            wholeStr += str;
        }
        return wholeStr;
    }

}