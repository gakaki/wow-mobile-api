package com.wow.user;

import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import com.wow.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class UserApplication {

    private static final Logger logger = LoggerFactory.getLogger(UserApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/users/helloworld", method = RequestMethod.GET)
    public String helloworld() {
        return "helloworld";
    }
    /**
     * 用户发送短信
     * @return
     */
    @RequestMapping(value = "/users/testAlidayu", method = RequestMethod.GET)
    public String sendValidateCode() {
        logger.info("/users/testAlidayu");

        String alidayu_appkey = "23322565";
        String alidayu_secret = "af23953c58570b997909ae6f1e013ef3";

        TaobaoClient client = new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest", alidayu_appkey, alidayu_secret);
        AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
        req.setExtend( "13621822254 uid " );//公共回传参数，在“消息返回”中会透传回该参数；举例：用户可以传入自己下级的会员ID，在消息返回时，该会员ID会包含在内，用户可以根据该会员ID识别是哪位会员使用了你的应用
        req.setSmsType("normal");//短信类型，传入值请填写normal
        req.setSmsFreeSignName("尖叫设计");//   短信签名，传入的短信签名必须是在阿里大鱼“管理中心-短信签名管理”中的可用签名。如“阿里大鱼”已在短信签名管理中通过审核，则可传入”阿里大鱼“（传参时去掉引号）作为短信签名。短信效果示例：【阿里大鱼】欢迎使用阿里大鱼服务。
        req.setSmsParamString("{'code':'发送的验证码','product':'尖叫设计'}");//短信模板变量，传参规则{"key":"value"}，key的名字须和申请模板中的变量名一致，多个变量之间以逗号隔开。示例：针对模板“验证码${code}，您正在进行${product}身份验证，打死不要告诉别人哦！”，传参时需传入{"code":"1234","product":"alidayu"}
        req.setRecNum("13621822254");//短信接收号码。支持单个或多个手机号码，传入号码为11位手机号码，不能加0或+86。群发短信需传入多个号码，以英文逗号分隔，一次调用最多传入200个号码。示例：18600000000,13911111111,13322222222
        req.setSmsTemplateCode("SMS_5165048");//短信模板ID，传入的模板必须是在阿里大鱼“管理中心-短信模板管理”中的可用模板。示例：SMS_585014
        AlibabaAliqinFcSmsNumSendResponse rsp;

        String res = "";
        try {
            rsp = client.execute(req);
            res = rsp.getBody();
            System.out.println( res );
            return res;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return res;
        }

    }
}

