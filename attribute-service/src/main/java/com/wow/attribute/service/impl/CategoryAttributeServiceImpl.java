package com.wow.attribute.service.impl;

import com.wow.attribute.mapper.CategoryAttributeMapper;
import com.wow.attribute.model.CategoryAttribute;
import com.wow.attribute.model.CategoryAttributeExample;
import com.wow.attribute.service.CategoryAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.function.Consumer;

/**
 * Created by fangying@wowdsgn on 2016/6/30.
 */
@Service
@Transactional(value = "attributeTransactionManager")
public class CategoryAttributeServiceImpl implements CategoryAttributeService{

    @Autowired
    CategoryAttributeMapper categoryAttributeMapper;

    private   CategoryAttributeExample categoryAttributeExample;

    @Override
    public int createCategoryAttribute(CategoryAttribute categoryAttribute) {
        if(categoryAttribute==null)
            return 0;
        return categoryAttributeMapper.insert(categoryAttribute);
    }

    @Override
    public int updateCategoryAttribute(CategoryAttribute categoryAttribute) {
        if(categoryAttribute==null)
            return 0;
        return categoryAttributeMapper.updateByPrimaryKeySelective(categoryAttribute);
    }

    @Override
    public int deleteCategoryAttributeById(int categoryAttributeId) {
        CategoryAttribute categoryAttribute=new CategoryAttribute();
        categoryAttribute.setId(categoryAttributeId);
        categoryAttribute.setIsDeleted(true);
        return updateCategoryAttribute(categoryAttribute);
    }

    @Override
    @Transactional(propagation= Propagation.SUPPORTS)
    public CategoryAttribute getCategoryAttributeById(int categoryAttributeId) {
        return categoryAttributeMapper.selectByPrimaryKey(categoryAttributeId);
    }

    @Override
    @Transactional(propagation= Propagation.SUPPORTS)
    public List<CategoryAttribute> getCategoryAttributeByCategoryId(int categoryId) {
        categoryAttributeExample=new CategoryAttributeExample();
        CategoryAttributeExample.Criteria criteria=categoryAttributeExample.createCriteria();
        criteria.andCategoryIdEqualTo(categoryId);
        criteria.andIsDeletedEqualTo(false);
        return categoryAttributeMapper.selectByExample(categoryAttributeExample);
    }

    @Override
    public int deleteCategoryAttributeByCategoryId(int categoryId) {
        categoryAttributeExample=new CategoryAttributeExample();
        CategoryAttributeExample.Criteria criteria=categoryAttributeExample.createCriteria();
        criteria.andCategoryIdEqualTo(categoryId);
        List<CategoryAttribute> attributes=getCategoryAttributeByCategoryId(categoryId);
        attributes.forEach(new Consumer<CategoryAttribute>() {
            @Override
            public void accept(CategoryAttribute categoryAttribute) {
                categoryAttribute.setIsDeleted(true);
                categoryAttributeMapper.updateByExampleSelective(categoryAttribute,categoryAttributeExample);
            }
        });
        return 0;
    }

    @Override
    public int createCategoryAttribute(List<CategoryAttribute> categoryAttributes) {
        if(!CollectionUtils.isEmpty(categoryAttributes))
            categoryAttributes.forEach(o->createCategoryAttribute(o));
        return 0;
    }

}