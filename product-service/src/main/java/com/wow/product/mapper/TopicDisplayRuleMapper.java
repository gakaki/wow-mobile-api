package com.wow.product.mapper;

import com.wow.product.model.TopicDisplayRule;
import com.wow.product.model.TopicDisplayRuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TopicDisplayRuleMapper {
    int countByExample(TopicDisplayRuleExample example);

    int deleteByExample(TopicDisplayRuleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TopicDisplayRule record);

    int insertSelective(TopicDisplayRule record);

    List<TopicDisplayRule> selectByExample(TopicDisplayRuleExample example);

    TopicDisplayRule selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TopicDisplayRule record, @Param("example") TopicDisplayRuleExample example);

    int updateByExample(@Param("record") TopicDisplayRule record, @Param("example") TopicDisplayRuleExample example);

    int updateByPrimaryKeySelective(TopicDisplayRule record);

    int updateByPrimaryKey(TopicDisplayRule record);
}