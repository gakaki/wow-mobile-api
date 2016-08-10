package com.wow.attribute.util;

import com.wow.common.util.RedisUtil;

/**
 * Created by win7 on 2016/8/10.
 */
public class MaterialUtil {

    public static String getMaterialById(int id){
        return RedisUtil.get("m_"+id).toString();
    }
}
