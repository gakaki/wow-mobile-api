package com.wow.attribute.service;

import com.wow.attribute.model.CategoryMaterial;
import com.wow.attribute.vo.response.MaterialResponse;

import java.util.List;

/**
 * Created by win7 on 2016/8/4.
 */
public interface CategoryMaterialService {

    /**
     * 获取分类的材质信息
     * @param categoryId
     * @return
     */
    MaterialResponse queryMaterialsByCategory(int categoryId);
}
