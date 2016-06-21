package com.wow.marketing.mapper;

import com.wow.marketing.model.Invitee;

public interface InviteeMapper {
    int insert(Invitee record);

    int insertSelective(Invitee record);

    Invitee selectByPrimaryKey(Integer id);
}