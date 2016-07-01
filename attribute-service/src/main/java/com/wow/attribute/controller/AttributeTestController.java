package com.wow.attribute.controller;

import com.wow.attribute.model.Attribute;
import com.wow.attribute.model.Category;
import com.wow.attribute.service.AttributeService;
import com.wow.attribute.service.CategoryService;
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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengzhiqing on 16/6/18.
 */
@RestController
public class AttributeTestController {

    @Autowired
    private AttributeService attributeService;

    @RequestMapping(value = "/attributes/{attributeId}", method = RequestMethod.GET)
    public Attribute selectAttributeById(@PathVariable Integer attributeId) {
        return attributeService.getAttributeById(attributeId);
    }
    @RequestMapping(value = "/attributes/{attributeId}", method = RequestMethod.DELETE)
    public int deleteAttribute(@PathVariable Integer attributeId) {
        return attributeService.deleteAttributeById(attributeId);
    }
}