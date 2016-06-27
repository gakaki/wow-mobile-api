package com.wow.attribute.service;


import com.wow.attribute.model.Attribute;
import com.wow.attribute.model.AttributeValue;
import com.wow.attribute.model.CategoryAttribute;

import java.util.List;

/**
 * 属性服务
 * <p>
 * Created by zhengzhiqing on 16/6/16.
 */
public interface AttributeService {

    // Table: attribute
    /**
     * 创建属性
     *
     * @param attribute
     * @return
     */
    int createAttribute(Attribute attribute);

    /**
     * 更新属性
     *
     * @param attribute
     * @return
     */
    int updateAttribute(Attribute attribute);

    /**
     * 根据Id查询属性
     *
     * @param attributeId
     * @return
     */
    Attribute getAttributeById(int attributeId);

    /**
     * 根据名字查询属性
     *
     * @param attributeName
     * @return
     */
    Attribute getAttributeByName(String attributeName);


    /**
     * 查询所有属性
     *
     * @return
     */
    List<Attribute> getAllAttributes();

    /**
     * 根据ID删除属性
     * @param attributeId
     * @return
     */
    int deleteAttributeById(int attributeId);

    //Table: category_attribute
    /**
     * 添加单个属性到三级类目
     *
     * @param categoryAttribute
     * @return
     */
    int addAttributeInCategory(CategoryAttribute categoryAttribute);

    /**
     * 添加多个属性到三级类目
     *
     * @param categoryId
     * @param attributes
     * @return
     */
    int addAttributesInCategory(int categoryId, List<Attribute> attributes);

    /**
     * 从三级类目中删除属性
     *
     * @param categoryId
     * @param attributeIds
     * @return
     */
    int deleteAttributesInCategory(int categoryId, int[] attributeIds);

    /**
     * 查询三级类目的所有属性
     *
     * @param categoryId
     * @return
     */
    List<Attribute> getAttributesInCategory(int categoryId);

    //Table: attribute_value
    /**
     * 添加属性值
     *
     * @param attributeValue
     * @return
     */
    int createAttributeValue(AttributeValue attributeValue);

    /**
     * 删除属性值
     *
     * @param attributeValue
     * @return
     */
    int deleteAttributeValue(AttributeValue attributeValue);

    /**
     * 查询一个属性所有的属性值
     *
     * @param attributeId
     * @return
     */
    List<AttributeValue> getAttributeValues(int attributeId);

}
