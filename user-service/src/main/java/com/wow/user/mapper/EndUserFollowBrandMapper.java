package com.wow.user.mapper;

import com.wow.user.model.EndUserFollowBrand;
import com.wow.user.model.EndUserFollowBrandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EndUserFollowBrandMapper {
    int countByExample(EndUserFollowBrandExample example);

    int deleteByExample(EndUserFollowBrandExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EndUserFollowBrand record);

    int insertSelective(EndUserFollowBrand record);

    List<EndUserFollowBrand> selectByExample(EndUserFollowBrandExample example);

    EndUserFollowBrand selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EndUserFollowBrand record, @Param("example") EndUserFollowBrandExample example);

    int updateByExample(@Param("record") EndUserFollowBrand record, @Param("example") EndUserFollowBrandExample example);

    int updateByPrimaryKeySelective(EndUserFollowBrand record);

    int updateByPrimaryKey(EndUserFollowBrand record);

    /**
     * 用户取消关注品牌
     * @param endUserId
     * @param brandId
     * @return
     */
    int cancelFollowBrand(@Param("endUserId") int endUserId, @Param("brandId") int brandId);
}