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
        
        //attributes related
        apiMap.put("attributes get","GET http://localhost:8080/mobile-api-dev/v1/attributes/{attribute_id}");
        apiMap.put("attributes get all","GET http://localhost:8080/mobile-api-dev/v1/attributes");
        apiMap.put("attributes post","POST http://localhost:8080/mobile-api-dev/v1/attributes");
        apiMap.put("attributes put","PUT http://localhost:8080/mobile-api-dev/v1/attributes/{attribute_id}");
        apiMap.put("attributes delete","DELETE http://localhost:8080/mobile-api-dev/v1/attributes/{attribute_id}");
        
        //user related
        apiMap.put("users get","GET http://localhost:8080/mobile-api-dev/v1/users/{user_id}");
        apiMap.put("users get all","GET http://localhost:8080/mobile-api-dev/v1/users");
        apiMap.put("users post","POST http://localhost:8080/mobile-api-dev/v1/users");
        apiMap.put("users put","PUT http://localhost:8080/mobile-api-dev/v1/users/{user_id}");
        apiMap.put("users delete","DELETE http://localhost:8080/mobile-api-dev/v1/users/{user_id}");
        
        //product related
        apiMap.put("products get","GET http://localhost:8080/mobile-api-dev/v1/products/{product_id}");
        apiMap.put("products get all","GET http://localhost:8080/mobile-api-dev/v1/products");
        apiMap.put("products post","POST http://localhost:8080/mobile-api-dev/v1/products");
        apiMap.put("products put","PUT http://localhost:8080/mobile-api-dev/v1/products/{product_id}");
        apiMap.put("products delete","DELETE http://localhost:8080/mobile-api-dev/v1/products/{product_id}");
        
        //order related
        apiMap.put("orders get","GET http://localhost:8080/mobile-api-dev/v1/orders/{order_id}");
        apiMap.put("orders get all","GET http://localhost:8080/mobile-api-dev/v1/orders");
        apiMap.put("orders post","POST http://localhost:8080/mobile-api-dev/v1/orders");
        apiMap.put("orders put","PUT http://localhost:8080/mobile-api-dev/v1/orders/{order_id}");
        apiMap.put("orders delete","DELETE http://localhost:8080/mobile-api-dev/v1/orders/{order_id}");
        
        //price related
        apiMap.put("prices get","GET http://localhost:8080/mobile-api-dev/v1/prices/{price_id}");
        apiMap.put("prices get all","GET http://localhost:8080/mobile-api-dev/v1/prices");
        apiMap.put("prices post","POST http://localhost:8080/mobile-api-dev/v1/prices");
        apiMap.put("prices put","PUT http://localhost:8080/mobile-api-dev/v1/prices/{price_id}");
        apiMap.put("prices delete","DELETE http://localhost:8080/mobile-api-dev/v1/prices/{price_id}");
        
        //stock related
        apiMap.put("stocks get","GET http://localhost:8080/mobile-api-dev/v1/stocks/{stock_id}");
        apiMap.put("stocks get all","GET http://localhost:8080/mobile-api-dev/v1/stocks");
        apiMap.put("stocks post","POST http://localhost:8080/mobile-api-dev/v1/stocks");
        apiMap.put("stocks put","PUT http://localhost:8080/mobile-api-dev/v1/stocks/{stock_id}");
        apiMap.put("stocks delete","DELETE http://localhost:8080/mobile-api-dev/v1/stocks/{stock_id}");
        
        //coupons related
        apiMap.put("coupons get","GET http://localhost:8080/mobile-api-dev/v1/coupons/{coupon_id}");
        apiMap.put("coupons get all","GET http://localhost:8080/mobile-api-dev/v1/coupons");
        apiMap.put("coupons post","POST http://localhost:8080/mobile-api-dev/v1/coupons");
        apiMap.put("coupons put","PUT http://localhost:8080/mobile-api-dev/v1/coupons/{coupon_id}");
        apiMap.put("coupons delete","DELETE http://localhost:8080/mobile-api-dev/v1/coupons/{coupon_id}");
        
        return apiMap;
    }
}
