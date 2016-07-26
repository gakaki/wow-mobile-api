package com.wow.order.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pingplusplus.Pingpp;
import com.pingplusplus.exception.PingppException;
import com.pingplusplus.model.Charge;
import com.wow.common.util.ErrorResponseUtil;
import com.wow.common.util.MapUtil;
import com.wow.order.service.PayService;
import com.wow.order.vo.ChargeRequest;
import com.wow.order.vo.response.ChargeResponse;

/**
 * Created by zhengzhiqing on 16/7/25.
 */
@Service
@PropertySource(value = "classpath:/pingplusplus.properties")
@Transactional("orderTransactionManager")
public class PayServiceImpl implements PayService {

    @Value("${ppp.appId}")
    private String appId;

    @Value("${ppp.apiKey}")
    private String apiKey;

    @Value("${ppp.privateKeyFilePath}")
    private String privateKeyFilePath;

    /**
     * @param chargeRequest
     * @return
     */
    @Override
    public ChargeResponse getCharge(ChargeRequest chargeRequest) {

        // 设置 API Key
        Pingpp.apiKey = apiKey;

        // 设置私钥路径，用于请求签名
        Pingpp.privateKeyPath = privateKeyFilePath;

        ChargeResponse chargeResponse = new ChargeResponse();


        Map<String, Object> chargeMap = new HashMap<String, Object>();
        chargeMap.put("amount", chargeRequest.getAmount());//订单总金额, 人民币单位：分（如订单总金额为 1 元，此处请填 100）
        chargeMap.put("currency", "cny");
        chargeMap.put("subject", "来自尖叫设计的商品");
        chargeMap.put("body", "商品描述");
        chargeMap.put("order_no", chargeRequest.getOrderNo());// 推荐使用 8-20 位，要求数字或字母，不允许其他字符
        chargeMap.put("channel", chargeRequest.getChannel());// 支付使用的第三方支付渠道取值，请参考：https://www.pingxx.com/api#api-c-new
        chargeMap.put("client_ip", chargeRequest.getClientIp()); // 发起支付请求客户端的 IP 地址，格式为 IPV4，如: 127.0.0.1
        Map<String, String> app = new HashMap<String, String>();
        app.put("id", appId);
        chargeMap.put("app", app);
        if (MapUtil.isNotEmpty(chargeRequest.getExtra())) {
            chargeMap.put("extra", chargeRequest.getExtra());
        }

        try {
            //发起交易请求
            Charge charge = Charge.create(chargeMap);
            // 传到客户端请先转成字符串 .toString(), 调该方法，会自动转成正确的 JSON 字符串
            String chargeString = charge.toString();
            System.out.println(chargeString);
            chargeResponse.setCharge(charge);
        } catch (PingppException e) {
            e.printStackTrace();
            ErrorResponseUtil.setErrorResponse(chargeResponse,"40380");
        }
        return chargeResponse;
    }
}
