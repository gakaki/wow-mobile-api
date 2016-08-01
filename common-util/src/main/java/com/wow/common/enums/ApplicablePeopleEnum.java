package com.wow.common.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 适用人群的枚举
 * 
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月15日 下午3:59:10 Exp $
 */
public enum ApplicablePeopleEnum {
	GENERAL("general", "通用"),
	ADULTS("adult", "成人"),
	MALE("male", "男性"),
	FEMALE("female", "女性"),
	CHILDREN("children", "儿童"),
	OLD("elder", "老人");
	private String key;

	private String value;

	private static Map<String, String> applicablePeopleMap = null;

	static {
		applicablePeopleMap = new HashMap<String, String>(3);
		ApplicablePeopleEnum[] elements = ApplicablePeopleEnum.values();

		for (ApplicablePeopleEnum element:elements) {
			element.
			applicablePeopleMap.put(element.getKey(), element.getValue());
		}
	}

	private ApplicablePeopleEnum(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	public String getKey() {
		return this.key;
	}

	public static String get(String key) {
		return applicablePeopleMap.get(key);
	}

}
