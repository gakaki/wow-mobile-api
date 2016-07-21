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
import com.wow.common.util.ErrorCodeUtil;
import com.wow.common.util.JsonUtil;
import com.wow.common.util.StringUtil;
import com.wow.common.util.ValidatorUtil;
import com.wow.mobileapi.request.order.OrderDetailRequest;
import com.wow.mobileapi.request.order.OrderListRequest;
import com.wow.mobileapi.request.order.OrderRequest;
import com.wow.mobileapi.request.order.OrderSettleRequest;
import com.wow.order.service.OrderService;
import com.wow.order.vo.OrderListQuery;
import com.wow.order.vo.OrderQuery;
import com.wow.order.vo.OrderSettleQuery;
import com.wow.order.vo.response.OrderDetailResponse;
import com.wow.order.vo.response.OrderListResponse;
import com.wow.order.vo.response.OrderResponse;
import com.wow.order.vo.response.OrderSettleResponse;

/**
 * Created by zhengzhiqing on 16/7/2.
 */
@RestController
@RequestMapping(value = "/v1/order")
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
    @RequestMapping(value = "/settle", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
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
    @RequestMapping(value = "/create", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
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
            logger.error("创建订单错误---" + e);
            setInternalErrorResponse(apiResponse);
        }

        return apiResponse;
    }

    /**
     * 获取用户订单列表
     * 
     * @param request
     * @return
     */
    @RequestMapping(value = "/get", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public ApiResponse selectOrderList(ApiRequest request) {
        OrderListRequest orderListRequest = JsonUtil.fromJSON(request.getParamJson(), OrderListRequest.class);
        ApiResponse apiResponse = new ApiResponse();
        //判断json格式参数是否有误
        if (orderListRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }

        String errorMsg = ValidatorUtil.getError(orderListRequest);
        //如果校验错误 则返回
        if (StringUtil.isNotEmpty(errorMsg)) {
            setInvalidParameterResponse(apiResponse, errorMsg);
            return apiResponse;
        }

        OrderListResponse orderListResponse = null;
        try {
            OrderListQuery query = new OrderListQuery();
            query.setEndUserId(35);

            orderListResponse = orderService.queryOrderList(query);
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(orderListResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, orderListResponse);
            } else {
                apiResponse.setData(orderListResponse.getOrderLists());
            }
        } catch (Exception e) {
            logger.error("查询订单列表错误---" + e);
            setInternalErrorResponse(apiResponse);
        }

        return apiResponse;
    }

    /**
     * 获取用户订单明细
     * 
     * @param request
     * @return
     */
    @RequestMapping(value = "/getDetail", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public ApiResponse getOrderDetail(ApiRequest request) {
        OrderDetailRequest orderDetailRequest = JsonUtil.fromJSON(request.getParamJson(), OrderDetailRequest.class);
        ApiResponse apiResponse = new ApiResponse();
        //判断json格式参数是否有误
        if (orderDetailRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }

        OrderDetailResponse orderDetailResponse = null;
        try {
            orderDetailResponse = orderService.queryOrderByOrderCode(orderDetailRequest.getOrderCode());
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(orderDetailResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, orderDetailResponse);
            } else {
                apiResponse.setData(orderDetailResponse);
            }
        } catch (Exception e) {
            logger.error("查询订单明细错误---" + e);
            setInternalErrorResponse(apiResponse);
        }

        return apiResponse;
    }

}