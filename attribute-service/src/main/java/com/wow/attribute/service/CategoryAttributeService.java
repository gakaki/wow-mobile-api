package com.wow.attribute.service;

import com.wow.attribute.model.CategoryAttribute;

import java.util.List;


/**
 * Created by fangying@wowdsgn on 2016/6/30.
 */
public interface CategoryAttributeService{
    /**
     * 创建属性类目
     * @param categoryAttribute
     * @return
     */
    int createCategoryAttribute(CategoryAttribute categoryAttribute);

    /**
     * 更新属性类目
     * @param categoryAttribute
     * @return
     */
    int updateCategoryAttribute(CategoryAttribute categoryAttribute);

    /**
     * 根据ID删除
     * @param categoryAttributeId
     * @return
     */
    int deleteCategoryAttributeById(int categoryAttributeId);

    /**
     * 根据Id查询
     * @param categoryAttributeId
     * @return
     */
    CategoryAttribute getCategoryAttributeById(int categoryAttributeId);

    /**
     * 根据类目Id查询
     * @param categoryId
     * @return
     */
    List<CategoryAttribute> getCategoryAttributeByCategoryId(int categoryId);

    /**
     * 根据类目Id删除
     * @param categoryId
     * @return
     */
    int deleteCategoryAttributeByCategoryId(int categoryId);

    /**
     * 批量插入
     * @param CategoryAttributes
     * @return
     */
    int createCategoryAttribute(List<CategoryAttribute> CategoryAttributes);
}
