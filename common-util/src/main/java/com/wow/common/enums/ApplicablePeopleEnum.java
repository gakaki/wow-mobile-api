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
	//适用人群:0-通用,1-成人,2-男性,3-女性,4-儿童,5-老人
    GENERAL(1, "通用"),
    ADULTS(2, "成人"),
	MALE(3, "男性"),
	FEMALE(4, "女性"),
	CHILDREN(5, "儿童"),
	OLD(6, "老人");
	private Integer key;

	private String value;

	private static Map<Integer, String> applicablePeopleMap = null;

	static {
		 applicablePeopleMap = new HashMap<Integer, String>(3);
		 ApplicablePeopleEnum[] elements = ApplicablePeopleEnum.values();

		for (ApplicablePeopleEnum element:elements) {
			applicablePeopleMap.put(element.getKey(), element.getValue());
		}
	}

	private ApplicablePeopleEnum(Integer key, String value) {
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
		return applicablePeopleMap.get(key);
	}

}
