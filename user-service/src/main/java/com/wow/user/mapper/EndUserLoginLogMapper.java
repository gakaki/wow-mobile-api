package com.wow.user.mapper;

import com.wow.user.model.EndUserLoginLog;
import com.wow.user.model.EndUserLoginLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EndUserLoginLogMapper {
    int countByExample(EndUserLoginLogExample example);

    int deleteByExample(EndUserLoginLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EndUserLoginLog record);

    int insertSelective(EndUserLoginLog record);

    List<EndUserLoginLog> selectByExample(EndUserLoginLogExample example);

    EndUserLoginLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EndUserLoginLog record, @Param("example") EndUserLoginLogExample example);

    int updateByExample(@Param("record") EndUserLoginLog record, @Param("example") EndUserLoginLogExample example);

    int updateByPrimaryKeySelective(EndUserLoginLog record);

    int updateByPrimaryKey(EndUserLoginLog record);
}