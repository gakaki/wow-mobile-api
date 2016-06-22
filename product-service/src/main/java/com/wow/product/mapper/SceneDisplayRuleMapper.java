package com.wow.product.mapper;

import com.wow.product.model.SceneDisplayRule;
import com.wow.product.model.SceneDisplayRuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SceneDisplayRuleMapper {
    int countByExample(SceneDisplayRuleExample example);

    int deleteByExample(SceneDisplayRuleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SceneDisplayRule record);

    int insertSelective(SceneDisplayRule record);

    List<SceneDisplayRule> selectByExample(SceneDisplayRuleExample example);

    SceneDisplayRule selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SceneDisplayRule record, @Param("example") SceneDisplayRuleExample example);

    int updateByExample(@Param("record") SceneDisplayRule record, @Param("example") SceneDisplayRuleExample example);

    int updateByPrimaryKeySelective(SceneDisplayRule record);

    int updateByPrimaryKey(SceneDisplayRule record);
}