package com.wow.mobileapi.config;

import com.wow.mobileapi.interceptor.AuthInterceptor;
import com.wow.mobileapi.interceptor.LogInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by zhengzhiqing on 16/7/2.
 */
@EnableWebMvc
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    AuthInterceptor authInterceptor;

    @Autowired
    LogInterceptor logInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logInterceptor).addPathPatterns("/**");
        registry.addInterceptor(authInterceptor).addPathPatterns("/v1/order/**");
        registry.addInterceptor(authInterceptor).addPathPatterns("/v1/user/shippinginfo/**"); //收货信息
        registry.addInterceptor(authInterceptor).addPathPatterns("/v1/cart/**");
    }

}