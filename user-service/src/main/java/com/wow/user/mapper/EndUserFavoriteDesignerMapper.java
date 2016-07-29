package com.wow.user.mapper;

import com.wow.user.model.EndUserFavoriteDesigner;
import com.wow.user.model.EndUserFavoriteDesignerExample;
import java.util.List;

import com.wow.user.vo.FavoriteDesignerVo;
import org.apache.ibatis.annotations.Param;

public interface EndUserFavoriteDesignerMapper {
    int countByExample(EndUserFavoriteDesignerExample example);

    int deleteByExample(EndUserFavoriteDesignerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EndUserFavoriteDesigner record);

    int insertSelective(EndUserFavoriteDesigner record);

    List<EndUserFavoriteDesigner> selectByExample(EndUserFavoriteDesignerExample example);

    EndUserFavoriteDesigner selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EndUserFavoriteDesigner record, @Param("example") EndUserFavoriteDesignerExample example);

    int updateByExample(@Param("record") EndUserFavoriteDesigner record, @Param("example") EndUserFavoriteDesignerExample example);

    int updateByPrimaryKeySelective(EndUserFavoriteDesigner record);

    int updateByPrimaryKey(EndUserFavoriteDesigner record);

    List<FavoriteDesignerVo> selectFavoriteDesigner(@Param("endUserId") int endUserId);
}