package com.wow.page.service.impl;

import com.wow.page.model.AttributeFilterConfig;
import com.wow.page.service.AttributeFilterService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengzhiqing on 16/6/23.
 */
@Service
public class AttributeFilterServiceImpl implements AttributeFilterService {
    /**
     * 根据三级分类ID获取属性筛选信息
     * @param categoryId
     * @return
     */
    public List<AttributeFilterConfig> getAttributeFilterByCategoryId(int categoryId) {
        return new ArrayList<AttributeFilterConfig>();
    }
}
