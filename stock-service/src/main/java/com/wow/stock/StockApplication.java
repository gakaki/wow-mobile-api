package com.wow.stock;

import com.wow.stock.service.StockService;
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
@MapperScan("com.wow.stock.mapper")
public class StockApplication {

    private static final Logger logger = LoggerFactory.getLogger(StockApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(StockApplication.class, args);
    }

    @Autowired
    private StockService stockService;

    @RequestMapping(value = "/test-stock/{productId}", method = RequestMethod.GET)
    public int getPrimarySubProduct(@PathVariable Integer productId) {
        System.out.println("accept request:" + productId);
        return stockService.getAvailableStock(productId);
    }

//    @Bean(name = "stockDataSource")
//    @Primary
//    @ConfigurationProperties(prefix = "spring.datasource.stock")
//    public DataSource stockDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "stockSqlSessionFactory")
//    @Primary
//    public SqlSessionFactory stockSqlSessionFactory(@Qualifier("stockDataSource") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/stock/*Mapper.xml"));
//        return bean.getObject();
//    }
//
//    @Bean(name = "stockTransactionManager")
//    @Primary
//    public DataSourceTransactionManager stockTransactionManager(@Qualifier("stockDataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    @Bean(name = "stockSqlSessionTemplate")
//    @Primary
//    public SqlSessionTemplate stockSqlSessionTemplate(@Qualifier("stockSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
}