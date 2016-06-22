package com.wow.marketing.mapper;

import com.wow.marketing.model.Invitee;
import com.wow.marketing.model.InviteeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InviteeMapper {
    int countByExample(InviteeExample example);

    int deleteByExample(InviteeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Invitee record);

    int insertSelective(Invitee record);

    List<Invitee> selectByExample(InviteeExample example);

    Invitee selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Invitee record, @Param("example") InviteeExample example);

    int updateByExample(@Param("record") Invitee record, @Param("example") InviteeExample example);

    int updateByPrimaryKeySelective(Invitee record);

    int updateByPrimaryKey(Invitee record);
}