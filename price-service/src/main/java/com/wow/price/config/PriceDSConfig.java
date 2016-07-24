package com.wow.price.config;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.wow.common.page.PagePlugin;

@Configuration
@PropertySource("classpath:ds_price.properties")
@EnableTransactionManagement
@MapperScan(basePackages ="com.wow.price.mapper",sqlSessionFactoryRef="priceSqlSessionFactory")
public class PriceDSConfig {

    @Bean(name = "priceDataSource")
    @ConfigurationProperties(prefix = "wow.datasource.price")
    public DataSource priceDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "priceSqlSessionFactory")
    public SqlSessionFactory priceSqlSessionFactory(
            @Qualifier("priceDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:/mapper/price/*Mapper.xml"));
        
        //加入分页插件
        PagePlugin pagePlugin=new PagePlugin();
        pagePlugin.setDialect("mysql");
        pagePlugin.setPageSqlId(".*ListPage.*"); //以listPage结尾
        
        bean.setPlugins(new Interceptor[] {pagePlugin});
        
        return bean.getObject();
    }

    @Bean(name = "priceTransactionManager")
    public DataSourceTransactionManager priceTransactionManager(
            @Qualifier("priceDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "priceSqlSessionTemplate")
    public SqlSessionTemplate priceSqlSessionTemplate(
            @Qualifier("priceSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}