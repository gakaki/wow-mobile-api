package com.wow.common.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.wow.common.util.CountryUtil;
import com.wow.common.util.DictionaryUtil;
import com.wow.common.util.ErrorCodeUtil;
import com.wow.common.util.MaterialDataUtil;

/**
 * spring bean factory 提供根据bean id获取spring容器中的bean
 * 
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月12日 下午2:37:46 Exp $
 */
@Component
public class SpringBeanFactory implements ApplicationContextAware {

    private static final Logger logger = LoggerFactory.getLogger(SpringBeanFactory.class);

    private static ApplicationContext context;

    public SpringBeanFactory() {
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        SpringBeanFactory.context = context;
        //初始化开始...
        long start = System.currentTimeMillis();

        //加载错误码属性文件
        ErrorCodeUtil.loadProps();

        //初始化数据字典
        DictionaryUtil.init();

        MaterialDataUtil.init();
        CountryUtil.init();
        long end = System.currentTimeMillis();
        //初始化结束...
        logger.info("初始化耗时 "+(end-start)+"ms");
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name, Class<T> clazz) {
        return (T) getBean(name);
    }

    public static Object getBean(String name) {
        return context.getBean(name);
    }
}
