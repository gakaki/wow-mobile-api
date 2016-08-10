package com.wow.common.service.impl;

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
    public List<Dictionary> queryDictionary(DictionaryRequest dictionaryRequest) {
        DictionaryExample example=new DictionaryExample();
        DictionaryExample.Criteria criteria=example.createCriteria();

        if(null!=dictionaryRequest.getKeyId())
            criteria.andKeyIdEqualTo(dictionaryRequest.getKeyId());
        if(null!=dictionaryRequest.getKeyGroup())
            criteria.andKeyGroupEqualTo(dictionaryRequest.getKeyGroup());
        criteria.andIsValidEqualTo(true);
        return dictionaryMapper.selectByExample(example);
    }
}
