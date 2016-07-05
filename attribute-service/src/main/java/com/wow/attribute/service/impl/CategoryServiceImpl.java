package com.wow.attribute.service.impl;

import com.wow.attribute.mapper.CategoryMapper;
import com.wow.attribute.model.Category;
import com.wow.attribute.model.CategoryExample;
import com.wow.attribute.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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

    private CategoryExample categoryExample;
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
        return categoryMapper.updateByPrimaryKeySelective(category);
    }

    /**
     * 删除类目
     * @param categoryId
     * @return
     */
    public int deleteCategoryById(int categoryId) {
        Category category=new Category();
        category.setId(categoryId);
        category.setIsDeleted(true);
        return updateCategory(category);
    }

    /**
     * 根据id查询类目
     *
     * @param categoryId
     * @return
     */
    @Transactional(propagation= Propagation.SUPPORTS)
    public Category getCategoryById(int categoryId) {
        return categoryMapper.selectByPrimaryKey(categoryId);
    }



    /**
     * 查询指定类目的子类目
     *
     * @param categoryId
     * @return
     */
    @Transactional(propagation= Propagation.SUPPORTS)
    public List<Category> getSubCategory(int categoryId) {
        categoryExample=new CategoryExample();
        CategoryExample.Criteria criteria=categoryExample.createCriteria();
        criteria.andParentCategoryIdEqualTo(categoryId);
        criteria.andIsDeletedEqualTo(false);
        return categoryMapper.selectByExample(categoryExample);
    }

    /**
     * 查询指定类目的父类目
     *
     * @param categoryId
     * @return
     */
    @Transactional(propagation= Propagation.SUPPORTS)
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
    @Transactional(propagation= Propagation.SUPPORTS)
    public List<Category> getFirstLevelCategory() {
        return getSubCategory(parentFirstLevelCategory);
    }


}
