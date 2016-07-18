package com.wow.common.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhengzhiqing on 16/7/16.
 */
public enum StockChangeBizTypeEnum {


// 业务类型
// 1:下单(冻结库存) 2:发货(扣减实际和冻结) 3:虚拟库存到货之后发货(扣减虚拟冻结)
// 3:未发货之前取消订单(减冻结) 4:已发货之后退货(加实际库存) 5:调整实际库存(如进货)
// 6:调整虚拟库存 7:调整锁定库存 8:调整坏品库存 9:库存对账系统调整库存 10:创建仓库库存 11:创建虚拟库存

    BIZ_TYPE_PLACE_ORDER(0, "下单"),
    BIZ_TYPE_SHIP_OUT(1, "发货"),
    BIZ_TYPE_CANCEL_ORDER(2, "取消订单"),
    BIZ_TYPE_ADJUST_REAL_STOCK(3, "调整实际库存"),
    BIZ_TYPE_ADJUST_LOCK_STOCK(4, "调整锁定库存"),
    BIZ_TYPE_RANDOM_MODIFY(5, "任意修改"),
    BIZ_TYPE_CONCILATION(6, "库存对账");

    private Integer key;

    private String value;

    private static Map<Integer, String> bizTypeMap = null;

    static {
        bizTypeMap = new HashMap<Integer, String>(20);
        StockChangeBizTypeEnum[] elements = StockChangeBizTypeEnum.values();

        for (StockChangeBizTypeEnum element:elements) {
            bizTypeMap.put(element.getKey(), element.getValue());
        }
    }

    private StockChangeBizTypeEnum(Integer key, String value) {
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
        return bizTypeMap.get(key);
    }


}
