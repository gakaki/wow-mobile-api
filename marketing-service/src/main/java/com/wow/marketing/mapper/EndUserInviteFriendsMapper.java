package com.wow.marketing.mapper;

import com.wow.marketing.model.EndUserInviteFriends;
import com.wow.marketing.model.EndUserInviteFriendsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EndUserInviteFriendsMapper {
    int countByExample(EndUserInviteFriendsExample example);

    int deleteByExample(EndUserInviteFriendsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EndUserInviteFriends record);

    int insertSelective(EndUserInviteFriends record);

    List<EndUserInviteFriends> selectByExample(EndUserInviteFriendsExample example);

    EndUserInviteFriends selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EndUserInviteFriends record, @Param("example") EndUserInviteFriendsExample example);

    int updateByExample(@Param("record") EndUserInviteFriends record, @Param("example") EndUserInviteFriendsExample example);

    int updateByPrimaryKeySelective(EndUserInviteFriends record);

    int updateByPrimaryKey(EndUserInviteFriends record);
}