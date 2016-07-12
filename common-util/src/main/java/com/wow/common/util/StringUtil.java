package com.wow.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串操作工具类
 * 
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月12日 下午2:54:28 Exp $
 */
public class StringUtil {

    /**
     * 判断字符串是否非空
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 判断字符串是否为空
     */
    public static boolean isEmpty(String str) {
        return (str == null || "".equals(str));
    }

    /**
     * 
     * 判断字符串是否不都为空格
     * @param str
     * @return
     */
    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    /**
     * 判断字符串是否都为空格
     * 
     * @param str
     * @return
     */
    public static boolean isBlank(String str) {
        if (isEmpty(str)) {
            return true;
        }

        int strLen = str.length();
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    /**
     * 替换固定格式的字符串（支持正则表达式）
     */
    public static String replaceAll(String str, String regex, String replacement) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, replacement);
        }
        m.appendTail(sb);

        return sb.toString();
    }

    /**
     * 分割固定格式的字符串
     */
    public static String[] splitString(String str, String separator) {
        if (isBlank(str)) {
            return new String[] {};
        }

        StringTokenizer st = new StringTokenizer(str, separator);
        List<String> strs = new ArrayList<String>();

        while (st.hasMoreTokens()) {
            strs.add(st.nextToken());
        }

        return strs.toArray(new String[] {});
    }

}
