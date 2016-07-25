package com.wow.user.mapper;

import com.wow.user.model.EndUserLikeScene;
import com.wow.user.model.EndUserLikeSceneExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EndUserLikeSceneMapper {
    int countByExample(EndUserLikeSceneExample example);

    int deleteByExample(EndUserLikeSceneExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EndUserLikeScene record);

    int insertSelective(EndUserLikeScene record);

    List<EndUserLikeScene> selectByExample(EndUserLikeSceneExample example);

    EndUserLikeScene selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EndUserLikeScene record, @Param("example") EndUserLikeSceneExample example);

    int updateByExample(@Param("record") EndUserLikeScene record, @Param("example") EndUserLikeSceneExample example);

    int updateByPrimaryKeySelective(EndUserLikeScene record);

    int updateByPrimaryKey(EndUserLikeScene record);
}