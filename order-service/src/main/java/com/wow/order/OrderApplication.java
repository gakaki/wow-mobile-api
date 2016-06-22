package com.wow.order;

import com.wow.order.model.Order;
import com.wow.order.service.OrderService;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableTransactionManagement
@MapperScan("com.wow.order.mapper")
public class OrderApplication {

    private static final Logger logger = LoggerFactory.getLogger(OrderApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/test-order/{orderId}", method = RequestMethod.GET)
    public Order getOrderById(@PathVariable Integer orderId) {
        System.out.println("accept request:" + orderId);
        return orderService.queryOrderById(orderId);
    }

//    @Bean(name = "orderDataSource")
//    @Primary
//    @ConfigurationProperties(prefix = "spring.datasource.order")
//    public DataSource orderDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "orderSqlSessionFactory")
//    @Primary
//    public SqlSessionFactory orderSqlSessionFactory(@Qualifier("orderDataSource") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/order/*Mapper.xml"));
//        return bean.getObject();
//    }
//
//    @Bean(name = "orderTransactionManager")
//    @Primary
//    public DataSourceTransactionManager orderTransactionManager(@Qualifier("orderDataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    @Bean(name = "orderSqlSessionTemplate")
//    @Primary
//    public SqlSessionTemplate orderSqlSessionTemplate(@Qualifier("orderSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
}