package com.wow.user.mapper;

import com.wow.user.model.EndUserFavoriteScene;
import com.wow.user.model.EndUserFavoriteSceneExample;
import java.util.List;

import com.wow.user.vo.FavoriteSceneVo;
import org.apache.ibatis.annotations.Param;

public interface EndUserFavoriteSceneMapper {
    int countByExample(EndUserFavoriteSceneExample example);

    int deleteByExample(EndUserFavoriteSceneExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EndUserFavoriteScene record);

    int insertSelective(EndUserFavoriteScene record);

    List<EndUserFavoriteScene> selectByExample(EndUserFavoriteSceneExample example);

    EndUserFavoriteScene selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EndUserFavoriteScene record, @Param("example") EndUserFavoriteSceneExample example);

    int updateByExample(@Param("record") EndUserFavoriteScene record, @Param("example") EndUserFavoriteSceneExample example);

    int updateByPrimaryKeySelective(EndUserFavoriteScene record);

    int updateByPrimaryKey(EndUserFavoriteScene record);

    List<FavoriteSceneVo> selectFavoriteScene(@Param("endUserId") int endUserId);
}