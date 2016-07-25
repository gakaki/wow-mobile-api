package com.wow.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wow.user.model.EndUserLikeScene;
import com.wow.user.model.EndUserLikeSceneExample;
import com.wow.user.vo.LikedSceneVo;

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

    //查询用户喜欢的场景
    List<LikedSceneVo> selectLikedScene(@Param("endUserId") int endUserId);
}