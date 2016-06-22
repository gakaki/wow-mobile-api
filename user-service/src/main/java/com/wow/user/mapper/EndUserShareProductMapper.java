package com.wow.user.mapper;

import com.wow.user.model.EndUserShareProduct;
import com.wow.user.model.EndUserShareProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EndUserShareProductMapper {
    int countByExample(EndUserShareProductExample example);

    int deleteByExample(EndUserShareProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EndUserShareProduct record);

    int insertSelective(EndUserShareProduct record);

    List<EndUserShareProduct> selectByExample(EndUserShareProductExample example);

    EndUserShareProduct selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EndUserShareProduct record, @Param("example") EndUserShareProductExample example);

    int updateByExample(@Param("record") EndUserShareProduct record, @Param("example") EndUserShareProductExample example);

    int updateByPrimaryKeySelective(EndUserShareProduct record);

    int updateByPrimaryKey(EndUserShareProduct record);
}