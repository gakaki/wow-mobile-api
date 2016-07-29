package com.wow.user.mapper;

import com.wow.user.model.EndUserFavoriteBrand;
import com.wow.user.model.EndUserFavoriteBrandExample;
import java.util.List;

import com.wow.user.vo.FavoriteBrandVo;
import org.apache.ibatis.annotations.Param;

public interface EndUserFavoriteBrandMapper {
    int countByExample(EndUserFavoriteBrandExample example);

    int deleteByExample(EndUserFavoriteBrandExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EndUserFavoriteBrand record);

    int insertSelective(EndUserFavoriteBrand record);

    List<EndUserFavoriteBrand> selectByExample(EndUserFavoriteBrandExample example);

    EndUserFavoriteBrand selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EndUserFavoriteBrand record, @Param("example") EndUserFavoriteBrandExample example);

    int updateByExample(@Param("record") EndUserFavoriteBrand record, @Param("example") EndUserFavoriteBrandExample example);

    int updateByPrimaryKeySelective(EndUserFavoriteBrand record);

    int updateByPrimaryKey(EndUserFavoriteBrand record);

    List<FavoriteBrandVo> selectFavoriteBrand(@Param("endUserId") int endUserId);
}