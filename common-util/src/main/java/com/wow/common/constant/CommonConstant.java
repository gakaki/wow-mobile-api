package com.wow.common.constant;

import java.math.BigDecimal;

/**
 * 系统相关设置的常量
 * 
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月17日 下午12:00:40 Exp $
 */
public interface CommonConstant {
    //运费阀值
    public static final BigDecimal THRESHOLD = new BigDecimal("199.00");
    
    //运费
    public static final BigDecimal DELIVERYFEE = new BigDecimal("10.00");

    //定义数值为0.00的BigDecimal
    public static final BigDecimal ZEROB_IGDECIMAL = new BigDecimal("0.00");

}
