package com.wow.mobileapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wow.common.request.ApiRequest;
import com.wow.common.response.ApiResponse;
import com.wow.common.util.BeanUtil;
import com.wow.common.util.JsonUtil;
import com.wow.common.util.StringUtil;
import com.wow.common.util.ValidatorUtil;
import com.wow.mobileapi.request.order.OrderRequest;
import com.wow.mobileapi.request.order.OrderSettleRequest;
import com.wow.order.service.OrderService;
import com.wow.order.vo.OrderQuery;
import com.wow.order.vo.OrderSettleQuery;
import com.wow.order.vo.response.OrderResponse;
import com.wow.order.vo.response.OrderSettleResponse;

/**
 * Created by zhengzhiqing on 16/7/2.
 */
@RestController
@RequestMapping(value = "/v1/orders")
public class OrderController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    /**
     * 获取用户购买的产品结算信息
     * 
     * @param request
     * @return
     */
    @RequestMapping(value = "/settleOrder", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public ApiResponse settleOrder(ApiRequest request) {
        OrderSettleRequest orderSettleRequest = JsonUtil.fromJSON(request.getParamJson(), OrderSettleRequest.class);
        ApiResponse apiResponse = new ApiResponse();
        //判断json格式参数是否有误
        if (orderSettleRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }

        String errorMsg = ValidatorUtil.getError(orderSettleRequest);
        //如果校验错误 则返回
        if (StringUtil.isNotEmpty(errorMsg)) {
            setInvalidParameterResponse(apiResponse, errorMsg);
            return apiResponse;
        }
        OrderSettleResponse orderSettleResponse = null;
        try {
            OrderSettleQuery query = new OrderSettleQuery();

            query.setEndUserId(orderSettleRequest.getEndUserId());
            query.setShoppingCartIds(orderSettleRequest.getShoppingCartIds());

            orderSettleResponse = orderService.settleOrder(query);
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(orderSettleResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, orderSettleResponse);
            } else {
                apiResponse.setData(orderSettleResponse);
            }
        } catch (Exception e) {
            logger.error("获取产品结算信息错误---" + e);
            setInternalErrorResponse(apiResponse);
        }

        return apiResponse;
    }

    /**
     * 获取用户购买的产品结算信息
     * 
     * @param request
     * @return
     */
    @RequestMapping(value = "/createOrder", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
    public ApiResponse createOrder(ApiRequest request) {
        OrderRequest orderRequest = JsonUtil.fromJSON(request.getParamJson(), OrderRequest.class);
        ApiResponse apiResponse = new ApiResponse();
        //判断json格式参数是否有误
        if (orderRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }

        String errorMsg = ValidatorUtil.getError(orderRequest);
        //如果校验错误 则返回
        if (StringUtil.isNotEmpty(errorMsg)) {
            setInvalidParameterResponse(apiResponse, errorMsg);
            return apiResponse;
        }

        OrderResponse orderResponse = null;
        try {
            OrderQuery query = new OrderQuery();
            BeanUtil.copyProperties(orderRequest, query);
            query.setEndUserId(35);

            orderResponse = orderService.createOrder(query);
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(orderResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, orderResponse);
            } else {
                apiResponse.setData(orderResponse);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("创建订单错误---" + e);
            setInternalErrorResponse(apiResponse);
        }

        return apiResponse;
    }

}