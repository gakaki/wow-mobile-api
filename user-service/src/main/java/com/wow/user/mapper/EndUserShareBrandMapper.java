package com.wow.user.mapper;

import com.wow.user.model.EndUserShareBrand;
import com.wow.user.model.EndUserShareBrandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EndUserShareBrandMapper {
    int countByExample(EndUserShareBrandExample example);

    int deleteByExample(EndUserShareBrandExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EndUserShareBrand record);

    int insertSelective(EndUserShareBrand record);

    List<EndUserShareBrand> selectByExample(EndUserShareBrandExample example);

    EndUserShareBrand selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EndUserShareBrand record, @Param("example") EndUserShareBrandExample example);

    int updateByExample(@Param("record") EndUserShareBrand record, @Param("example") EndUserShareBrandExample example);

    int updateByPrimaryKeySelective(EndUserShareBrand record);

    int updateByPrimaryKey(EndUserShareBrand record);
}