package com.wow.marketing.service.impl;

import com.wow.marketing.mapper.InviteeMapper;
import com.wow.marketing.model.Invitee;
import com.wow.marketing.model.InviteeExample;
import com.wow.marketing.service.InviteeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by zhengzhiqing on 16/7/10.
 */
@Service
@Transactional("marketingTransactionManager")
public class InviteeServiceImpl implements InviteeService {

    @Autowired
    InviteeMapper inviteeMapper;

    /**
     * 好友接受邀请
     *
     * @param invitee
     * @return
     */
    @Override
    public int acceptInvitation(Invitee invitee) {
        return inviteeMapper.insertSelective(invitee);
    }

    /**
     * 好友接受邀请并注册成功之后更新状态
     *
     * @param mobile
     * @return
     */
    public int register(String mobile) {
        InviteeExample inviteeExample = new InviteeExample();
        InviteeExample.Criteria criteria = inviteeExample.createCriteria();
        criteria.andMobileEqualTo(mobile);
        List<Invitee> inviteeList = inviteeMapper.selectByExample(inviteeExample);

        if (inviteeList != null & inviteeList.size() > 0) {
            Invitee invitee = inviteeList.get(0);
            invitee.setIsRegistered(true);
            Date now = new Date();
            invitee.setRegisterTime(now);
            invitee.setUpdateTime(now);
            return inviteeMapper.updateByExampleSelective(invitee, inviteeExample);
        } else {
            return 0;
        }
    }
}
