package com.wow.common.util;

import java.util.Map;

/**
 * map操作工具类
 * 
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月12日 下午2:48:33 Exp $
 */
public class MapUtil {

    /**
     * 判断 Map 是否非空
     */
    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }

    /**
     * 判断 Map 是否为空
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return (map == null || map.isEmpty());

    }
}
