package com.wow.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 错误码属性文件操作工具类
 * 
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月12日 下午2:16:25 Exp $
 */
public class ErrorCodeUtil {

    private static final Logger logger = LoggerFactory.getLogger(ErrorCodeUtil.class);

    private static final List<String> PROPSPATHS = new ArrayList<String>(9);

    private static final Map<String, String> PROPSMAP = new HashMap<String, String>(50);

    static {
        PROPSPATHS.add("errorcode.properties");
        PROPSPATHS.add("errorcode_attribute.properties");
        PROPSPATHS.add("errorcode_order.properties");
        PROPSPATHS.add("errorcode_product.properties");
        PROPSPATHS.add("errorcode_user.properties");
        PROPSPATHS.add("errorcode_marketing.properties");
        PROPSPATHS.add("errorcode_page.properties");
        PROPSPATHS.add("errorcode_price.properties");
        PROPSPATHS.add("errorcode_stock.properties");
    }

    /**
     * 批量加载错误属性文件
     */
    public static void loadProps() {
        for (String propspath : PROPSPATHS) {
            loadProp(propspath);
        }
    }

    /**
     * 加载错误码属性文件
     */
    public static Properties loadProp(String propspath) {
        Properties props = new Properties();
        InputStream is = null;
        try {
            is = getClassLoader().getResourceAsStream(propspath);
            if (is != null) {
                props.load(is);
            }
            // 加载属性文件，并转为 Map
            putPropsToMap(props);
        } catch (Exception e) {
            logger.error("加载属性文件出错！", e);
            throw new RuntimeException(e);
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                logger.error("释放资源出错！", e);
            }
        }

        return props;
    }

    /**
     * 获取类加载器
     */
    private static ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    /**
     * 加载属性文件，并转为 Map
     */
    private static void putPropsToMap(Properties props) {
        for (String key : props.stringPropertyNames()) {
            PROPSMAP.put(key, props.getProperty(key));
        }

    }

    /**
     * 根据错误码获取相关的错误属性信息
     * 
     * @param key
     * @return
     */
    public static String getErrorMsg(String key) {
        String value = "";
        if (PROPSMAP.containsKey(key)) {
            value = PROPSMAP.get(key);
        }

        return value;
    }

}
