package com.wow.common.util;

/**
 * Created by win7 on 2016/8/10.
 */
public class CountryUtil {

    public static String getCountryById(int id){
        return RedisUtil.get("c_"+id).toString();
    }
}
