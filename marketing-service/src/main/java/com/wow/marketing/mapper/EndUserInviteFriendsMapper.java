package com.wow.marketing.mapper;

import com.wow.marketing.model.EndUserInviteFriends;

public interface EndUserInviteFriendsMapper {
    int insert(EndUserInviteFriends record);

    int insertSelective(EndUserInviteFriends record);

    EndUserInviteFriends selectByPrimaryKey(Integer id);
}