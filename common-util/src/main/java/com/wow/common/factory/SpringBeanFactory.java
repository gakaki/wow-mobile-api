package com.wow.common.factory;

import com.wow.common.util.CountryUtil;
import com.wow.common.util.MaterialDataUtil;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.wow.common.util.DictionaryUtil;
import com.wow.common.util.ErrorCodeUtil;

/**
 * spring bean factory 提供根据bean id获取spring容器中的bean
 * 
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月12日 下午2:37:46 Exp $
 */
@Component
public class SpringBeanFactory implements ApplicationContextAware {

    private static ApplicationContext context;

    public SpringBeanFactory() {
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        SpringBeanFactory.context = context;
        //初始化开始...
        
        //加载错误码属性文件
        ErrorCodeUtil.loadProps();
        
        //初始化数据字典
        DictionaryUtil.init();

        MaterialDataUtil.init();

        CountryUtil.init();
        //初始化结束...
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name, Class<T> clazz) {
        return (T) getBean(name);
    }

    public static Object getBean(String name) {
        return context.getBean(name);
    }
}
