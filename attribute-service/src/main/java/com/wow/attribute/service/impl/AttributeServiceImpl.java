package com.wow.attribute.service.impl;


import com.wow.attribute.mapper.AttributeMapper;
import com.wow.attribute.mapper.AttributeValueMapper;
import com.wow.attribute.model.Attribute;
import com.wow.attribute.model.AttributeValue;
import com.wow.attribute.model.Category;
import com.wow.attribute.model.CategoryAttribute;
import com.wow.attribute.service.AttributeService;
import com.wow.attribute.service.CategoryAttributeService;
import com.wow.attribute.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhengzhiqing on 16/6/19.
 */
@Service
@Transactional(value = "attributeTransactionManager")
public class AttributeServiceImpl  extends BaseService<Attribute> implements AttributeService {

    @Autowired
    private AttributeMapper attributeMapper;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AttributeValueMapper attributeValueMapper;
    @Autowired
    private CategoryAttributeService categoryAttributeService;

    private  final  int error=-1;
    @Autowired
    @Override
    public void setMapper() {
        super.baseMapper=attributeMapper;
    }
    // Table: attribute
    /**
     * 创建属性
     *
     * @param attribute
     * @return
     */
//    public int createAttribute(Attribute attribute) {
//        return 0;
//    }

    /**
     * 更新属性(只更新不为空的字段)
     *
     * @param attribute
     * @return
     */
//    public int updateAttribute(Attribute attribute) {
//        return attributeMapper.updateByPrimaryKey(attribute);
//    }

    /**
     * 根据Id查询属性
     *
     * @param attributeId
     * @return
     */
//    public Attribute getAttributeById(int attributeId) {
//        return attributeMapper.selectByPrimaryKey(attributeId);
//    }

    /**
     * 根据名字查询属性
     *
     * @param attributeName
     * @return
     */
    public Attribute getAttributeByName(String attributeName) {
        return attributeMapper.selectAttributeByName(attributeName);
    }

    /**
     * 查询所有属性
     *
     * @return
     */
    public List<Attribute> getAllAttributes() {
        return attributeMapper.selectAll();
    }

    /**
     * 根据ID删除属性
     *
     * @param attributeId
     * @return
     */
//    public int deleteAttributeById(int attributeId) {
//        return attributeMapper.deleteByPrimaryKey(attributeId);
//    }

    //Table: category_attribute

    /**
     * 添加单个属性到三级类目
     *
     * @param categoryAttribute
     * @return
     */
    public int addAttributeInCategory(CategoryAttribute categoryAttribute) {
        return categoryAttributeService.insert(categoryAttribute);
    }

    /**
     * 添加多个属性到三级类目
     *
     * @param categoryId
     * @param attributes
     * @return
     */
    public int addAttributesInCategory(int categoryId, List<Attribute> attributes)  {
//       attributeMapper.insertBatch(attributes);
//        List<CategoryAttribute> list=new ArrayList<>();
//
//            for (Attribute attribute:attributes) {
//                CategoryAttribute categoryAttribute =new CategoryAttribute();
//                categoryAttribute.setCategoryId(categoryId);
//                categoryAttribute.setAttributeId(attribute.getId());
//                categoryAttribute.setCreateBy("fangy");
//                categoryAttribute.setCreateTime(new java.util.Date());
//                categoryAttribute.setIsDeleted(false);
//                categoryAttribute.setUdpateBy("");
//                categoryAttribute.setUpdateTime(new java.util.Date());
//                list.add(categoryAttribute);
//            }
        List<CategoryAttribute> list=new ArrayList<>();
        for (Attribute attribute:attributes)
        {
            attributeMapper.insert(attribute);
            CategoryAttribute categoryAttribute =new CategoryAttribute();
            categoryAttribute.setCategoryId(categoryId);
            categoryAttribute.setAttributeId(attribute.getId());
            categoryAttribute.setCreateBy("fangy");
            categoryAttribute.setCreateTime(new java.util.Date());
            categoryAttribute.setIsDeleted(false);
            categoryAttribute.setUdpateBy("");
            categoryAttribute.setUpdateTime(new java.util.Date());
            list.add(categoryAttribute);
        }
        categoryAttributeService.insertBatch(list);
        return 0;
    }

    /**
     * 从三级类目中删除属性
     *
     * @param categoryId
     * @param attributeIds
     * @return
     */
    public int deleteAttributesInCategory(int categoryId, Integer[] attributeIds) {
        categoryService.deleteByPrimaryKey(categoryId);
        List list=Arrays.asList(attributeIds);
        attributeMapper.deleteBatchByPrimaryKey(list);
        categoryAttributeService.deleteByCategoryId(categoryId);
        return 0;
    }

    /**
     * 查询三级类目的所有属性
     *
     * @param categoryId
     * @return
     */
    public List<Attribute> getAttributesInCategory(int categoryId) {
        Category category=categoryService.selectByPrimaryKey(categoryId);
        if(category==null)
        return null;
        List<CategoryAttribute> categoryAttributes= categoryAttributeService.selectByCategoryId(category.getId());
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
        return attributeValueMapper.insert(attributeValue);
    }

    /**
     * 删除属性值
     *
     * @param attributeValue
     * @return
     */
    public int deleteAttributeValue(AttributeValue attributeValue) {
        if(attributeValue==null)
            return error;
        return attributeValueMapper.deleteByPrimaryKey(attributeValue.getId());
    }

    /**
     * 查询一个属性所有的属性值
     *
     * @param attributeId
     * @return
     */
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
