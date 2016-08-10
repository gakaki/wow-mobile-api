package com.wow.order.config;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.wow.common.util.NumberUtil;
import com.wow.order.constant.OrderConstant;

/**
 * 订单相关设置的配置
 * 
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月17日 下午12:00:40 Exp $
 */
@Component
@PropertySource(value = "classpath:/order.properties")
public class OrderConstantConfig {

    @Value("${order.deliveryFee}")
    private BigDecimal deliveryFee;

    @Value("${order.deliveryFeeThreshold}")
    private BigDecimal deliveryFeeThreshold;

    /**
     * 初始化订单相关配置
     */
    @PostConstruct
    public void initOrderConstant() {
        OrderConstant.THRESHOLD = deliveryFeeThreshold;
        OrderConstant.DELIVERYFEE = deliveryFee;

        OrderConstant.THRESHOLD_LONG = NumberUtil.convertToFen(OrderConstant.THRESHOLD);

        OrderConstant.DELIVERYFEE_LONG = NumberUtil.convertToFen(OrderConstant.DELIVERYFEE);
    }

}
