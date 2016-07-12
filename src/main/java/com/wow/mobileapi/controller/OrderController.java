package com.wow.mobileapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wow.common.request.ApiRequest;
import com.wow.common.response.ApiResponse;
import com.wow.common.util.JsonUtil;
import com.wow.order.service.OrderService;
import com.wow.order.vo.request.OrderRequest;
import com.wow.order.vo.response.OrderResponse;

/**
 * Created by zhengzhiqing on 16/7/2.
 */
@RestController
@RequestMapping
public class OrderController {

    //private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    /**
     * 获取订单列表信息
     * 
     * @param orderId
     * @return
     */
    @RequestMapping(value = "/v1/orders", method = RequestMethod.GET)
    public ApiResponse getOrderList(ApiRequest request) {
        OrderRequest orderRequest = JsonUtil.fromJSON(request.getParamJson(), OrderRequest.class);
        
        ApiResponse apiResponse = new ApiResponse();

        //判断json格式参数是否有误
        if (orderRequest == null) {
            apiResponse.setResCode("22323");
            apiResponse.setResMsg("paramJson参数格式有误");
            
            return apiResponse;
        }

        OrderResponse orderResponse = orderService.queryOrderById(orderRequest.getId());

        //如果处理失败 则返回错误信息
        if (!"0".equals(orderResponse.getResCode())) {
            apiResponse.setResCode(orderResponse.getResCode());
            apiResponse.setResMsg(orderResponse.getResMsg());

            return apiResponse;
        }

        apiResponse.setData(orderResponse.getOrder());

        return apiResponse;
    }

}