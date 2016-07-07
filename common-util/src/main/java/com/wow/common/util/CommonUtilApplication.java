package com.wow.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CommonUtilApplication {

    private static final Logger logger = LoggerFactory.getLogger(CommonUtilApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CommonUtilApplication.class, args);
    }

}