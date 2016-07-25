package com.wow.common.constant;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 系统相关设置的常量
 * 
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月17日 下午12:00:40 Exp $
 */
public class CommonConstant {
    //运费阀值
    public static final BigDecimal THRESHOLD = new BigDecimal("199.00");

    //运费
    public static final BigDecimal DELIVERYFEE = new BigDecimal("10.00");

    //定义数值为0.00的BigDecimal
    public static final BigDecimal ZEROB_IGDECIMAL = new BigDecimal("0.00");
    
    //除数常量 100
    public static final BigDecimal HUNDRED_IGDECIMAL = new BigDecimal("100");
    
    //是
    public static final int MAX_PAGE = 100;

    //是
    public static final Byte YES = 1;

    //否
    public static final Byte NO = 0;

    //已支付
    public static final Byte PAID = 1;

    //未支付
    public static final Byte UNPAY = 2;

    //数字0
    public static final Byte ZERO = 1;

    //数字1
    public static final Byte ONE = 1;

    //数字2
    public static final Byte TWO = 2;

    //数字3
    public static final Byte THREE = 3;

    //数字4
    public static final Byte FOUR = 4;

    //数字5
    public static final Byte FIVE = 5;

    //数字6
    public static final Byte SIX = 6;
    
    //订单支付状态
    //支付情况note:  1: paid     2: unpay
    private static final Map<Byte, String> PAY_STATUS_MAP = new HashMap<Byte, String>() {
        /**  */
        private static final long serialVersionUID = 1L;
        {
            put(ONE, "已支付");
            put(TWO, "未支付");
        }
    };

    //订单支付方式
    //1:网上支付-微信 2.网上支付-支付宝 3.货到付现金 4.货到刷卡 5.货到支付宝扫码支付 6.货到微信扫码支付
    private static final Map<Byte, String> PAY_METHOD_MAP = new HashMap<Byte, String>() {
        /**  */
        private static final long serialVersionUID = 1L;
        {
            put(ONE, "微信");
            put(TWO, "支付宝");
            put(THREE, "货到付现金");
            put(FOUR, "货到刷卡");
            put(FIVE, "支付宝扫码支付");
            put(SIX, "微信扫码支付");
        }
    };

    //配送方式 1. 尖叫合作物流，2. 供应商合作物流 3.京东 4.日日顺
    private static final Map<Byte, String> DELIVERY_MOTHOD_MAP = new HashMap<Byte, String>() {
        /**  */
        private static final long serialVersionUID = 1L;
        {
            put(ONE, "尖叫合作物流");
            put(TWO, "供应商合作物流");
            put(THREE, "京东");
            put(FOUR, "日日顺");
        }
    };

    /** 取得配送方式描述.*/
    public static String getDeliveryMothodName(Byte code) {
        return DELIVERY_MOTHOD_MAP.get(code);
    }

    /** 取得支付方式描述.*/
    public static String getPayMethodName(Byte code) {
        return PAY_METHOD_MAP.get(code);
    }
    
    /** 取得支付状态描述.*/
    public static String getPayStatusName(Byte code) {
        return PAY_STATUS_MAP.get(code);
    }

}
