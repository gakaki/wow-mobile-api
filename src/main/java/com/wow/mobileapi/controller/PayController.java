package com.wow.mobileapi.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wow.common.request.ApiRequest;
import com.wow.common.response.ApiResponse;
import com.wow.common.response.CommonResponse;
import com.wow.common.util.ErrorCodeUtil;
import com.wow.common.util.JsonUtil;
import com.wow.common.util.StreamUtil;
import com.wow.mobileapi.request.order.OrderDetailRequest;
import com.wow.order.service.PayService;
import com.wow.order.vo.ChargeRequest;
import com.wow.order.vo.response.ChargeResponse;
import com.wow.order.vo.response.OrderPayResultResponse;

/**
 * Created by zhengzhiqing on 16/7/2.
 */
@RestController
@RequestMapping(value = "/v1/pay")
public class PayController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(PayController.class);

    @Autowired
    private PayService payService;

    /**
     * 获取支付凭证
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/charge", method = RequestMethod.POST)
    public ApiResponse requestCharge(ApiRequest request) {
        ChargeRequest chargeRequest = JsonUtil.fromJSON(request.getParamJson(), ChargeRequest.class);
        ApiResponse apiResponse = new ApiResponse();
        //判断json格式参数是否有误
        if (chargeRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }

        try {
            ChargeResponse chargeResponse = payService.getCharge(chargeRequest);
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(chargeResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, chargeResponse);
            } else {
                apiResponse.setData(chargeResponse);
            }
        } catch (Exception e) {
            logger.error("请求支付凭证错误---", e);
            setInternalErrorResponse(apiResponse);
        }

        return apiResponse;
    }

    /**
     * 处理ping++支付的回调通知
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/webhooks", method = RequestMethod.POST)
    public ApiResponse webhooks(HttpServletRequest request, HttpServletResponse response) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("设置请求编码错误---" , e);
        }

        try {
            String content = StreamUtil.getString(request.getInputStream());
            logger.info("content " + content);

            //获取签名串
            String signature = request.getHeader("X-Pingplusplus-Signature");

            logger.info("signature " + signature);
            // 解析异步通知数据
            CommonResponse commonResponse = payService.webhooks(content, signature);
            //处理失败则返回错误提示 并返回500错误码
            if (ErrorCodeUtil.isFailedResponse(commonResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, commonResponse);
                response.setStatus(500);
            } else {
                //处理成功则返回200通知
                response.setStatus(200);
            }
        } catch (Exception e) {
            response.setStatus(500);
            logger.error("获取通知内容错误", e);
        }

        return apiResponse;
    }

    /**
     * 查询支付结果
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/payResult", method = RequestMethod.GET)
    public ApiResponse selectPayResult(ApiRequest request) {
        OrderDetailRequest orderDetailRequest = JsonUtil.fromJSON(request.getParamJson(), OrderDetailRequest.class);
        ApiResponse apiResponse = new ApiResponse();
        //判断json格式参数是否有误
        if (orderDetailRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }

        try {
            // 获取支付结果
            OrderPayResultResponse payResultResponse = payService
                .queryOrderPayResult(orderDetailRequest.getOrderCode());

            //处理失败则返回错误提示
            if (ErrorCodeUtil.isFailedResponse(payResultResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, payResultResponse);
            } else {
                apiResponse.setData(payResultResponse);
            }
        } catch (Exception e) {
            logger.error("获取支付结果信息错误", e);
            setInternalErrorResponse(apiResponse);
        }

        return apiResponse;
    }
}