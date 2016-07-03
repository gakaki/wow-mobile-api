package com.wow.marketing;

import com.wow.marketing.model.Coupon;
import com.wow.marketing.service.CouponService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MarketingApplication {

    private static final Logger logger = LoggerFactory.getLogger(MarketingApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MarketingApplication.class, args);
    }

    @Autowired
    private CouponService couponService;

    @RequestMapping(value = "/coupons/{couponId}", method = RequestMethod.GET)
    public Coupon getCouponById(@PathVariable Integer couponId) {
        return couponService.getCouponById(couponId);
    }

}