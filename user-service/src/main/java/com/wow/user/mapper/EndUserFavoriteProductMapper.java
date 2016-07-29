package com.wow.user.mapper;

import com.wow.user.model.EndUserFavoriteProduct;
import com.wow.user.model.EndUserFavoriteProductExample;
import java.util.List;

import com.wow.user.vo.FavoriteProductVo;
import org.apache.ibatis.annotations.Param;

public interface EndUserFavoriteProductMapper {
    int countByExample(EndUserFavoriteProductExample example);

    int deleteByExample(EndUserFavoriteProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EndUserFavoriteProduct record);

    int insertSelective(EndUserFavoriteProduct record);

    List<EndUserFavoriteProduct> selectByExample(EndUserFavoriteProductExample example);

    EndUserFavoriteProduct selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EndUserFavoriteProduct record, @Param("example") EndUserFavoriteProductExample example);

    int updateByExample(@Param("record") EndUserFavoriteProduct record, @Param("example") EndUserFavoriteProductExample example);

    int updateByPrimaryKeySelective(EndUserFavoriteProduct record);

    int updateByPrimaryKey(EndUserFavoriteProduct record);

    List<FavoriteProductVo> selectFavoriteProduct(@Param("endUserId") int endUserId);
}