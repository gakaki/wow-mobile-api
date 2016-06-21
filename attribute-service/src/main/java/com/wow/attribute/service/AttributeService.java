package com.wow.attribute.service;


import com.wow.attribute.model.*;
import com.wow.product.model.Product;
import com.wow.product.model.ProductAttribute;

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

    //Table: attribute_group

    /**
     * 创建属性组
     *
     * @param attributeGroup
     * @return
     */
    int createAttributeGroup(AttributeGroup attributeGroup);

    /**
     * 根据属性组Id查询属性组
     *
     * @param attributeGroupId
     * @return
     */
    AttributeGroup getAttributeGroupById(int attributeGroupId);

    /**
     * 根据属性组名查询属性组
     *
     * @param attributeGroupName
     * @return
     */
    AttributeGroup getAttributeGroupByName(String attributeGroupName);

    /**
     * 更新属性组
     *
     * @param attributeGroup
     * @return
     */
    int updateAttributeGroup(AttributeGroup attributeGroup);

    //Table: attribute_group_attribute

    /**
     * 添加单个属性到属性组
     *
     * @param attributeGroupAttribute
     * @return
     */
    int createAttributeGroupAttribute(AttributeGroupAttribute attributeGroupAttribute);

    /**
     * 添加多个属性到属性组
     *
     * @param attributeGroupId
     * @param attributeIds
     * @return
     */
    int addAttributesIntoAttributeGroup(int attributeGroupId, int[] attributeIds);

    /**
     * 从属性组删除属性
     *
     * @param attributeGroupId
     * @param attributeIds
     * @return
     */
    int removeAttributeFromAttributeGroup(int attributeGroupId, int[] attributeIds);

    /**
     * 查询属性组里所有属性
     *
     * @param attributeGroupId
     * @return
     */
    List<Attribute> getAttributesByAttributeGroupId(int attributeGroupId);

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
    int removeAttributeValue(AttributeValue attributeValue);

    /**
     * 查询一个属性所有的属性值
     *
     * @param attributeId
     * @return
     */
    List<AttributeValue> getAttributeValues(int attributeId);

//table: product_attribute

    /**
     * 查询产品的属性组
     *
     * @param product
     * @return
     */
    AttributeGroup queryAttributeGroupByProduct(Product product);

    /**
     * 设置产品的属性值
     *
     * @param productAttributes
     * @return
     */
    int createProductAttribute(List<ProductAttribute> productAttributes);
}
