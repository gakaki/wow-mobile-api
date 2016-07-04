package com.wow.user.controller;

import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.wow.user.model.EndUser;
import com.wow.user.service.UserService;
import com.wow.user.thirdparty.SmsSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by zhengzhiqing on 16/7/1.
 */
@RestController
public class UserTestController {

    private static final Logger logger = LoggerFactory.getLogger(UserTestController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private SmsSender smsSender;

    /**
     * 用户注册
     * @param endUser
     * @return
     */
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String register(@Validated @RequestBody EndUser endUser) {
        String registerResult = "";
        //先根据用户名查找是否已经注册过
        if (userService.isExistedUser(endUser.getUserName())) {
            logger.info("existed user try to register...");
            registerResult = "您已经注册过,请直接登录";
        } else {
            logger.info("user register...");
            endUser.setIsDeleted(false);
            endUser.setRegisterTime(new Date());
            int i = userService.register(endUser);
            if (i > 0) {
                registerResult = "注册成功,请登录";
            } else {
                registerResult = "注册失败,请重试";
            }
        }
        return registerResult;
    }

    /**
     * 查询用户
     * @param endUserId
     * @return
     */
    @RequestMapping(value = "/users/{endUserId}", method = RequestMethod.GET)
    public EndUser selectUserById(@PathVariable Integer endUserId) {
        logger.info("getUser:" + endUserId);
        EndUser endUser = userService.getEndUserById(endUserId);
        logger.info("endUser=" + endUser);
        return endUser;
    }

    /**
     * 用户发送短信
     * @return
     */
    @RequestMapping(value = "/users/captcha", method = RequestMethod.POST)
    public String sendValidateCode(@RequestBody AlibabaAliqinFcSmsNumSendRequest req) {
//        req.setExtend( "13764641531 uid " );//公共回传参数，在“消息返回”中会透传回该参数；举例：用户可以传入自己下级的会员ID，在消息返回时，该会员ID会包含在内，用户可以根据该会员ID识别是哪位会员使用了你的应用
//        req.setSmsType("normal");//短信类型，传入值请填写normal
//        req.setSmsFreeSignName("尖叫设计");//   短信签名，传入的短信签名必须是在阿里大鱼“管理中心-短信签名管理”中的可用签名。如“阿里大鱼”已在短信签名管理中通过审核，则可传入”阿里大鱼“（传参时去掉引号）作为短信签名。短信效果示例：【阿里大鱼】欢迎使用阿里大鱼服务。
//        req.setSmsParamString("{'code':'743621','product':'尖叫设计'}");//短信模板变量，传参规则{"key":"value"}，key的名字须和申请模板中的变量名一致，多个变量之间以逗号隔开。示例：针对模板“验证码${code}，您正在进行${product}身份验证，打死不要告诉别人哦！”，传参时需传入{"code":"1234","product":"alidayu"}
//        req.setRecNum("13764641531");//短信接收号码。支持单个或多个手机号码，传入号码为11位手机号码，不能加0或+86。群发短信需传入多个号码，以英文逗号分隔，一次调用最多传入200个号码。示例：18600000000,13911111111,13322222222
//        req.setSmsTemplateCode("SMS_5165048");//短信模板ID，传入的模板必须是在阿里大鱼“管理中心-短信模板管理”中的可用模板。示例：SMS_585014
        return smsSender.sendValidateCode(req);
    }

}
