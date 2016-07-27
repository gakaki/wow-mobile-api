package com.wow.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 流操作工具类
 * 
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月27日 下午1:45:28 Exp $
 */

public class StreamUtil {

    private static final Logger logger = LoggerFactory.getLogger(StreamUtil.class);

    /**
     * 从输入流中获取字符串
     */
    public static String getString(InputStream is) {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (Exception e) {
            logger.error("Stream 转 String 出错！", e);
            throw new RuntimeException(e);
        } finally {
            try {
                if(reader!=null){
                    reader.close();
                }
            } catch (IOException e) {
                logger.error("", e);
            }
        }

        return sb.toString();
    }
}
