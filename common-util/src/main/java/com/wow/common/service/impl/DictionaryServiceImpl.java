package com.wow.common.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.wow.common.mapper.DictionaryMapper;
import com.wow.common.model.Dictionary;
import com.wow.common.model.DictionaryExample;
import com.wow.common.request.DictionaryRequest;
import com.wow.common.service.DictionaryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by win7 on 2016/7/27.
 */
@Service
public class DictionaryServiceImpl implements DictionaryService {

    private static final Logger logger = LoggerFactory.getLogger(DictionaryServiceImpl.class);

    @Autowired
    private DictionaryMapper dictionaryMapper;

    @Override
    public int createDictionary(Dictionary dictionary) {
        return dictionaryMapper.insertSelective(dictionary);
    }

    @Override
    public int deleteDictionary(int dictionaryId) {
        return dictionaryMapper.deleteByPrimaryKey(dictionaryId);
    }

    @Override
    public List<Dictionary> queryDictionary(DictionaryRequest dictionaryRequest) {
        DictionaryExample example=new DictionaryExample();
        DictionaryExample.Criteria criteria=example.createCriteria();
        if(null!=dictionaryRequest.getIdCon())
            criteria.andIdEqualTo(dictionaryRequest.getIdCon());
        if(null!=dictionaryRequest.getKeyNameCon())
            criteria.andKeyNameEqualTo(dictionaryRequest.getKeyNameCon());
        if(null!=dictionaryRequest.getKeyValueCon())
            criteria.andKeyValueEqualTo(dictionaryRequest.getKeyValueCon());
        if(null!=dictionaryRequest.getKeyGroupCon())
            criteria.andKeyGroupEqualTo(dictionaryRequest.getKeyGroupCon());
        if(null!=dictionaryRequest.getKeyOrderCon())
            criteria.andKeyOrderEqualTo(dictionaryRequest.getKeyOrderCon());
        criteria.andIsValidEqualTo(true);
        return dictionaryMapper.selectByExample(example);
    }

    @Override
    public int updateDictionary(Dictionary dictionary,DictionaryRequest dictionaryRequest) {
        DictionaryExample example=new DictionaryExample();
        DictionaryExample.Criteria criteria=example.createCriteria();
        if(null!=dictionaryRequest.getIdCon())
            criteria.andIdEqualTo(dictionaryRequest.getIdCon());
        if(null!=dictionaryRequest.getKeyNameCon())
            criteria.andKeyNameEqualTo(dictionaryRequest.getKeyNameCon());
        if(null!=dictionaryRequest.getKeyValueCon())
            criteria.andKeyValueEqualTo(dictionaryRequest.getKeyValueCon());
        if(null!=dictionaryRequest.getKeyGroupCon())
            criteria.andKeyGroupEqualTo(dictionaryRequest.getKeyGroupCon());
        if(null!=dictionaryRequest.getKeyOrderCon())
            criteria.andKeyOrderEqualTo(dictionaryRequest.getKeyOrderCon());
        if(dictionaryRequest.getValidCon()!=null)
            criteria.andIsValidEqualTo(dictionaryRequest.getValidCon());
        return dictionaryMapper.updateByExampleSelective(dictionary,example);
    }
}
