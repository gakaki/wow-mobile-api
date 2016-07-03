package com.wow;

/**
 * Created by zhengzhiqing on 16/6/18.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MobileApiApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(MobileApiApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MobileApiApplication.class, args);
    }

    /**
     * If you need to run some specific code once the SpringApplication has started,
     * you can implement the ApplicationRunner or CommandLineRunner interfaces.
     *
     * @param args
     */
    public void run(String... args) {
        logger.info("Mobile api is started and be ready to accept requests from app(iOS/Android).");
    }
}