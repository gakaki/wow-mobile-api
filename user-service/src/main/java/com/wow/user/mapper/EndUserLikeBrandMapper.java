package com.wow.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wow.user.model.EndUserLikeBrand;
import com.wow.user.model.EndUserLikeBrandExample;
import com.wow.user.vo.LikedBrandVo;

public interface EndUserLikeBrandMapper {
    int countByExample(EndUserLikeBrandExample example);

    int deleteByExample(EndUserLikeBrandExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EndUserLikeBrand record);

    int insertSelective(EndUserLikeBrand record);

    List<EndUserLikeBrand> selectByExample(EndUserLikeBrandExample example);

    EndUserLikeBrand selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EndUserLikeBrand record, @Param("example") EndUserLikeBrandExample example);

    int updateByExample(@Param("record") EndUserLikeBrand record, @Param("example") EndUserLikeBrandExample example);

    int updateByPrimaryKeySelective(EndUserLikeBrand record);

    int updateByPrimaryKey(EndUserLikeBrand record);

    //查询用户喜欢的品牌
    List<LikedBrandVo> selectLikedBrand(@Param("endUserId") int endUserId);
}