package com.wow.common.service;

import com.wow.common.model.Dictionary;
import com.wow.common.model.DictionaryExample;
import com.wow.common.request.DictionaryRequest;


import java.util.List;

/**
 * Created by win7 on 2016/7/27.
 */
public interface DictionaryService {

    /**
     *
     * @return
     */
    List<Dictionary> queryDictionary(DictionaryRequest dictionaryRequest);

}
