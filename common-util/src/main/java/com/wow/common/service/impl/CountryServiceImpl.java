package com.wow.common.service.impl;

import com.wow.common.mapper.CountryMapper;
import com.wow.common.model.Country;
import com.wow.common.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by win7 on 2016/8/10.
 */
@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryMapper countryMapper;

    @Override
    public List<Country> queryAllCountry() {
        return countryMapper.queryAllCountry();
    }
}
