package com.wow.common.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 适用场景的枚举
 * 
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月15日 下午3:59:10 Exp $
 */
public enum MaterialEnum {
    WOOD(1, "木质"),
    CHINA(2, "陶瓷"),
	IRON(3, "钢铁");
	private Integer key;

	private String value;

	private static Map<Integer, String> materialMap = null;

	static {
		 materialMap = new HashMap<Integer, String>(3);
		 MaterialEnum[] elements = MaterialEnum.values();

		for (MaterialEnum element:elements) {
			materialMap.put(element.getKey(), element.getValue());
		}
	}

	private MaterialEnum(Integer key, String value) {
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
		return materialMap.get(key);
	}

}
