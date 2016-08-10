package com.wow.common.util;

import com.wow.common.factory.SpringBeanFactory;
import com.wow.common.mapper.CountryMapper;
import com.wow.common.model.BaseMaterial;
import com.wow.common.model.Country;
import com.wow.common.service.BaseMaterialService;
import com.wow.common.service.CountryService;

import java.util.List;

/**
 * Created by win7 on 2016/8/10.
 */
public class CountryUtil {

    private static final CountryMapper countryMapper = SpringBeanFactory
            .getBean("countryMapper", CountryMapper.class);

    public static String getCountryById(int id){
        return RedisUtil.get("c_"+id).toString();
    }

    public static void addAllCountry(List<Country> list){
        for(Country c:list)
            RedisUtil.set("c_"+c.getId(),c.getName());
    }

    public static void init(){
        addAllCountry(countryMapper.queryAllCountry());
    }
}
