package com.wow.common.service;

import com.wow.common.model.Country;

import java.util.List;

/**
 * Created by win7 on 2016/8/10.
 */
public interface CountryService {

    /**
     * 获取所有可用国家
     * @return
     */
    List<Country> queryAllCountry();
}
