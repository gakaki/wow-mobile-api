package com.wow.marketing.service;


import com.wow.marketing.model.EndUserInviteFriends;

import java.util.List;

/**
 * Created by zhengzhiqing on 16/6/20.
 */
public interface InvitationService {

    /**
     * 用户邀请好友
     *
     * @param endUserInviteFriends
     * @return
     */
    int createInvitation(EndUserInviteFriends endUserInviteFriends);

    /**
     * 查询用户所有邀请记录
     *
     * @param endUserId
     * @return
     */
    List<EndUserInviteFriends> getUserInvitationByUserId(int endUserId);

}
