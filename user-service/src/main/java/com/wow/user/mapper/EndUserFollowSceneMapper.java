package com.wow.user.mapper;

import com.wow.user.model.EndUserFollowScene;
import com.wow.user.model.EndUserFollowSceneExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EndUserFollowSceneMapper {
    int countByExample(EndUserFollowSceneExample example);

    int deleteByExample(EndUserFollowSceneExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EndUserFollowScene record);

    int insertSelective(EndUserFollowScene record);

    List<EndUserFollowScene> selectByExample(EndUserFollowSceneExample example);

    EndUserFollowScene selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EndUserFollowScene record, @Param("example") EndUserFollowSceneExample example);

    int updateByExample(@Param("record") EndUserFollowScene record, @Param("example") EndUserFollowSceneExample example);

    int updateByPrimaryKeySelective(EndUserFollowScene record);

    int updateByPrimaryKey(EndUserFollowScene record);

    /**
     * 用户取消关注场景
     * @param endUserId
     * @param sceneId
     * @return
     */
    int cancelFollowScene(@Param("endUserId") int endUserId, @Param("sceneId") int sceneId);
}