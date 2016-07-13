package com.wow.common.util;

import org.springframework.beans.BeanUtils;

/**
 * bean 属性拷贝工具包
 * 
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月13日 下午7:43:37 Exp $
 */
public class BeanUtil {

    /**
     * 属性拷贝
     * 
     * @param source  源对象
     * @param target  目标对象
     */
    public static void copyProperties(Object source, Object target) {
        BeanUtils.copyProperties(source, target);
    }

    /**
     * 属性拷贝 可以选择排除属性
     * 
     * @param source  源对象
     * @param target   目标对象
     * @param ignoreProperties 忽略的属性
     */
    public static void copyProperties(Object source, Object target, String... ignoreProperties) {
        BeanUtils.copyProperties(source, target, ignoreProperties);
    }

}
