package com.wow.price.job;

import org.springframework.scheduling.annotation.Scheduled;

/**
 * Created by zhengzhiqing on 16/7/30.
 */
public class ProductSerialPriceCalculator {

    @Scheduled(cron = "0 0 1 * * ?") //每天1点跑一次
    public void adjustProductSerialPrice() {

    }
}
