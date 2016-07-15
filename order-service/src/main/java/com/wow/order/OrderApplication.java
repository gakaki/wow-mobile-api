package com.wow.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wow.order.service.OrderService;
import com.wow.order.vo.response.OrderSettleResponse;

@SpringBootApplication
@RestController
public class OrderApplication {

    //private static final Logger logger = LoggerFactory.getLogger(OrderApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/orders/{orderId}", method = RequestMethod.GET)
    public OrderSettleResponse getOrderById(@PathVariable Integer orderId) {
        return orderService.queryOrderById(orderId);
    }

}