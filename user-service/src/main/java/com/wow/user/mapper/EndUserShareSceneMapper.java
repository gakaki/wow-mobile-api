package com.wow.user.mapper;

import com.wow.user.model.EndUserShareScene;
import com.wow.user.model.EndUserShareSceneExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EndUserShareSceneMapper {
    int countByExample(EndUserShareSceneExample example);

    int deleteByExample(EndUserShareSceneExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EndUserShareScene record);

    int insertSelective(EndUserShareScene record);

    List<EndUserShareScene> selectByExample(EndUserShareSceneExample example);

    EndUserShareScene selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EndUserShareScene record, @Param("example") EndUserShareSceneExample example);

    int updateByExample(@Param("record") EndUserShareScene record, @Param("example") EndUserShareSceneExample example);

    int updateByPrimaryKeySelective(EndUserShareScene record);

    int updateByPrimaryKey(EndUserShareScene record);
}