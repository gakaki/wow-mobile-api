package com.wow.common.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 产品状态的枚举
 * 
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月15日 下午3:59:10 Exp $
 */
public enum ProductStatusEnum  {

     //  产品状态,0:待上架 1:已上架 2:已下架
	PRODUCT_STATUS_TO_BE_SHELVE(0, "待上架"), 
	ORDER_STATUS_SHELVE(1, "已上架"), 
	ORDER_STATUS_OFF_SHELVE(2, "已下架");

	private Integer key;

	private String value;

	private static Map<Integer, String> productStatusMap = null;

	static {
	    productStatusMap = new HashMap<Integer, String>(3);
		 ProductStatusEnum[] elements = ProductStatusEnum.values();

		for (ProductStatusEnum element:elements) {
		    productStatusMap.put(element.getKey(), element.getValue());
		}
	}

	private ProductStatusEnum(Integer key, String value) {
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
		return productStatusMap.get(key);
	}

}
