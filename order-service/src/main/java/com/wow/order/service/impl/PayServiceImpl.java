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
import com.wow.order.mapper.SaleOrderPayChargeMapper;
import com.wow.order.mapper.SaleOrderPayMapper;
import com.wow.order.model.SaleOrder;
import com.wow.order.model.SaleOrderExample;
import com.wow.order.model.SaleOrderLog;
import com.wow.order.model.SaleOrderPay;
import com.wow.order.model.SaleOrderPayCharge;
import com.wow.order.model.SaleOrderPayChargeExample;
import com.wow.order.model.SaleOrderPayExample;
import com.wow.order.service.PayService;
import com.wow.order.util.WebhooksVerifyUtil;
import com.wow.order.vo.ChargeRequest;
import com.wow.order.vo.SaleOrderVo;
import com.wow.order.vo.response.ChargeResponse;
import com.wow.order.vo.response.OrderPayResultResponse;

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

    @Value("${ppp.publicKeyFilePath}")
    private String publicKeyFilePath;

    @Autowired
    private SaleOrderMapper saleOrderMapper;

    @Autowired
    private SaleOrderPayMapper saleOrderPayMapper;

    @Autowired
    private SaleOrderPayChargeMapper saleOrderPayChargeMapper;

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
        //设置ping++公钥路径
        WebhooksVerifyUtil.pubKeyPath = publicKeyFilePath;
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
        chargeMap.put("subject", "上海尖叫互动文化传媒有限公司");
        chargeMap.put("body", "尖叫设计订单支付");
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

            //保存交易凭据
            savePayCharge(charge);
        } catch (PingppException e) {
            ErrorResponseUtil.setErrorResponse(chargeResponse, "40361");
        }

        return chargeResponse;
    }

    /**
     * 保存ping++支付交易凭据
     * 
     * @param charge
     */
    private void savePayCharge(Charge charge) {
        if (charge == null) {
            return;
        }

        //根据订单号查询相应的支付凭据
        SaleOrderPayCharge saleOrderPayCharge = queryPayChargeByOrderCode(charge.getOrderNo());
        //如果凭据已经存在 则更新相关的凭据
        if (saleOrderPayCharge != null) {
            SaleOrderPayCharge targetSaleOrderCharge = new SaleOrderPayCharge();

            targetSaleOrderCharge.setId(saleOrderPayCharge.getId());
            targetSaleOrderCharge.setChargeId(charge.getId());

            saleOrderPayChargeMapper.updateByPrimaryKeySelective(targetSaleOrderCharge);

            return;
        }

        //保存凭据信息
        saleOrderPayCharge = new SaleOrderPayCharge();

        saleOrderPayCharge.setChargeId(charge.getId());
        saleOrderPayCharge.setOrderCode(charge.getOrderNo());
        saleOrderPayCharge.setCreateTime(DateUtil.currentDate());

        saleOrderPayChargeMapper.insertSelective(saleOrderPayCharge);
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
        boolean isVerify = WebhooksVerifyUtil.verifyData(content, signature);

        //如果验证签名错误  则直接返回
        if (!isVerify) {
            commonResponse.setResCode("40318");
            commonResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40318"));

            return commonResponse;
        }

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

        //保存支付结果到数据库
        processPayResult(commonResponse, charge);

        return commonResponse;
    }

    /**
     * 处理支付结果
     * @param commonResponse 
     * 
     * @param charge
     * @return 
     */
    private CommonResponse processPayResult(CommonResponse commonResponse, Charge charge) {
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
        SaleOrderVo saleOrderVo = new SaleOrderVo();

        saleOrderVo.setId(saleOrder.getId());
        //设置订单状态为待发货
        saleOrderVo.setOrderStatus(SaleOrderStatusEnum.TO_BE_SHIPPED.getKey().byteValue());
        //设置订单支付状态已支付
        saleOrderVo.setPaymentStatus(CommonConstant.PAID);
        //设置期望的订单支付状态为未支付
        saleOrderVo.setExpectPaymentStatus(CommonConstant.UNPAY);
        saleOrderVo.setPaidTime(DateUtil.currentDate()); //设置实际支付的时间 因为ping++支付返回的支付时间错误
        saleOrderVo.setUpdateTime(DateUtil.currentDate());

        //修改订单状态
        int count = saleOrderMapper.updateByPrimaryByIdAndStatus(saleOrderVo);

        //如果订单状态修改成功 保存支付明细和日志
        if (count > 0) {
            //保存订单支付明细
            SaleOrderPay orderPay = wrapOrderPay(charge);
            orderPay.setSaleOrderId(saleOrder.getId());

            saleOrderPayMapper.insertSelective(orderPay);

            //写入客户订单支付成功日志
            SaleOrderLog warpOrderLog = warpOrderLog(saleOrder.getId(), ErrorCodeUtil.getErrorMsg("40317"));
            saleOrderLogMapper.insertSelective(warpOrderLog);
        }

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

    /**
     * 根据订单号获取订单支付信息
     * 
     * @param orderCode
     * @return
     */
    private SaleOrderPay selectPayResultByOrderCode(String orderCode) {
        //根据订单号获取订单支付结果
        SaleOrderPayExample saleOrderPayExample = new SaleOrderPayExample();
        SaleOrderPayExample.Criteria criteria = saleOrderPayExample.createCriteria();
        criteria.andOrderCodeEqualTo(orderCode);

        return saleOrderPayMapper.selectOnlyByExample(saleOrderPayExample);
    }

    @Override
    public OrderPayResultResponse queryOrderPayResult(String orderCode) {
        OrderPayResultResponse response = new OrderPayResultResponse();

        //从本地查询订单支付结果
        SaleOrderPay saleOrderPay = selectPayResultByOrderCode(orderCode);

        //如果未收到支付通知 则需调用ping++订单支付查询接口 查询支付是否成功
        if (saleOrderPay == null) {
            response = getPayResultFromPingPlus(orderCode, response);

            return response;
        }

        response.setOrderCode(orderCode);
        response.setPayAmount(saleOrderPay.getAmount());
        response.setPaymentChannel(saleOrderPay.getChannel());
        response.setPaymentChannelName(CommonConstant.getPayMethodName(saleOrderPay.getChannel()));

        return response;
    }

    /**
     * 根据订单号查询ping++支付结果
     * 
     * @param orderCode
     * @param response
     * @return
     */
    private OrderPayResultResponse getPayResultFromPingPlus(String orderCode, OrderPayResultResponse response) {
        Charge retrieve = queryPayResult(orderCode);

        //如果未查找到交易记录 则返回交易错误信息
        if (retrieve == null) {
            response.setResCode("40363");
            response.setResMsg(ErrorCodeUtil.getErrorMsg("40363"));

            return response;
        }

        //如果订单未支付成功 则直接返回错误
        if (!retrieve.getPaid()) {
            response.setResCode("40323");
            response.setResMsg(ErrorCodeUtil.getErrorMsg("40323"));

            return response;
        }

        //保存支付结果到数据库
        processPayResult(new CommonResponse(), retrieve);

        //包装支付响应结果
        response.setPayAmount(NumberUtil.convertToYuan(retrieve.getAmount()));
        response.setOrderCode(retrieve.getOrderNo());
        response.setPaymentChannel(retrieve.getChannel());
        response.setPaymentChannelName(CommonConstant.getPayMethodName(retrieve.getChannel()));

        return response;
    }

    /**
     * 根据订单号向ping++发起查询支付结果请求
     * 
     * @param orderCode
     * @return
     */
    private Charge queryPayResult(String orderCode) {
        SaleOrderPayCharge saleOrderCharge = queryPayChargeByOrderCode(orderCode);
        if (saleOrderCharge == null) {
            return null;
        }

        Charge retrieve = null;
        try {
            retrieve = Charge.retrieve(saleOrderCharge.getChargeId());
        } catch (Exception e) {
        }

        return retrieve;
    }

    /**
     * 根据订单号查询交易凭据id
     * 
     * @param orderCode
     * @return
     */
    private SaleOrderPayCharge queryPayChargeByOrderCode(String orderCode) {
        SaleOrderPayChargeExample example = new SaleOrderPayChargeExample();
        SaleOrderPayChargeExample.Criteria criteria = example.createCriteria();
        criteria.andOrderCodeEqualTo(orderCode);

        SaleOrderPayCharge saleOrderCharge = saleOrderPayChargeMapper.selectOnlyByExample(example);
        return saleOrderCharge;
    }

}
