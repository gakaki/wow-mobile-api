package com.wow.stock.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:ds_stock.properties")
@EnableTransactionManagement
@MapperScan(basePackages ="com.wow.stock.mapper",sqlSessionFactoryRef="stockSqlSessionFactory")
public class StockDSConfig {

    @Bean(name = "stockDataSource")
    @ConfigurationProperties(prefix = "wow.datasource.stock")
    public DataSource stockDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "stockSqlSessionFactory")
    @Autowired
    @Qualifier("stockDataSource")
    public SqlSessionFactory stockSqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/stock/*Mapper.xml"));
        return bean.getObject();
    }

    @Bean(name = "stockTransactionManager")
    @Autowired
    @Qualifier("stockDataSource")
    public DataSourceTransactionManager stockTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "stockSqlSessionTemplate")
    @Autowired
    @Qualifier("stockSqlSessionFactory")
    public SqlSessionTemplate stockSqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}