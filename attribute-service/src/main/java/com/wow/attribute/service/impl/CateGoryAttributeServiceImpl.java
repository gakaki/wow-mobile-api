package com.wow.attribute.service.impl;

import com.wow.attribute.mapper.CategoryAttributeMapper;
import com.wow.attribute.model.CategoryAttribute;
import com.wow.attribute.service.CategoryAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by fangying@wowdsgn on 2016/6/30.
 */
@Service
@Transactional(value = "attributeTransactionManager")
public class CategoryAttributeServiceImpl implements CategoryAttributeService{

    @Autowired
    CategoryAttributeMapper categoryAttributeMapper;


    @Override
    public int createCategoryAttribute(CategoryAttribute categoryAttribute) {
        return categoryAttributeMapper.insert(categoryAttribute);
    }

    @Override
    public int updateCategoryAttribute(CategoryAttribute categoryAttribute) {
        return categoryAttributeMapper.updateByPrimaryKey(categoryAttribute);
    }

    @Override
    public int deleteCategoryAttributeById(int categoryAttributeId) {
        return categoryAttributeMapper.deleteByPrimaryKey(categoryAttributeId);
    }

    @Override
    public CategoryAttribute getCategoryAttributeById(int categoryAttributeId) {
        return categoryAttributeMapper.selectByPrimaryKey(categoryAttributeId);
    }

    @Override
    public List<CategoryAttribute> selectByCategoryId(int categoryId) {
        return categoryAttributeMapper.selectByCategoryId(categoryId);
    }

    @Override
    public int deleteByCategoryId(int categoryId) {
        return categoryAttributeMapper.deleteByCategoryId(categoryId);
    }

    @Override
    public int insertBatch(List<CategoryAttribute> categoryAttributes) {
        return categoryAttributeMapper.insertBatch(categoryAttributes);
    }
}