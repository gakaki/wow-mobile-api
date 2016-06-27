package com.wow.attribute;

import com.wow.attribute.model.Attribute;
import com.wow.attribute.service.AttributeService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

/**
 * Created by zhengzhiqing on 16/6/18.
 */

@SpringBootApplication
@RestController
@EnableTransactionManagement
@MapperScan("com.wow.attribute.mapper")
public class AttributeApplication {
    public static void main(String[] args) {
        SpringApplication.run(AttributeApplication.class, args);
    }

    @Autowired
    private AttributeService attributeService;

    @RequestMapping(value = "/test-attribute/{attributeId}", method = RequestMethod.GET)
    public Attribute selectAttributeById(@PathVariable Integer attributeId) {
        System.out.println("accept request:" + attributeId);
        return attributeService.getAttributeById(attributeId);
    }

//    @Bean(name = "attributeDataSource")
//    @Primary
//    @ConfigurationProperties(prefix = "spring.datasource.attribute")
//    public DataSource attributeDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "attributeSqlSessionFactory")
//    @Primary
//    public SqlSessionFactory attributeSqlSessionFactory(@Qualifier("attributeDataSource") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/attribute/*Mapper.xml"));
//        return bean.getObject();
//    }
//
//    @Bean(name = "attributeTransactionManager")
//    @Primary
//    public DataSourceTransactionManager attributeTransactionManager(@Qualifier("attributeDataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    @Bean(name = "attributeSqlSessionTemplate")
//    @Primary
//    public SqlSessionTemplate attributeSqlSessionTemplate(@Qualifier("attributeSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
}