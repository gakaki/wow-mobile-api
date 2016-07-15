package com.wow.common.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 订单状态的枚举
 * 
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月15日 下午3:59:10 Exp $
 */
public enum SaleOrderStatusEnum  {
     //订单状态：0 待付款  1待发货  2部分发货  3待收货  4已完成 5已取消 6交易关闭
    TO_BE_PAID(0, "代付款"), 
    TO_BE_SHIPPED(1, "待发货"), 
    PARTIAL_SHIPPED(2, "部分发货"),
    TO_BE_RECEIVED(0, "待收货"), 
    COMPLETED(1, "已完成"), 
    CANCELLED(2, "已取消"),
    CLOSED(2, "交易关闭");

	private Integer key;

	private String value;

	private static Map<Integer, String> orderStatusMap = null;

	static {
		 orderStatusMap = new HashMap<Integer, String>(3);
		 SaleOrderStatusEnum[] elements = SaleOrderStatusEnum.values();

		for (SaleOrderStatusEnum element:elements) {
			orderStatusMap.put(element.getKey(), element.getValue());
		}
	}

	private SaleOrderStatusEnum(Integer key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	public Integer getKey() {
		return this.key;
	}

	public static String get(Integer key) {
		return orderStatusMap.get(key);
	}

}
