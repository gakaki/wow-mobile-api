package com.wow.marketing.message.consumer;

import com.wow.marketing.service.InviteeService;
import com.wow.user.model.EndUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zhengzhiqing on 16/7/9.
 */
@Configuration
public class UserRegisterListener {

    @Autowired
    private InviteeService inviteeService;

    //如果该用户是通过好友推荐进来注册的,需要更新推荐相关信息,通过消息通知营销系统,否则要双向依赖
    public void messageContainer(EndUser endUser) {
        inviteeService.register(endUser.getMobile());
    }
}
