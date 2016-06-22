package com.wow.product.mapper;

import com.wow.product.model.TopicProductDisplayRule;
import com.wow.product.model.TopicProductDisplayRuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TopicProductDisplayRuleMapper {
    int countByExample(TopicProductDisplayRuleExample example);

    int deleteByExample(TopicProductDisplayRuleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TopicProductDisplayRule record);

    int insertSelective(TopicProductDisplayRule record);

    List<TopicProductDisplayRule> selectByExample(TopicProductDisplayRuleExample example);

    TopicProductDisplayRule selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TopicProductDisplayRule record, @Param("example") TopicProductDisplayRuleExample example);

    int updateByExample(@Param("record") TopicProductDisplayRule record, @Param("example") TopicProductDisplayRuleExample example);

    int updateByPrimaryKeySelective(TopicProductDisplayRule record);

    int updateByPrimaryKey(TopicProductDisplayRule record);
}