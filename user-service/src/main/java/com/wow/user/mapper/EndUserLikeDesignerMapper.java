package com.wow.user.mapper;

import com.wow.user.model.EndUserLikeDesigner;
import com.wow.user.model.EndUserLikeDesignerExample;
import java.util.List;

import com.wow.user.vo.LikedBrandVo;
import com.wow.user.vo.LikedDesignerVo;
import org.apache.ibatis.annotations.Param;

public interface EndUserLikeDesignerMapper {
    int countByExample(EndUserLikeDesignerExample example);

    int deleteByExample(EndUserLikeDesignerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EndUserLikeDesigner record);

    int insertSelective(EndUserLikeDesigner record);

    List<EndUserLikeDesigner> selectByExample(EndUserLikeDesignerExample example);

    EndUserLikeDesigner selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EndUserLikeDesigner record, @Param("example") EndUserLikeDesignerExample example);

    int updateByExample(@Param("record") EndUserLikeDesigner record, @Param("example") EndUserLikeDesignerExample example);

    int updateByPrimaryKeySelective(EndUserLikeDesigner record);

    int updateByPrimaryKey(EndUserLikeDesigner record);

    //查询用户喜欢的设计师
    List<LikedDesignerVo> selectLikedDesigner(@Param("endUserId") int endUserId);
}