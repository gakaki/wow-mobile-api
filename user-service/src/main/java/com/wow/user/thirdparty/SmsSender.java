package com.wow.user.thirdparty;

//import com.taobao.api.DefaultTaobaoClient;
//import com.taobao.api.TaobaoClient;
//import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
//import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by zhengzhiqing on 16/7/4.
 */
@Configuration
@PropertySource("classpath:alidayu.properties")
public class SmsSender {

    @Value("${alidayu.appKey}")
    private String appKey;
    @Value("${alidayu.appSecret}")
    private String appSecret;
    @Value("${alidayu.serverUrl}")
    private String serverUrl;

    private static final Logger logger = LoggerFactory.getLogger(SmsSender.class);

    /**
     * 发送验证码
     * @param req
     * @return
     */
//    public String sendValidateCode(AlibabaAliqinFcSmsNumSendRequest req) {
//        TaobaoClient client = new DefaultTaobaoClient(serverUrl, appKey, appSecret);
//        AlibabaAliqinFcSmsNumSendResponse rsp;
//        String res = "";
//        try {
//            rsp = client.execute(req);
//            res = rsp.getBody();
//            logger.info(res);
//            return res;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//            return res;
//        }
//    }
}
