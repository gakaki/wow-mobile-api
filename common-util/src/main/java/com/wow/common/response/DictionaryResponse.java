package com.wow.common.response;

import com.wow.common.model.Dictionary;

import java.util.List;

/**
 * Created by win7 on 2016/7/27.
 */
public class DictionaryResponse extends CommonResponse{

    private static final long serialVersionUID = 1L;

    private List<Dictionary> dictionaryList;

    public List<Dictionary> getDictionaryList() {
        return dictionaryList;
    }

    public void setDictionaryList(List<Dictionary> dictionaryList) {
        this.dictionaryList = dictionaryList;
    }
}
