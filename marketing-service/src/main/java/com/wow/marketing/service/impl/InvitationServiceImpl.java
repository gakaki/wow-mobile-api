package com.wow.marketing.service.impl;


import com.wow.marketing.mapper.EndUserInviteFriendsMapper;
import com.wow.marketing.model.EndUserInviteFriends;
import com.wow.marketing.model.EndUserInviteFriendsExample;
import com.wow.marketing.service.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhengzhiqing on 16/6/20.
 */
@Service
@Transactional("marketingTransactionManager")
public class InvitationServiceImpl implements InvitationService {

    @Autowired
    EndUserInviteFriendsMapper endUserInviteFriendsMapper;

    /**
     * 用户邀请好友
     *
     * @param endUserInviteFriends
     * @return
     */
    public int createInvitation(EndUserInviteFriends endUserInviteFriends) {
        return endUserInviteFriendsMapper.insertSelective(endUserInviteFriends);
    }

    /**
     * 查询用户所有邀请记录
     *
     * @param endUserId
     * @return
     */
    @Transactional(propagation= Propagation.SUPPORTS)
    public List<EndUserInviteFriends> getUserInvitationByUserId(int endUserId) {
        EndUserInviteFriendsExample endUserInviteFriendsExample = new EndUserInviteFriendsExample();
        EndUserInviteFriendsExample.Criteria criteria = endUserInviteFriendsExample.createCriteria();
        criteria.andEndUserIdEqualTo(endUserId);
        return endUserInviteFriendsMapper.selectByExample(endUserInviteFriendsExample);
    }

}
