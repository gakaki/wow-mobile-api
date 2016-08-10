package com.wow.common.util;

import java.math.BigDecimal;

import com.wow.common.constant.CommonConstant;

/**
 * 金额转换计算工具类
 * 
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月14日 下午5:50:14 Exp $
 */
public class NumberUtil {

    /**
     * 判断2个数是否相等
     * 
     * @param v1
     * @param v2
     * @return
     */
    public static boolean isEquals(BigDecimal v1, BigDecimal v2) {
        return v1.compareTo(v2) == 0 ? true : false;
    }

    /**
     * 判断2个数是否不相等
     * 
     * @param v1
     * @param v2
     * @return
     */
    public static boolean isNotEquals(BigDecimal v1, BigDecimal v2) {
        return !isEquals(v1, v2);
    }

    /**
     * 提供精确的加法运算。
     * 
     * @param v1 被加数
     * @param v2 加数
     * @return 两个参数的和
     */

    public static double add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));

        return b1.add(b2).doubleValue();
    }

    /**
     * 提供精确的加法运算。
     * 
     * @param v1
     * @param v2
     * @return
     */
    public static BigDecimal add(BigDecimal v1, BigDecimal v2) {
        BigDecimal b1 = new BigDecimal(v1.toString());
        BigDecimal b2 = new BigDecimal(v2.toString());

        return b1.add(b2);
    }

    /**
     * 提供精确的减法运算。
     * 
     * @param v1 被减数
     * @param v2 减数
     * @return 两个参数的差
     */

    public static double sub(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));

        return b1.subtract(b2).doubleValue();
    }

    /**
     * 比较2个数字的大小 相等返回0 如果第一个数大于后面的返回1 小于的返回-1
     * 
     * @param v1
     * @param v2
     * @return
     */
    public static int compare(BigDecimal v1, BigDecimal v2) {
        return v1.compareTo(v2);
    }

    /**
     * 2个参数的差
     * 
     * @param v1
     * @param v2
     * @return
     */
    public static BigDecimal sub(BigDecimal v1, BigDecimal v2) {
        BigDecimal b1 = new BigDecimal(v1.toString());
        BigDecimal b2 = new BigDecimal(v2.toString());

        return b1.subtract(b2);
    }

    /**
     * 提供精确的乘法运算。
     * 
     * @param v1 被乘数
     * @param v2 乘数
     * @return 两个参数的积
     */
    public static double mul(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));

        return b1.multiply(b2).doubleValue();
    }

    /**
     * 
     * 两个参数的积 注意直接使用BigDecimal进行计算会有精度问题 必须要转换为字符串才能保证计算的正确性
     * 
     * @param v1
     * @param v2
     * @return
     */
    public static BigDecimal mul(BigDecimal v1, BigDecimal v2) {
        BigDecimal b1 = new BigDecimal(v1.toString());
        BigDecimal b2 = new BigDecimal(v2.toString());

        return toFixed(b1.multiply(b2));
    }

    /**
     * 提供精确的乘法运算 保留2位数字。
     * 
     * @param v1 被乘数
     * @param v2 乘数
     * @return 两个参数的积
     */
    public static double mul(double v1, double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }

        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));

        return toFixedTwo(b1.multiply(b2).doubleValue()).doubleValue();
    }

    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。
     * 
     * @param v1 被除数
     * @param v2 除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */
    public static double div(double v1, double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));

        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 默认保留2位小数
     * 
     * @param v1
     * @param v2
     * @return
     * @date 2015年10月10日 下午2:42:49
     */
    public static double div(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));

        return b1.divide(b2, 2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 
     * 两个参数的商
     * 
     * @param v1
     * @param v2
     * @return
     */
    public static BigDecimal div(BigDecimal v1, BigDecimal v2) {
        BigDecimal b1 = new BigDecimal(v1.toString());
        BigDecimal b2 = new BigDecimal(v2.toString());

        return b1.divide(b2);
    }

    /**
     * 将指定的数字进行四舍五入 保留2位数字
     * 
     * @param v1
     * @return
     */
    public static BigDecimal toFixedTwo(double v1) {
        return toFixed(v1, 2);
    }

    /**
     * 将指定的数字进行四舍五入 保留指定的数字
     * 
     * @param v1
     * @return
     */
    public static BigDecimal toFixed(BigDecimal v1) {
        return v1.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 将指定的数字进行四舍五入 保留指定的数字
     * 
     * @param v1
     * @param numLen 需要保留的小数位数
     * @return
     */
    public static BigDecimal toFixed(double v1, int numLen) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));

        return b1.setScale(numLen, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 获取2位数字相除的百分比
     * 
     * @param v1
     * @param v2
     * @return
     * @date 2015年10月10日 下午2:44:15
     */
    public static int getPercent(double v1, double v2) {
        if (v2 == 0) {
            throw new IllegalArgumentException("除数不能为0");
        }
        return (int) (div(v1, v2) * 100);
    }

    /**
     * 将产品价格由分转换为元 0.08
     * 
     * @param sellPrice
     */
    public static BigDecimal convertToYuan(long amount) {
        if (amount == 0) {
            return CommonConstant.ZERO_BIGDECIMAL;
        }

        BigDecimal divide = div(new BigDecimal(String.valueOf(amount)), CommonConstant.HUNDRED_IGDECIMAL);

        return toFixedTwo(divide);
    }

    /**
     * 将价格转换为分计算
     * 
     * @param sellPrice
     */
    public static long convertToFen(BigDecimal sellPrice) {
        if (sellPrice == null) {
            return 0L;
        }

        return Long.parseLong(sellPrice.toString().replace(".", ""));
    }

    /**
     * 将指定的数字进行四舍五入 保留2位数字
     * 
     * @param v1
     * @return
     */
    public static BigDecimal toFixedTwo(BigDecimal v1) {
        return v1.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

}
