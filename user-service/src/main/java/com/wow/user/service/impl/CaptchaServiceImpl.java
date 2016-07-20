package com.wow.user.service.impl;

import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.wow.common.response.CommonResponse;
import com.wow.common.util.RandomGenerator;
import com.wow.common.util.RedisUtil;
import com.wow.user.constant.SmsTemplate;
import com.wow.user.service.CaptchaService;
import com.wow.user.thirdparty.SmsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhengzhiqing on 16/7/17.
 */
@Service
public class CaptchaServiceImpl implements CaptchaService {

    @Autowired
    private SmsSender smsSender;

    /**
     * 请求并发送验证码
     * 注册,修改密码或者多次输入错误的情况下使用
     *
     * @param mobile
     * @return 验证码
     */
    public CommonResponse sendCaptcha(String mobile, int templateType, long expirationTime) {

        CommonResponse commonResponse = new CommonResponse();

        //1. generate 6-bit digit
        String randomNum = RandomGenerator.createRandom(true,6);

        //2. call alidayu interface to send sms
        AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
        //公共回传参数，在“消息返回”中会透传回该参数；举例：用户可以传入自己下级的会员ID，
        // 在消息返回时，该会员ID会包含在内，用户可以根据该会员ID识别是哪位会员使用了你的应用
        req.setExtend( "13764641531 uid " );
        //短信类型，传入值请填写normal
        req.setSmsType("normal");
        //短信签名，传入的短信签名必须是在阿里大鱼“管理中心-短信签名管理”中的可用签名。如“阿里大鱼”已在短信签名管理中通过审核，
        //则可传入”阿里大鱼“（传参时去掉引号）作为短信签名。短信效果示例：【阿里大鱼】欢迎使用阿里大鱼服务。
        req.setSmsFreeSignName("尖叫设计");
        //短信模板变量，传参规则{"key":"value"}，key的名字须和申请模板中的变量名一致，多个变量之间以逗号隔开。
        // 示例：针对模板“验证码${code}，您正在进行${product}身份验证，打死不要告诉别人哦！”，
        // 传参时需传入{"code":"1234","product":"alidayu"}
        req.setSmsParamString("{'code':'" + randomNum + "','product':'尖叫设计'}");
        //短信接收号码。支持单个或多个手机号码，传入号码为11位手机号码，不能加0或+86。
        // 群发短信需传入多个号码，以英文逗号分隔，一次调用最多传入200个号码。
        // 示例：18600000000,13911111111,13322222222
        req.setRecNum(mobile);
        //短信模板ID，传入的模板必须是在阿里大鱼“管理中心-短信模板管理”中的可用模板。示例：SMS_585014
        req.setSmsTemplateCode(SmsTemplate.getTemplateByType(templateType));
        smsSender.sendValidateCode(req);

        //3. cache digit into redis
        //TODO: 是否所有验证码的过期时间一样,还是需要配置?
        RedisUtil.set(mobile,randomNum,expirationTime);

        return commonResponse;
    }
}
