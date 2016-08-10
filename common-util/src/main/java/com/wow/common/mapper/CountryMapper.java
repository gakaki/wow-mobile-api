package com.wow.common.mapper;

import com.wow.common.model.Country;

import java.util.List;

/**
 * Created by win7 on 2016/8/10.
 */
public interface CountryMapper {

    public List<Country> queryAllCountry();

    public Country queryCountryById(int id);
}
