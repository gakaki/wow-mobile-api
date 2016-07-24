package com.wow.common.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 国家的枚举
 * 
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月15日 下午3:59:10 Exp $
 */
public enum CountryEnum {
    CHINA(1, "中国"),
    JAPAN(2, "日本"),
	DANMAI(3, "丹麦"),
	NUOWEI(4, "挪威"),
	FENLAN(5, "芬兰"),
	AMERICA(6, "美国");

	private Integer key;

	private String value;

	private static Map<Integer, String> countryMap = null;

	static {
		 countryMap = new HashMap<Integer, String>(3);
		 CountryEnum[] elements = CountryEnum.values();

		for (CountryEnum element:elements) {
			countryMap.put(element.getKey(), element.getValue());
		}
	}

	private CountryEnum(Integer key, String value) {
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
		return countryMap.get(key);
	}

}
