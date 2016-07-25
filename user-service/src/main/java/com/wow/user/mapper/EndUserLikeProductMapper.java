package com.wow.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wow.user.model.EndUserLikeProduct;
import com.wow.user.model.EndUserLikeProductExample;
import com.wow.user.vo.LikedProductVo;

public interface EndUserLikeProductMapper {
    int countByExample(EndUserLikeProductExample example);

    int deleteByExample(EndUserLikeProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EndUserLikeProduct record);

    int insertSelective(EndUserLikeProduct record);

    List<EndUserLikeProduct> selectByExample(EndUserLikeProductExample example);

    EndUserLikeProduct selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EndUserLikeProduct record, @Param("example") EndUserLikeProductExample example);

    int updateByExample(@Param("record") EndUserLikeProduct record, @Param("example") EndUserLikeProductExample example);

    int updateByPrimaryKeySelective(EndUserLikeProduct record);

    int updateByPrimaryKey(EndUserLikeProduct record);

    //查询用户喜欢的产品
    List<LikedProductVo> selectLikedProduct(@Param("endUserId") int endUserId);
}