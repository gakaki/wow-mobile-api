package com.wow.common.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.wow.common.mapper.DictionaryMapper;
import com.wow.common.model.Dictionary;
import com.wow.common.model.DictionaryExample;
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
    public List<Dictionary> queryDictionary(DictionaryExample example) {
        return dictionaryMapper.selectByExample(example);
    }

    @Override
    public int updateDictionary(Dictionary dictionary,DictionaryExample example) {
        return dictionaryMapper.updateByExampleSelective(dictionary,example);
    }
}
