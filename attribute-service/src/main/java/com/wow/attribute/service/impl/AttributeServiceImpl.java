package com.wow.attribute.service.impl;


import com.wow.attribute.mapper.AttributeMapper;
import com.wow.attribute.mapper.AttributeValueMapper;
import com.wow.attribute.model.*;
import com.wow.attribute.service.AttributeService;
import com.wow.attribute.service.CategoryAttributeService;
import com.wow.attribute.service.CategoryService;
import com.wow.attribute.vo.response.CategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhengzhiqing on 16/6/19.
 */
@Service
@Transactional("attributeTransactionManager")
public class AttributeServiceImpl implements AttributeService {

    @Autowired
    private AttributeMapper attributeMapper;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private AttributeValueMapper attributeValueMapper;
    @Autowired
    private CategoryAttributeService categoryAttributeService;

    private  final  int error=-1;

    private AttributeExample attributeExample;
    // Table: attribute
    /**
     * 创建属性
     *
     * @param attribute
     * @return
     */
    public int createAttribute(Attribute attribute) {
        if(attribute==null)
            return 0;
        return attributeMapper.insertSelective(attribute);
    }

    /**
     * 更新属性(只更新不为空的字段)
     *
     * @param attribute
     * @return
     */
    public int updateAttribute(Attribute attribute) {
        if(attribute==null)
            return 0;
        return attributeMapper.updateByPrimaryKeySelective(attribute);
    }

    /**
     * 根据Id查询属性
     *
     * @param attributeId
     * @return
     */
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public Attribute getAttributeById(int attributeId) {
        return attributeMapper.selectByPrimaryKey(attributeId);
    }

    /**
     * 根据名字查询属性
     *
     * @param attributeName
     * @return
     */
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public Attribute getAttributeByName(String attributeName) {
        return attributeMapper.selectAttributeByName(attributeName);
    }

    /**
     * 查询所有属性
     *
     * @return
     */
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public List<Attribute> getAllAttributes() {
        return attributeMapper.selectAll();
    }

    /**
     * 根据ID删除属性
     *
     * @param attributeId
     * @return
     */
    public int deleteAttributeById(int attributeId) {
         Attribute attribute=new Attribute();
        attribute.setId(attributeId);
        attribute.setIsDeleted(true);
        return updateAttribute(attribute);
    }

    //Table: category_attribute

    /**
     * 添加单个属性到三级类目
     *
     * @param categoryAttribute
     * @return
     */
    public int addAttributeInCategory(CategoryAttribute categoryAttribute) {
        if(categoryAttribute==null)
            return 0;
        return categoryAttributeService.createCategoryAttribute(categoryAttribute);
    }

    /**
     * 添加多个属性到三级类目
     *
     * @param categoryId
     * @param attributes
     * @return
     */
    public int addAttributesInCategory(int categoryId, List<Attribute> attributes)  {
        if(CollectionUtils.isEmpty(attributes))
            return 0;
        List<CategoryAttribute> list=new ArrayList<>();
        for (Attribute attribute:attributes)
        {
            list.add(setCategoryAttribute(categoryId, attribute));
        }
        categoryAttributeService.createCategoryAttribute(list);
        return 0;
    }

    private CategoryAttribute setCategoryAttribute(int categoryId, Attribute attribute) {
        CategoryAttribute categoryAttribute =new CategoryAttribute();
        categoryAttribute.setCategoryId(categoryId);
        categoryAttribute.setAttributeId(attribute.getId());
        categoryAttribute.setCreateBy(attribute.getUpdateBy());
        categoryAttribute.setCreateTime(new java.util.Date());
        categoryAttribute.setIsDeleted(false);
        categoryAttribute.setUdpateBy(attribute.getUpdateBy());
        categoryAttribute.setUpdateTime(new java.util.Date());
        return categoryAttribute;
    }

    /**
     * 从三级类目中删除属性
     *
     * @param categoryId
     * @param attributeIds
     * @return
     */
    public int deleteAttributesInCategory(int categoryId, Integer[] attributeIds)  {

        try{
            List<Integer> list=Arrays.asList(attributeIds);
            for (Integer i:list)
            {
                deleteAttributeById(i);
            }
            categoryService.deleteCategoryById(categoryId);
            categoryAttributeService.deleteCategoryAttributeByCategoryId(categoryId);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return 0;
    }

    /**
     * 查询三级类目的所有属性
     *
     * @param categoryId
     * @return
     */
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public List<Attribute> getAttributesInCategory(int categoryId) {
        CategoryResponse categoryResponse=categoryService.getCategoryById(categoryId);
        Category category = categoryResponse.getCategory();
        if(category==null)
        return null;
        List<CategoryAttribute> categoryAttributes= categoryAttributeService.getCategoryAttributeByCategoryId(category.getId());
        List<Attribute> attributes=new ArrayList<>();
        for (CategoryAttribute categoryAttribute:categoryAttributes) {
         Attribute attribute= attributeMapper.selectByPrimaryKey(categoryAttribute.getAttributeId());
            if(attribute!=null)
                attributes.add(attribute);
        }
        return attributes;
    }

    //Table: attribute_value

    /**
     * 添加属性值
     *
     * @param attributeValue
     * @return
     */
    public int createAttributeValue(AttributeValue attributeValue) {
        return attributeValueMapper.insertSelective(attributeValue);
    }

    /**
     * 删除属性值
     *
     * @param attributeValue
     * @return
     */
    public int deleteAttributeValue(AttributeValue attributeValue) {
        if(attributeValue==null)
            return 0;
        attributeValue.setIsDeleted(true);
        return attributeValueMapper.updateByPrimaryKeySelective(attributeValue);
    }

    /**
     * 查询一个属性所有的属性值
     *
     * @param attributeId
     * @return
     */
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public List<AttributeValue> getAttributeValues(int attributeId) {
        return attributeValueMapper.selectAll();
    }

//    //table: product_attribute
//
//    /**
//     * 查询产品的属性:根据product找category,根据category找category_attributes
//     *
//     * @param product
//     * @return
//     */
//    public List<Attribute> getAttributesInProduct(Product product) {
//        return null;
//    }
//
//    /**
//     * 批量设置产品的属性值
//     *
//     * @param productAttributes
//     * @return
//     */
//    public int createProductAttribute(List<ProductAttribute> productAttributes) {
//        return 0;
//    }
//
//    /**
//     * 批量更新产品的属性值
//     *
//     * @param productAttributes
//     * @return
//     */
//    public int updateProductAttribute(List<ProductAttribute> productAttributes) {
//        return 0;
//    }

}
