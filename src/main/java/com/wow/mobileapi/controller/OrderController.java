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
import com.wow.common.util.DateUtil;
import com.wow.common.util.ErrorCodeUtil;
import com.wow.common.util.JsonUtil;
import com.wow.common.util.StringUtil;
import com.wow.common.util.ValidatorUtil;
import com.wow.mobileapi.request.order.AdminOrderListRequest;
import com.wow.mobileapi.request.order.OrderDeliverRequest;
import com.wow.mobileapi.request.order.OrderDetailRequest;
import com.wow.mobileapi.request.order.OrderListRequest;
import com.wow.mobileapi.request.order.OrderRequest;
import com.wow.mobileapi.request.order.OrderSettleRequest;
import com.wow.order.service.AdminOrderService;
import com.wow.order.service.OrderService;
import com.wow.order.vo.AdminOrderListQuery;
import com.wow.order.vo.OrderDeliverQuery;
import com.wow.order.vo.OrderDetailQuery;
import com.wow.order.vo.OrderListQuery;
import com.wow.order.vo.OrderQuery;
import com.wow.order.vo.OrderSettleQuery;
import com.wow.order.vo.response.AdminOrderDetailResponse;
import com.wow.order.vo.response.AdminOrderListResponse;
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

    @Autowired
    private AdminOrderService adminOrderService;

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

            //设置用户id
            Integer endUserId = getUserIdByTokenChannel(request);
            query.setEndUserId(endUserId);
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
            //设置用户id
            Integer endUserId = getUserIdByTokenChannel(request);
            query.setEndUserId(endUserId);

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

    /**
     * 订单发货
     * 
     * @param request
     * @return
     */
    @RequestMapping(value = "/deliver", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
    public ApiResponse deliverGoods(ApiRequest request) {
        OrderDeliverRequest orderDeliverRequest = JsonUtil.fromJSON(request.getParamJson(), OrderDeliverRequest.class);
        ApiResponse apiResponse = new ApiResponse();
        //判断json格式参数是否有误
        if (orderDeliverRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }

        CommonResponse commonResponse = null;
        try {
            OrderDeliverQuery query = new OrderDeliverQuery();
            BeanUtil.copyProperties(orderDeliverRequest, query);

            commonResponse = orderService.deliverGoods(query);
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(commonResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, commonResponse);
            }
        } catch (Exception e) {
            logger.error("订单发货错误---" + e);
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
    @RequestMapping(value = "/getList", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
    public ApiResponse selectAdminOrderList(ApiRequest request) {
        AdminOrderListRequest orderListRequest = JsonUtil.fromJSON(request.getParamJson(), AdminOrderListRequest.class);
        ApiResponse apiResponse = new ApiResponse();
        //判断json格式参数是否有误
        if (orderListRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }

        AdminOrderListResponse orderListResponse = null;
        try {
            AdminOrderListQuery query = new AdminOrderListQuery();
            BeanUtil.copyProperties(orderListRequest, query);

            //设置订单开始日期
            if (StringUtil.isNotEmpty(orderListRequest.getBeginDate())) {
                query.setBeginDateFormat(DateUtil.setBeginDate(orderListRequest.getBeginDate()));
            }

            //设置订单结束日期
            if (StringUtil.isNotEmpty(orderListRequest.getEndDate())) {
                query.setEndDateFormat(DateUtil.setEndDate(orderListRequest.getEndDate()));
            }

            //获取用户userId
            Integer endUserId = getUserIdByTokenChannel(request);
            query.setEndUserId(endUserId);

            orderListResponse = adminOrderService.queryOrderListPage(query);
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(orderListResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, orderListResponse);
            } else {
                apiResponse.setData(orderListResponse);
            }
        } catch (Exception e) {
            logger.error("获取订单列表错误---" + e);
            setInternalErrorResponse(apiResponse);
        }

        return apiResponse;
    }

    /**
     * 获取订单明细 后台用
     * 
     * @param request
     * @return
     */
    @RequestMapping(value = "/getAdminOrderDetail", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public ApiResponse getAdminOrderDetail(ApiRequest request) {
        OrderDetailRequest orderDetailRequest = JsonUtil.fromJSON(request.getParamJson(), OrderDetailRequest.class);
        ApiResponse apiResponse = new ApiResponse();
        //判断json格式参数是否有误
        if (orderDetailRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }

        AdminOrderDetailResponse orderDetailResponse = null;
        try {
            OrderDetailQuery query = new OrderDetailQuery();
            query.setOrderCode(orderDetailRequest.getOrderCode());

            orderDetailResponse = adminOrderService.queryOrderDetail(query);
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(orderDetailResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, orderDetailResponse);
            } else {
                apiResponse.setData(orderDetailResponse);
            }
        } catch (Exception e) {
            logger.error("获取订单明细错误---" + e);
            setInternalErrorResponse(apiResponse);
        }

        return apiResponse;
    }

}