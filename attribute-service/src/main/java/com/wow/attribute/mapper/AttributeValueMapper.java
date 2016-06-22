package com.wow.attribute.mapper;

import com.wow.attribute.model.AttributeValue;
import com.wow.attribute.model.AttributeValueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AttributeValueMapper {
    int countByExample(AttributeValueExample example);

    int deleteByExample(AttributeValueExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AttributeValue record);

    int insertSelective(AttributeValue record);

    List<AttributeValue> selectByExample(AttributeValueExample example);

    AttributeValue selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AttributeValue record, @Param("example") AttributeValueExample example);

    int updateByExample(@Param("record") AttributeValue record, @Param("example") AttributeValueExample example);

    int updateByPrimaryKeySelective(AttributeValue record);

    int updateByPrimaryKey(AttributeValue record);
}