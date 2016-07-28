package com.wow.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class OrderApplication {

    //private static final Logger logger = LoggerFactory.getLogger(OrderApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

//    @Autowired
//    private OrderService orderService;
//
//    @RequestMapping(value = "/orders/{orderId}", method = RequestMethod.GET)
//    public OrderSettleResponse getOrderById(@PathVariable Integer orderId) {
//        return orderService.queryOrderById(orderId);
//    }

}