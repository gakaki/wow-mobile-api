package com.wow.user.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhengzhiqing on 16/7/17.
 */
public class SmsTemplate {

    public static final int TEMPLATE_REGISTER = 1;
    public static final int TEMPLATE_RESETPWD = 2;

    public static Map<Integer,String> templateMap = new HashMap<Integer, String>();
    static {
        templateMap.put(1, "SMS_5165048");
        templateMap.put(2, "SMS_5165048");
    }

    public static String getTemplateByType(int tempalteType) {
        return templateMap.get(tempalteType);
    }

}
