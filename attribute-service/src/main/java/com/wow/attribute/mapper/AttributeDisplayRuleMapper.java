package com.wow.attribute.mapper;

import com.wow.attribute.model.AttributeDisplayRule;
import com.wow.attribute.model.AttributeDisplayRuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AttributeDisplayRuleMapper {
    int countByExample(AttributeDisplayRuleExample example);

    int deleteByExample(AttributeDisplayRuleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AttributeDisplayRule record);

    int insertSelective(AttributeDisplayRule record);

    List<AttributeDisplayRule> selectByExample(AttributeDisplayRuleExample example);

    AttributeDisplayRule selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AttributeDisplayRule record, @Param("example") AttributeDisplayRuleExample example);

    int updateByExample(@Param("record") AttributeDisplayRule record, @Param("example") AttributeDisplayRuleExample example);

    int updateByPrimaryKeySelective(AttributeDisplayRule record);

    int updateByPrimaryKey(AttributeDisplayRule record);
}