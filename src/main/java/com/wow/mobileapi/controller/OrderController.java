package com.wow.mobileapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wow.common.request.ApiRequest;
import com.wow.common.response.ApiResponse;
import com.wow.common.response.CommonResponse;
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
import com.wow.order.vo.OrderDetailQuery;
import com.wow.order.vo.OrderListQuery;
import com.wow.order.vo.OrderQuery;
import com.wow.order.vo.OrderSettleQuery;
import com.wow.order.vo.response.OrderDetailResponse;
import com.wow.order.vo.response.OrderDirectResponse;
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
        ApiResponse apiResponse = new ApiResponse();

        OrderSettleResponse orderSettleResponse = null;
        try {
            OrderSettleQuery query = new OrderSettleQuery();

            //设置用户id
            Integer endUserId = getUserIdByTokenChannel(request);
            query.setEndUserId(endUserId);

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
     * 立即购买
     * 
     * @param request
     * @return
     */
    @RequestMapping(value = "/buyNow", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public ApiResponse buyNow(ApiRequest request) {
        OrderSettleRequest orderRequest = JsonUtil.fromJSON(request.getParamJson(), OrderSettleRequest.class);
        ApiResponse apiResponse = new ApiResponse();
        
        //判断json格式参数是否有误
        if (orderRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }

        OrderDirectResponse orderDirectResponse=null;
        try {
            OrderSettleQuery query = new OrderSettleQuery();
            query.setProductId(orderRequest.getProductId());
            query.setProductQty(orderRequest.getProductQty());

            orderDirectResponse = orderService.buyNow(query);
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(orderDirectResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, orderDirectResponse);
            } else {
                apiResponse.setData(orderDirectResponse);
            }
        } catch (Exception e) {
            logger.error("获取产品结算信息错误---" + e);
            setInternalErrorResponse(apiResponse);
        }

        return apiResponse;
    }

    /**
     * 创建订单
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

            //设置用户id
            Integer endUserId = getUserIdByTokenChannel(request);
            query.setEndUserId(endUserId);
            //如果是从购物车进行结算 则调用createOrderFromCart
            if(orderRequest.getProductId()==null){
                orderResponse = orderService.createOrderFromCart(query);
            } else{
                //如果是立即购买 则调用createOrderFromDirect
                orderResponse = orderService.createOrderFromDirect(query);
            }
           
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

    /**
     * 获取用户订单列表
     * 
     * @param request
     * @return
     */
    @RequestMapping(value = "/get", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public ApiResponse selectOrderList(ApiRequest request) {
        ApiResponse apiResponse = new ApiResponse();

        //如果有查询条件 则解析相应的paramJson
        OrderListRequest orderListRequest = JsonUtil.fromJSON(request.getParamJson(), OrderListRequest.class);
        //判断json格式参数是否有误
        if (orderListRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }

        OrderListResponse orderListResponse = null;
        try {
            OrderListQuery query = new OrderListQuery();
            //设置用户id
            Integer endUserId = getUserIdByTokenChannel(request);
            query.setEndUserId(endUserId);
            query.setOrderStatus(orderListRequest.getOrderStatus());
            query.setPageSize(orderListRequest.getPageSize());
            query.setCurrentPage(orderListRequest.getCurrentPage());

            orderListResponse = orderService.queryOrderListPage(query);
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(orderListResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, orderListResponse);
            } else {
                apiResponse.setData(orderListResponse);
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
            orderDetailResponse = orderService.queryOrderDetailByOrderCode(orderDetailRequest.getOrderCode());
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

    /**
     * 取消订单
     * 
     * @param request
     * @return
     */
    @RequestMapping(value = "/cancel", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
    public ApiResponse cancelOrder(ApiRequest request) {
        OrderDetailRequest orderDetailRequest = JsonUtil.fromJSON(request.getParamJson(), OrderDetailRequest.class);
        ApiResponse apiResponse = new ApiResponse();
        //判断json格式参数是否有误
        if (orderDetailRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }

        CommonResponse commonResponse = null;
        try {
            OrderDetailQuery query = new OrderDetailQuery();
            query.setOrderCode(orderDetailRequest.getOrderCode());

            commonResponse = orderService.cancelOrder(query);
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(commonResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, commonResponse);
            }
        } catch (Exception e) {
            logger.error("取消订单错误---" + e);
            setInternalErrorResponse(apiResponse);
        }

        return apiResponse;
    }

}