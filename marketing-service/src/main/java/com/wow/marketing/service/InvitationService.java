package com.wow.marketing.service;


import com.wow.marketing.model.EndUserInviteFriends;

import java.util.List;

/**
 * Created by zhengzhiqing on 16/6/20.
 */
public interface InvitationService {

//table: end_user_invite_friends

    /**
     * 用户邀请好友
     *
     * @param endUserInviteFriends
     * @return
     */
    int createInvitation(EndUserInviteFriends endUserInviteFriends);

    /**
     * 查询某用户邀请好友的列表
     *
     * @param endUserId
     * @return
     */
    List<EndUserInviteFriends> getUserInvitationByUserId(int endUserId);

}
