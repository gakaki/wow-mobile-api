package com.wow.mobileapi.util;

import com.wow.common.util.StringUtil;

/**
 * Created by zhengzhiqing on 16/7/22.
 */
public class ImgPrefixUtil {
    public static final String IMG_PREFIX = "http://www.wowdsgn.com";
    public static String addPrefixForImgUrl(String imgUrl) {
        if (StringUtil.isNotEmpty(imgUrl)) {
            return IMG_PREFIX + imgUrl;
        } else {
            return "";
        }
    }

}
