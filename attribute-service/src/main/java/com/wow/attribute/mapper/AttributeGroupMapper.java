package com.wow.attribute.mapper;

import com.wow.attribute.model.AttributeGroup;
import com.wow.attribute.model.AttributeGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AttributeGroupMapper {
    int countByExample(AttributeGroupExample example);

    int deleteByExample(AttributeGroupExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AttributeGroup record);

    int insertSelective(AttributeGroup record);

    List<AttributeGroup> selectByExample(AttributeGroupExample example);

    AttributeGroup selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AttributeGroup record, @Param("example") AttributeGroupExample example);

    int updateByExample(@Param("record") AttributeGroup record, @Param("example") AttributeGroupExample example);

    int updateByPrimaryKeySelective(AttributeGroup record);

    int updateByPrimaryKey(AttributeGroup record);
}