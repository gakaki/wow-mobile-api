package com.wow.marketing.service;

import com.wow.marketing.model.Invitee;

/**
 * Created by zhengzhiqing on 16/7/10.
 */
public interface InviteeService {

    /**
     * 好友接受邀请
     * @param invitee
     * @return
     */
    int acceptInvitation(Invitee invitee);

    /**
     * 好友接受邀请之后注册
     * @param mobile
     * @return
     */
    int register(String mobile);
}
