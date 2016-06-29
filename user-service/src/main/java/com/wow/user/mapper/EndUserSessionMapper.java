package com.wow.user.mapper;

import com.wow.user.model.EndUserSession;
import com.wow.user.model.EndUserSessionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EndUserSessionMapper {
    int countByExample(EndUserSessionExample example);

    int deleteByExample(EndUserSessionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EndUserSession record);

    int insertSelective(EndUserSession record);

    List<EndUserSession> selectByExample(EndUserSessionExample example);

    EndUserSession selectByPrimaryKey(Integer id);

    EndUserSession selectByUserId(@Param("userId") int userId);
    EndUserSession selectByUserIdChannel(@Param("userId") int userId, @Param("loginChannel") byte loginChannel);

    int updateByExampleSelective(@Param("record") EndUserSession record, @Param("example") EndUserSessionExample example);

    int updateByExample(@Param("record") EndUserSession record, @Param("example") EndUserSessionExample example);

    int updateByPrimaryKeySelective(EndUserSession record);

    int updateByPrimaryKey(EndUserSession record);
}