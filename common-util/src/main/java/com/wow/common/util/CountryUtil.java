package com.wow.common.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wow.common.factory.SpringBeanFactory;
import com.wow.common.mapper.CountryMapper;
import com.wow.common.model.Country;

/**
 * Created by win7 on 2016/8/10.
 */
public class CountryUtil {

    private static final CountryMapper countryMapper = SpringBeanFactory.getBean("countryMapper", CountryMapper.class);

    public static String getCountryById(int id) {
        Object v = RedisUtil.get("c_" + id);
        if (v == null) {
            Country country = countryMapper.queryCountryById(id);
            if (country == null)
                return null;
            v = country.getName();
            RedisUtil.set("c_" + id, country.getName());
        }
        return v.toString();
    }

    public static void addAllCountry(List<Country> list) {
        Map<Serializable, Object> map = new HashMap<Serializable, Object>(50);
        int count = 1;

        for (Country c : list) {
            if (count % 50 == 0) {
                RedisUtil.multiSet(map);
                map.clear();
            }
            
            map.put("c_" + c.getId(), c.getName());
            count++;
        }

    }

    public static void init() {
        addAllCountry(countryMapper.queryAllCountry());
    }

}
