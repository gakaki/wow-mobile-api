package com.wow.attribute.mapper;

import com.wow.attribute.model.CategoryMaterial;

/**
 * Created by win7 on 2016/8/4.
 */
public interface CategoryMaterialMapper {

    CategoryMaterial queryMaterialsByCategory(int categoryId);
}
