package com.wow.attribute.service.impl;


import com.wow.attribute.mapper.AttributeMapper;
import com.wow.attribute.model.Attribute;
import com.wow.attribute.model.AttributeValue;
import com.wow.attribute.model.CategoryAttribute;
import com.wow.attribute.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhengzhiqing on 16/6/19.
 */
@Service
@Transactional(value = "attributeTransactionManager")
public class AttributeServiceImpl implements AttributeService {

    @Autowired
    private AttributeMapper attributeMapper;

    // Table: attribute
    /**
     * 创建属性
     *
     * @param attribute
     * @return
     */
    public int createAttribute(Attribute attribute) {
        return 0;
    }

    /**
     * 更新属性
     *
     * @param attribute
     * @return
     */
    public int updateAttribute(Attribute attribute) {
        return 0;
    }

    /**
     * 根据Id查询属性
     *
     * @param attributeId
     * @return
     */
    public Attribute getAttributeById(int attributeId) {
        return attributeMapper.selectByPrimaryKey(attributeId);
    }

    /**
     * 根据名字查询属性
     *
     * @param attributeName
     * @return
     */
    public Attribute getAttributeByName(String attributeName) {
        return null;
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
    public int deleteAttributeById(int attributeId) {
        return 0;
    }

    //Table: category_attribute

    /**
     * 添加单个属性到三级类目
     *
     * @param categoryAttribute
     * @return
     */
    public int addAttributeInCategory(CategoryAttribute categoryAttribute) {
        return 0;
    }

    /**
     * 添加多个属性到三级类目
     *
     * @param categoryId
     * @param attributes
     * @return
     */
    public int addAttributesInCategory(int categoryId, List<Attribute> attributes) {
        return 0;
    }

    /**
     * 从三级类目中删除属性
     *
     * @param categoryId
     * @param attributeIds
     * @return
     */
    public int deleteAttributesInCategory(int categoryId, int[] attributeIds) {
        return 0;
    }

    /**
     * 查询三级类目的所有属性
     *
     * @param categoryId
     * @return
     */
    public List<Attribute> getAttributesInCategory(int categoryId) {
        return null;
    }

    //Table: attribute_value

    /**
     * 添加属性值
     *
     * @param attributeValue
     * @return
     */
    public int createAttributeValue(AttributeValue attributeValue) {
        return 0;
    }

    /**
     * 删除属性值
     *
     * @param attributeValue
     * @return
     */
    public int deleteAttributeValue(AttributeValue attributeValue) {
        return 0;
    }

    /**
     * 查询一个属性所有的属性值
     *
     * @param attributeId
     * @return
     */
    public List<AttributeValue> getAttributeValues(int attributeId) {
        return null;
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
