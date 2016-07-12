package com.wow.common.util;

import java.util.Collection;

/**
 * 集合操作工具类
 * 
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月12日 下午2:48:33 Exp $
 */
public class CollectionUtil {

    /**
     * 判断集合是否非空
     */
    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    /**
     * 判断集合是否为空
     */
    public static boolean isEmpty(Collection<?> collection) {
        return (collection == null || collection.isEmpty());
    }
}
