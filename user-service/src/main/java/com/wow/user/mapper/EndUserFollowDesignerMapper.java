package com.wow.user.mapper;

import com.wow.user.model.EndUserFollowDesigner;
import com.wow.user.model.EndUserFollowDesignerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EndUserFollowDesignerMapper {
    int countByExample(EndUserFollowDesignerExample example);

    int deleteByExample(EndUserFollowDesignerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EndUserFollowDesigner record);

    int insertSelective(EndUserFollowDesigner record);

    List<EndUserFollowDesigner> selectByExample(EndUserFollowDesignerExample example);

    EndUserFollowDesigner selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EndUserFollowDesigner record, @Param("example") EndUserFollowDesignerExample example);

    int updateByExample(@Param("record") EndUserFollowDesigner record, @Param("example") EndUserFollowDesignerExample example);

    int updateByPrimaryKeySelective(EndUserFollowDesigner record);

    int updateByPrimaryKey(EndUserFollowDesigner record);

    /**
     * 用户取消关注设计师
     * @param endUserId
     * @param designerId
     * @return
     */
    int cancelFollowDesigner(@Param("endUserId") int endUserId, @Param("designerId") int designerId);
}