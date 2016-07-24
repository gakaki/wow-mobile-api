package com.wow.common.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 适用场景的枚举
 * 
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月15日 下午3:59:10 Exp $
 */
public enum ApplicableSceneEnum {
    LIVING_ROOM(1, "客厅"),
    BED_ROOM(2, "卧室"),
    KITCHEN(3, "厨房"),
    TOILET(4, "卫生间"),
    OFFICE(5, "办公室"),
    CHILD_ROOM(6, "儿童房"),
	BOOK_ROOM(7, "书房");

	private Integer key;

	private String value;

	private static Map<Integer, String> applicableSceneMap = null;

	static {
		 applicableSceneMap = new HashMap<Integer, String>(3);
		 ApplicableSceneEnum[] elements = ApplicableSceneEnum.values();

		for (ApplicableSceneEnum element:elements) {
			applicableSceneMap.put(element.getKey(), element.getValue());
		}
	}

	private ApplicableSceneEnum(Integer key, String value) {
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
		return applicableSceneMap.get(key);
	}

}
