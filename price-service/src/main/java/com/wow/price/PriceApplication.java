package com.wow.price;

import com.wow.price.model.ProductPrice;
import com.wow.price.service.PriceService;
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
public class PriceApplication {

    private static final Logger logger = LoggerFactory.getLogger(PriceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(PriceApplication.class, args);
    }

    @Autowired
    private PriceService priceService;

    @RequestMapping(value = "/products/{productId}/prices", method = RequestMethod.GET)
    public ProductPrice getProductPrice(@PathVariable Integer productId) {
        logger.info("accept request:" + productId);
        return priceService.queryProductPrice(productId);
    }
}