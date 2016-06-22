package com.wow.mobileapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhengzhiqing on 16/6/22.
 */
@RestController
@RequestMapping("/")
public class ApiSummaryController {
    private static final Logger logger = LoggerFactory.getLogger(ApiSummaryController.class);

    @RequestMapping(method = RequestMethod.GET)
    public Map<String,String> findAllApis() {
        Map<String,String> apiMap = new HashMap<String,String>();
        apiMap.put("attributes_url","http://localhost:8080/mobile-api-dev/attributes/{attribute_id}");
        apiMap.put("users_url","http://localhost:8080/mobile-api-dev/users/{user_id}");
        apiMap.put("products_url","http://localhost:8080/mobile-api-dev/products/{product_id}");
        apiMap.put("orders_url","http://localhost:8080/mobile-api-dev/orders/{order_id}");
        apiMap.put("prices_url","http://localhost:8080/mobile-api-dev/prices/{product_id}");
        apiMap.put("stocks_url","http://localhost:8080/mobile-api-dev/stocks/{product_id}");
        apiMap.put("coupons_url","http://localhost:8080/mobile-api-dev/coupons/{coupon_id}");
        return apiMap;
    }
}
