package com.wow.product.mapper;

import com.wow.product.model.ApplicableScene;
import com.wow.product.model.ApplicableSceneExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApplicableSceneMapper {
    int countByExample(ApplicableSceneExample example);

    int deleteByExample(ApplicableSceneExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ApplicableScene record);

    int insertSelective(ApplicableScene record);

    List<ApplicableScene> selectByExample(ApplicableSceneExample example);

    ApplicableScene selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ApplicableScene record, @Param("example") ApplicableSceneExample example);

    int updateByExample(@Param("record") ApplicableScene record, @Param("example") ApplicableSceneExample example);

    int updateByPrimaryKeySelective(ApplicableScene record);

    int updateByPrimaryKey(ApplicableScene record);
}