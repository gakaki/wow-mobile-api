package com.wow.common.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 风格的枚举
 * 
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月15日 下午3:59:10 Exp $
 */
public enum StyleEnum {
	//1:北欧 2:日本
    NORTH_EUROPE(1, "北欧"),
    JAPAN(2, "日本");

	private Integer key;

	private String value;

	private static Map<Integer, String> styleMap = null;

	static {
		 styleMap = new HashMap<Integer, String>(3);
		 StyleEnum[] elements = StyleEnum.values();

		for (StyleEnum element:elements) {
			styleMap.put(element.getKey(), element.getValue());
		}
	}

	private StyleEnum(Integer key, String value) {
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
		return styleMap.get(key);
	}

}
