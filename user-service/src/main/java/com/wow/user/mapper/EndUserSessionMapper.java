package com.wow.user.mapper;

import com.wow.user.model.EndUserSession;
import com.wow.user.model.EndUserSessionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EndUserSessionMapper {
    int countByExample(EndUserSessionExample example);

    int deleteByExample(EndUserSessionExample example);

    int deleteByPrimaryKey(@Param("id") Integer id, @Param("endUserId") Integer endUserId, @Param("loginChannel") Byte loginChannel);

    int insert(EndUserSession record);

    int insertSelective(EndUserSession record);

    List<EndUserSession> selectByExample(EndUserSessionExample example);

    EndUserSession selectByPrimaryKey(@Param("id") Integer id, @Param("endUserId") Integer endUserId, @Param("loginChannel") Byte loginChannel);

    int updateByExampleSelective(@Param("record") EndUserSession record, @Param("example") EndUserSessionExample example);

    int updateByExample(@Param("record") EndUserSession record, @Param("example") EndUserSessionExample example);

    int updateByPrimaryKeySelective(EndUserSession record);

    int updateByPrimaryKey(EndUserSession record);
}