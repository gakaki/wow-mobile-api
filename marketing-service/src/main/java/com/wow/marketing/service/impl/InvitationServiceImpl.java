package com.wow.marketing.service.impl;


import com.wow.marketing.model.EndUserInviteFriends;
import com.wow.marketing.service.InvitationService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengzhiqing on 16/6/20.
 */
@Service
public class InvitationServiceImpl implements InvitationService {

//table: end_user_invite_friends

    /**
     * 用户邀请好友
     *
     * @param endUserInviteFriends
     * @return
     */
    public int createInvitation(EndUserInviteFriends endUserInviteFriends) {
        return 1;
    }

    /**
     * 查询某用户邀请好友的列表
     *
     * @param endUserId
     * @return
     */
    public List<EndUserInviteFriends> getUserInvitationByUserId(int endUserId) {
        return new ArrayList<EndUserInviteFriends>();
    }

}
