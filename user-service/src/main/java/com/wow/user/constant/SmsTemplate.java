package com.wow.user.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhengzhiqing on 16/7/17.
 */
public class SmsTemplate {

    public static final int TEMPLATE_REGISTER = 1;
    public static final int TEMPLATE_RESETPWD = 2;
    public static final int TEMPLATE_VALIDATE = 3;

    public static Map<Integer,String> templateMap = new HashMap<Integer, String>();
    static {
        templateMap.put(1, "SMS_5165048");//注册验证码
        templateMap.put(2, "SMS_5165046");//修改密码验证码
        templateMap.put(3, "SMS_5165051");//身份验证验证码
    }

    public static String getTemplateByType(int tempalteType) {
        return templateMap.get(tempalteType);
    }

}
