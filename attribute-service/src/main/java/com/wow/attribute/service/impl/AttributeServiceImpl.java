package com.wow.attribute.service.impl;


import com.wow.attribute.mapper.AttributeMapper;
import com.wow.attribute.model.Attribute;
import com.wow.attribute.model.AttributeGroup;
import com.wow.attribute.model.AttributeGroupAttribute;
import com.wow.attribute.model.AttributeValue;
import com.wow.attribute.service.AttributeService;
import com.wow.product.model.Product;
import com.wow.product.model.ProductAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhengzhiqing on 16/6/19.
 */
@Service
@Transactional(value = "attributeTransactionManager")
public class AttributeServiceImpl implements AttributeService {

    // Table: attribute
    @Autowired
    private AttributeMapper attributeMapper;

    /**
     * 创建属性
     *
     * @param attribute
     * @return
     */
    public int createAttribute(Attribute attribute) {
        return attributeMapper.insert(attribute);
    }

    /**
     * 更新属性
     *
     * @param attribute
     * @return
     */
    public int updateAttribute(Attribute attribute) {
        return attributeMapper.updateByPrimaryKeySelective(attribute);
    }

    /**
     * 根据ID删除属性
     * @param attributeId
     * @return
     */
    public int deleteAttributeById(int attributeId) {
        return attributeMapper.deleteByPrimaryKey(attributeId);
    }
    /**
     * 根据Id查询属性
     *
     * @param attributeId
     * @return
     */
    public Attribute getAttributeById(int attributeId) {
        System.out.println("start to get attribute, id=" + attributeId);
        Attribute attribute = attributeMapper.selectByPrimaryKey(attributeId);
        System.out.println("Attribute=" + attribute);
        if (attribute == null) {
            attribute = new Attribute();
            attribute.setId(attributeId);
            attribute.setAttributeName("mockattribute");
        }
        return attribute;

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


    //Table: attribute_group

    /**
     * 创建属性组
     *
     * @param attributeGroup
     * @return
     */
    public int createAttributeGroup(AttributeGroup attributeGroup) {
        return 1;
    }

    /**
     * 根据属性组Id查询属性组
     *
     * @param attributeGroupId
     * @return
     */
    public AttributeGroup getAttributeGroupById(int attributeGroupId) {
        return null;
    }

    /**
     * 根据属性组名查询属性组
     *
     * @param attributeGroupName
     * @return
     */
    public AttributeGroup getAttributeGroupByName(String attributeGroupName) {
        return null;
    }

    /**
     * 更新属性组
     *
     * @param attributeGroup
     * @return
     */
    public int updateAttributeGroup(AttributeGroup attributeGroup) {
        return 1;
    }

    //Table: attribute_group_attribute

    /**
     * 添加单个属性到属性组
     *
     * @param attributeGroupAttribute
     * @return
     */
    public int createAttributeGroupAttribute(AttributeGroupAttribute attributeGroupAttribute) {
        return 1;
    }

    /**
     * 添加多个属性到属性组
     *
     * @param attributeGroupId
     * @param attributeIds
     * @return
     */
    public int addAttributesIntoAttributeGroup(int attributeGroupId, int[] attributeIds) {
        return 1;
    }

    /**
     * 从属性组删除属性
     *
     * @param attributeGroupId
     * @param attributeIds
     * @return
     */
    public int removeAttributeFromAttributeGroup(int attributeGroupId, int[] attributeIds) {
        return 1;
    }

    /**
     * 查询属性组里所有属性
     *
     * @param attributeGroupId
     * @return
     */
    public List<Attribute> getAttributesByAttributeGroupId(int attributeGroupId) {
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
        return 1;
    }

    /**
     * 删除属性值
     *
     * @param attributeValue
     * @return
     */
    public int removeAttributeValue(AttributeValue attributeValue) {
        return 1;
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

//table: product_attribute

    /**
     * 查询产品的属性组
     *
     * @param product
     * @return
     */
    public AttributeGroup queryAttributeGroupByProduct(Product product) {
        return null;
    }

    /**
     * 设置产品的属性值
     *
     * @param productAttributes
     * @return
     */
    public int createProductAttribute(List<ProductAttribute> productAttributes) {
        return 1;
    }

}
