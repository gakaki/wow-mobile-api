package com.wow.attribute.service.impl;

import com.wow.attribute.mapper.CategoryMapper;
import com.wow.attribute.model.Category;
import com.wow.attribute.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 类目服务
 * Created by zhengzhiqing on 16/6/17.
 */
@Service
@Transactional(value = "attributeTransactionManager")
public class CategoryServiceImpl  implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    private final int parentFirstLevelCategory=0;

    /**
     * 创建类目
     *
     * @param category
     * @return
     */
    public int createCategory(Category category) {
        return categoryMapper.insert(category);
    }

    /**
     * 更新类目
     *
     * @param category
     * @return
     */
    public int updateCategory(Category category) {
        return categoryMapper.updateByPrimaryKey(category);
    }

    /**
     * 删除类目
     * @param categoryId
     * @return
     */
    public int deleteCategoryById(int categoryId) {
        return categoryMapper.deleteByPrimaryKey(categoryId);
    }

    /**
     * 根据id查询类目
     *
     * @param categoryId
     * @return
     */
    public Category getCategoryById(int categoryId) {
        return categoryMapper.selectByPrimaryKey(categoryId);
    }



    /**
     * 查询指定类目的子类目
     *
     * @param categoryId
     * @return
     */
    public List<Category> getSubCategory(int categoryId) {
        return categoryMapper.getSubCategory(categoryId);
    }

    /**
     * 查询指定类目的父类目
     *
     * @param categoryId
     * @return
     */
    public Category getParentCategory(int categoryId) {
        Category category= categoryMapper.selectByPrimaryKey(categoryId);
        if(category==null)
        return null;
       return categoryMapper.selectByPrimaryKey(category.getParentCategoryId());
    }

    /**
     * 查询所有一级类目
     *
     * @return
     */
    public List<Category> getFirstLevelCategory() {
        return getSubCategory(parentFirstLevelCategory);
    }


}
