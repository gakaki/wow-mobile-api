package com.wow.common.constant;

/**
 * Created by zhengzhiqing on 16/7/20.
 */
public interface BizConstant {

    //页面类型 1. 移动端首页 2. 移动端发现页
    public static final byte PAGE_TYPE_HOME = 1;
    public static final byte PAGE_TYPE_FIND = 2;

    //页面模块类型 1：banner轮播 2：banner列表 3:精选分类 4:单品推荐 5:新品推荐
    public static final byte PAGE_MODULE_TYPE_BANNER_CAROUSEL = 1;
    public static final byte PAGE_MODULE_TYPE_BANNER_LIST = 2;
    public static final byte PAGE_MODULE_TYPE_CATEGORY = 3;
    public static final byte PAGE_MODULE_TYPE_PRODUCT = 4;
    public static final byte PAGE_MODULE_TYPE_PRODUCT_NEWARRIVAL = 5;

    //产品类型
    public static final byte PRODUCT_TYPE_SERIAL_SUB = 1;//系列品子品
    public static final byte PRODUCT_TYPE_SERIAL = 2;//系列品
    public static final byte PRODUCT_TYPE_BUNDLE = 3;//组合产品

    //banner跳转目标类型
    public static final byte LINK_TYPE_WEB = 1;
    public static final byte LINK_TYPE_TOPIC_LIST = 2;
    public static final byte LINK_TYPE_TOPIC_MIX = 3;
    public static final byte LINK_TYPE_BRAND = 4;
    public static final byte LINK_TYPE_DESIGNER = 5;
    public static final byte LINK_TYPE_PRODUCT = 6;
    public static final byte LINK_TYPE_CATEGORY = 7;
    public static final byte LINK_TYPE_TOPIC = 8;

    //产品分类级别
    public static final byte PAGE_CATEGORY_LEVEL = 1;

    //字典分组类型
    public static final String DICTIONARY_GROUP_PAY="pay_channel";
    public static final String DICTIONARY_GROUP_COUNTRY="country";
    public static final String DICTIONARY_GROUP_APPLICABLE_PEOPLE="applicable_people";
    public static final String DICTIONARY_GROUP_APPLICABLE_SCENE="applicable_scene";
    public static final String DICTIONARY_GROUP_STYLE="style";

}
