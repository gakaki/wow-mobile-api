package com.wow.user.mapper;

import com.wow.user.model.EndUser;
import com.wow.user.model.EndUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EndUserMapper {

    int countByExample(EndUserExample example);

    int deleteByExample(EndUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EndUser record);

    int insertSelective(EndUser record);

    List<EndUser> selectByExample(EndUserExample example);

    EndUser selectByPrimaryKey(Integer id);

    EndUser selectByUserNameAndPassword(@Param("userName") String userName,
                                        @Param("password") String password);

    EndUser selectByUserName(@Param("userName") String userName);

    int updateByExampleSelective(@Param("record") EndUser record,
                                 @Param("example") EndUserExample example);

    int updateByExample(@Param("record") EndUser record,
                        @Param("example") EndUserExample example);

    int updateByPrimaryKeySelective(EndUser record);

    int updateByPrimaryKey(EndUser record);
}