package com.wow.user.mapper;

import com.wow.user.model.EndUserFollowProduct;
import com.wow.user.model.EndUserFollowProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EndUserFollowProductMapper {
    int countByExample(EndUserFollowProductExample example);

    int deleteByExample(EndUserFollowProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EndUserFollowProduct record);

    int insertSelective(EndUserFollowProduct record);

    List<EndUserFollowProduct> selectByExample(EndUserFollowProductExample example);

    EndUserFollowProduct selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EndUserFollowProduct record, @Param("example") EndUserFollowProductExample example);

    int updateByExample(@Param("record") EndUserFollowProduct record, @Param("example") EndUserFollowProductExample example);

    int updateByPrimaryKeySelective(EndUserFollowProduct record);

    int updateByPrimaryKey(EndUserFollowProduct record);
}