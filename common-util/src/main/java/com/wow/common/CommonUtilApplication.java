package com.wow.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommonUtilApplication {

    private static final Logger logger = LoggerFactory.getLogger(CommonUtilApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CommonUtilApplication.class, args);
    }

}