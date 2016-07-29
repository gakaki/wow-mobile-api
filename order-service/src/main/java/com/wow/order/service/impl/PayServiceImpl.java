package com.wow.order.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pingplusplus.Pingpp;
import com.pingplusplus.exception.PingppException;
import com.pingplusplus.model.Charge;
import com.pingplusplus.model.Event;
import com.pingplusplus.model.EventData;
import com.pingplusplus.model.Webhooks;
import com.wow.common.constant.CommonConstant;
import com.wow.common.enums.SaleOrderStatusEnum;
import com.wow.common.response.CommonResponse;
import com.wow.common.util.DateUtil;
import com.wow.common.util.ErrorCodeUtil;
import com.wow.common.util.ErrorResponseUtil;
import com.wow.common.util.NumberUtil;
import com.wow.common.util.StringUtil;
import com.wow.order.mapper.SaleOrderLogMapper;
import com.wow.order.mapper.SaleOrderMapper;
import com.wow.order.mapper.SaleOrderPayMapper;
import com.wow.order.model.SaleOrder;
import com.wow.order.model.SaleOrderExample;
import com.wow.order.model.SaleOrderLog;
import com.wow.order.model.SaleOrderPay;
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

    @Autowired
    private SaleOrderMapper saleOrderMapper;

    @Autowired
    private SaleOrderPayMapper saleOrderPayMapper;

    @Autowired
    private SaleOrderLogMapper saleOrderLogMapper;

    /**
     * 初始化ping++支付key
     */
    @PostConstruct
    public void initPingppKey() {
        // 设置 API Key
        Pingpp.apiKey = apiKey;
        // 设置私钥路径，用于请求签名
        Pingpp.privateKeyPath = privateKeyFilePath;
    }

    /**
     * @param chargeRequest
     * @return
     */
    @Override
    public ChargeResponse getCharge(ChargeRequest chargeRequest) {
        ChargeResponse chargeResponse = new ChargeResponse();

        /*** 业务校验开始*/
        //如果客户端请求ip为空  则返回错误提示
        if (StringUtil.isEmpty(chargeRequest.getClientIp())) {
            chargeResponse.setResCode("40315");
            chargeResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40315"));

            return chargeResponse;
        }

        //如果订单号为空  则返回错误提示
        if (StringUtil.isEmpty(chargeRequest.getOrderNo())) {
            chargeResponse.setResCode("40307");
            chargeResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40307"));

            return chargeResponse;
        }

        SaleOrder saleOrder = selectByOrderCode(chargeRequest.getOrderNo());

        //如果订单号不存在 则返回错误提示
        if (saleOrder == null) {
            chargeResponse.setResCode("40308");
            chargeResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40308"));

            return chargeResponse;
        }

        //如果订单状态为已取消 则无法支付
        if (saleOrder.getOrderStatus().intValue() == SaleOrderStatusEnum.CANCELLED.getKey().intValue()) {
            chargeResponse.setResCode("40309");
            chargeResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40309"));

            return chargeResponse;
        }

        //如果订单状态为交易已关闭  则无法支付
        if (saleOrder.getOrderStatus().intValue() == SaleOrderStatusEnum.CLOSED.getKey().intValue()) {
            chargeResponse.setResCode("40321");
            chargeResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40321"));

            return chargeResponse;
        }

        //如果订单支付状态为已支付  则无法支付
        if (saleOrder.getPaymentStatus().byteValue() == CommonConstant.PAID.byteValue()) {
            chargeResponse.setResCode("40320");
            chargeResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40320"));

            return chargeResponse;
        }

        Map<String, Object> chargeMap = new HashMap<String, Object>();

        //订单总金额, 人民币单位：分（如订单总金额为 1 元，此处请填 100）
        chargeMap.put("amount", NumberUtil.convertToFen(saleOrder.getOrderAmount()));
        chargeMap.put("currency", "cny");//货币类型固定为人民币
        chargeMap.put("subject", "来自尖叫设计的商品");
        chargeMap.put("body", "尖叫订单支付");
        // 推荐使用 8-20 位，要求数字或字母，不允许其他字符
        chargeMap.put("order_no", chargeRequest.getOrderNo());
        // 支付使用的第三方支付渠道取值，具体取值请见数据字典
        chargeMap.put("channel", chargeRequest.getChannel());
        // 发起支付请求客户端的 IP 地址，格式为 IPV4，如: 127.0.0.1
        chargeMap.put("client_ip", chargeRequest.getClientIp());
        Map<String, String> app = new HashMap<String, String>(1);
        app.put("id", appId);
        chargeMap.put("app", app);

        try {
            //发起交易请求
            Charge charge = Charge.create(chargeMap);
            // 传到客户端请先转成字符串 .toString(), 调该方法，会自动转成正确的 JSON 字符串
            chargeResponse.setCharge(charge.toString());
        } catch (PingppException e) {
            ErrorResponseUtil.setErrorResponse(chargeResponse, "40361");
        }

        return chargeResponse;
    }

    /**
     * 
     * 
     * @param signature
     * @param content
     */
    @Override
    public CommonResponse webhooks(String content, String signature) {
        CommonResponse commonResponse = new CommonResponse();

        /*** 业务校验开始*/
        // 验证通知签名 
        //        boolean isVerify = WebhooksVerifyUtil.verifyData(content, signature);
        //
        //        //如果验证签名错误  则直接返回
        //        if (!isVerify) {
        //            commonResponse.setResCode("40318");
        //            commonResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40318"));
        //
        //            return commonResponse;
        //        }

        // 解析异步通知数据
        Event event = Webhooks.eventParse(content);
        //如果不是支付成功的事件通知 则直接返回错误
        if (!"charge.succeeded".equals(event.getType())) {
            commonResponse.setResCode("40319");
            commonResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40319"));

            return commonResponse;
        }

        //获取具体的支付信息
        EventData eventData = event.getData();
        Charge charge = null;
        if (!(eventData.getObject() instanceof Charge)) {
            commonResponse.setResCode("40319");
            commonResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40319"));

            return commonResponse;
        }

        charge = (Charge) eventData.getObject();
        //根据订单号获取订单信息
        SaleOrder saleOrder = selectByOrderCode(charge.getOrderNo());
        //如果订单不存在 则直接返回不处理
        if (saleOrder == null) {
            commonResponse.setResCode("40308");
            commonResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40308"));

            return commonResponse;
        }

        //如果订单已支付 则直接返回不处理
        if (saleOrder.getPaymentStatus().byteValue() == CommonConstant.YES.byteValue()) {
            commonResponse.setResCode("40320");
            commonResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40320"));

            return commonResponse;
        }

        /*** 业务处理开始*/
        SaleOrder targetSaleOrder = new SaleOrder();
        targetSaleOrder.setId(saleOrder.getId());
        //设置订单状态为待发货
        targetSaleOrder.setOrderStatus(SaleOrderStatusEnum.TO_BE_SHIPPED.getKey().byteValue());
        //设置订单支付状态已支付
        targetSaleOrder.setPaymentStatus(CommonConstant.YES);
        targetSaleOrder.setPaidTime(DateUtil.convertToDate(charge.getTimePaid()));
        targetSaleOrder.setUpdateTime(DateUtil.currentDate());

        //修改订单状态
        saleOrderMapper.updateByPrimaryKeySelective(targetSaleOrder);

        //保存订单支付明细
        SaleOrderPay orderPay = wrapOrderPay(charge);
        orderPay.setSaleOrderId(saleOrder.getId());

        saleOrderPayMapper.insertSelective(orderPay);

        //写入客户订单支付成功日志
        SaleOrderLog warpOrderLog = warpOrderLog(saleOrder.getId(), ErrorCodeUtil.getErrorMsg("40317"));
        saleOrderLogMapper.insertSelective(warpOrderLog);
        /*** 业务处理结束*/

        return commonResponse;
    }

    //包装订单日志
    private SaleOrderLog warpOrderLog(Integer orderId, String eventLog) {
        SaleOrderLog saleOrderLog = new SaleOrderLog();

        saleOrderLog.setSaleOrderId(orderId);
        saleOrderLog.setEventLog(eventLog);
        saleOrderLog.setEventTime(DateUtil.currentDate());

        return saleOrderLog;
    }

    /**
     * 包装支付明细
     * 
     * @param charge
     * @return
     */
    private SaleOrderPay wrapOrderPay(Charge charge) {
        SaleOrderPay saleOrderPay = new SaleOrderPay();

        saleOrderPay.setOrderCode(charge.getOrderNo());
        saleOrderPay.setTransactionNo(charge.getTransactionNo());
        saleOrderPay.setChannel(charge.getChannel());
        saleOrderPay.setChargeId(charge.getId()); //设置ping++交易id 用以查询支付结果
        saleOrderPay.setAmount(NumberUtil.convertToYuan(charge.getAmount()));
        saleOrderPay.setTimePaid(DateUtil.convertToDate(charge.getTimePaid()));
        saleOrderPay.setDescription(charge.getDescription());
        saleOrderPay.setCreateTime(DateUtil.currentDate());

        return saleOrderPay;
    }

    /**
     * 根据订单号获取订单信息
     * 
     * @param orderCode
     * @return
     */
    private SaleOrder selectByOrderCode(String orderCode) {
        //根据订单号获取订单
        SaleOrderExample saleOrderExample = new SaleOrderExample();
        SaleOrderExample.Criteria criteria = saleOrderExample.createCriteria();
        criteria.andOrderCodeEqualTo(orderCode);

        return saleOrderMapper.selectOnlyByExample(saleOrderExample);
    }
}
