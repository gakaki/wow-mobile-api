package com.wow.attribute.mapper;

import com.wow.attribute.model.CategoryMaterial;

import java.util.List;

/**
 * Created by win7 on 2016/8/4.
 */
public interface CategoryMaterialMapper {

    List<CategoryMaterial> queryMaterialsByCategory(int categoryId);
}
