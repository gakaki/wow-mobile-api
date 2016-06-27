package com.wow.page.service;

import com.wow.page.model.AttributeFilterConfig;

import java.util.List;

/**
 * Created by zhengzhiqing on 16/6/23.
 */
public interface AttributeFilterService {
    /**
     * 根据三级分类ID获取属性筛选信息
     * @param categoryId
     * @return
     */
    List<AttributeFilterConfig> getAttributeFilterByCategoryId(int categoryId);
}
