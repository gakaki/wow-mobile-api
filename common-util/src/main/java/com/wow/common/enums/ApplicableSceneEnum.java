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
    LIVING_ROOM("living room", "客厅"),
    BED_ROOM("bed room", "卧室"),
    KITCHEN("kitchen", "厨房"),
    TOILET("restroom", "卫生间"),
    OFFICE("office", "办公室"),
    CHILD_ROOM("children bedroom", "儿童房"),
	BOOK_ROOM("", "书房");

	private String key;

	private String value;

	private static Map<String, String> applicableSceneMap = null;

	static {
		 applicableSceneMap = new HashMap<String, String>(3);
		 ApplicableSceneEnum[] elements = ApplicableSceneEnum.values();

		for (ApplicableSceneEnum element:elements) {
			applicableSceneMap.put(element.getKey(), element.getValue());
		}
	}

	private ApplicableSceneEnum(String key, String value) {
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
		return applicableSceneMap.get(key);
	}

}
