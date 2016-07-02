package com.wow.mobileapi.controller;

import com.wow.order.model.Order;
import com.wow.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhengzhiqing on 16/7/2.
 */
@RestController
@RequestMapping
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/v1.0/orders/{orderId}", method = RequestMethod.GET)
    public Order getOrder(@PathVariable Integer orderId) {
        return orderService.queryOrderById(orderId);
    }
}