package com.wow.order.constant;

import java.math.BigDecimal;

/**
 * 订单相关设置的常量
 * 
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月17日 下午12:00:40 Exp $
 */
public class OrderConstant {

    //运费阀值 在OrderConstantConfig中进行初始化
    public static BigDecimal THRESHOLD = null;

    //运费阀值 long类型
    public static long THRESHOLD_LONG = 0L;

    //运费 在OrderConstantConfig中进行初始化
    public static BigDecimal DELIVERYFEE = null;

    //运费 long类型
    public static long DELIVERYFEE_LONG = 0L;

}
