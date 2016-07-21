package com.wow.mobileapi.util;

import com.wow.mobileapi.controller.SessionController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by zhengzhiqing on 16/7/21.
 */
public class EncodeDecodeUtil {

    private static final Logger logger = LoggerFactory.getLogger(EncodeDecodeUtil.class);

    /**
     * URLEncoder
     * @param originStr
     * @return
     */
    public static String encodeStr(String originStr) {
        String encodedStr = "";
        try {
            encodedStr = URLEncoder.encode(originStr, "utf-8");
        } catch (Exception ignore) {
            logger.warn("URLEncoder失败:" + ignore);
        }
        return encodedStr;
    }

    /**
     * URLEncoder
     * @param originStr
     * @return
     */
    public static String decodeStr(String originStr) {
        String decodedStr = "";
        try {
            decodedStr = URLDecoder.decode(originStr, "utf-8");
        } catch (Exception ignore) {
            logger.warn("URLDecoder失败:" + ignore);
        }
        return decodedStr;
    }
}
