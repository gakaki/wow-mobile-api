package com.wow.attribute.service;

import com.wow.attribute.mapper.BaseMapper;
import com.wow.attribute.model.Category;

import java.util.List;

/**
 * 类目服务
 * Created by zhengzhiqing on 16/6/17.
 */
public interface CategoryService extends BaseMapper<Category> {

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
