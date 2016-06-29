package com.wow.user.mapper;

import com.wow.user.model.EndUserSession;
import com.wow.user.model.EndUserSessionExample;

import java.util.Date;
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

    EndUserSession selectByUserId(@Param("endUserId") int endUserId,
                                  @Param("loginChannel") byte loginChannel);

    EndUserSession selectByUserIdChannel(@Param("endUserId") int endUserId,
                                         @Param("loginChannel") byte loginChannel);

    int updateByExampleSelective(@Param("record") EndUserSession record, @Param("example") EndUserSessionExample example);

    int updateByExample(@Param("record") EndUserSession record, @Param("example") EndUserSessionExample example);

    int updateByPrimaryKeySelective(EndUserSession record);

    int updateByPrimaryKey(EndUserSession record);

    EndUserSession selectValidSession(@Param("sessionToken") String sessionToken,
                                      @Param("loginChannel") byte loginChannel,
                                      @Param("mustRefreshAfter") Date mustRefreshAfter);

    int updateRefreshTime(@Param("endUserId") int endUserId, @Param("loginChannel") byte loginChannel);

    int updateLogout(@Param("endUserId") int endUserId, @Param("loginChannel") byte loginChannel);
}