package com.wow.attribute.service.impl;

import com.wow.attribute.model.Category;
import com.wow.attribute.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 类目服务
 * Created by zhengzhiqing on 16/6/17.
 */
@Service
@Transactional(value = "attributeTransactionManager")
public class CategoryServiceImpl implements CategoryService {

    /**
     * 创建类目
     *
     * @param category
     * @return
     */
    public int createCategory(Category category) {
        return 0;
    }

    /**
     * 更新类目
     *
     * @param category
     * @return
     */
    public int updateCategory(Category category) {
        return 0;
    }

    /**
     * 根据id查询类目
     *
     * @param categoryId
     * @return
     */
    public Category getCategoryById(int categoryId) {
        return null;
    }

    /**
     * 查询指定类目的子类目
     *
     * @param categoryId
     * @return
     */
    public List<Category> getSubCategory(int categoryId) {
        return null;
    }

    /**
     * 查询指定类目的父类目
     *
     * @param categoryId
     * @return
     */
    public Category getParentCategory(int categoryId) {
        return null;
    }

    /**
     * 查询所有一级类目
     *
     * @return
     */
    public List<Category> getFirstLevelCategory() {
        return null;
    }
}
