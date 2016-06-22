package com.wow.attribute.mapper;

import com.wow.attribute.model.AttributeGroupAttribute;
import com.wow.attribute.model.AttributeGroupAttributeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AttributeGroupAttributeMapper {
    int countByExample(AttributeGroupAttributeExample example);

    int deleteByExample(AttributeGroupAttributeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AttributeGroupAttribute record);

    int insertSelective(AttributeGroupAttribute record);

    List<AttributeGroupAttribute> selectByExample(AttributeGroupAttributeExample example);

    AttributeGroupAttribute selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AttributeGroupAttribute record, @Param("example") AttributeGroupAttributeExample example);

    int updateByExample(@Param("record") AttributeGroupAttribute record, @Param("example") AttributeGroupAttributeExample example);

    int updateByPrimaryKeySelective(AttributeGroupAttribute record);

    int updateByPrimaryKey(AttributeGroupAttribute record);
}