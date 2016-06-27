package com.wow.attribute.service;

import com.wow.attribute.model.Category;

import java.util.List;

/**
 * 类目服务
 * Created by zhengzhiqing on 16/6/17.
 */
public interface CategoryService {

    /**
     * 创建类目
     *
     * @param category
     * @return
     */
    int createCategory(Category category);

    /**
     * 更新类目
     *
     * @param category
     * @return
     */
    int updateCategory(Category category);

    /**
     * 根据id查询类目
     *
     * @param categoryId
     * @return
     */
    Category getCategoryById(int categoryId);

    /**
     * 查询指定类目的子类目
     *
     * @param categoryId
     * @return
     */
    List<Category> getSubCategory(int categoryId);

    /**
     * 查询指定类目的父类目
     *
     * @param categoryId
     * @return
     */
    Category getParentCategory(int categoryId);

    /**
     * 查询所有一级类目
     *
     * @return
     */
    List<Category> getFirstLevelCategory();
}
