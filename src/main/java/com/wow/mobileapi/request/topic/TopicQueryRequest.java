package com.wow.mobileapi.request.topic;

import com.wow.common.request.ApiRequest;

/**
 * Created by win7 on 2016/8/5.
 */
public class TopicQueryRequest extends ApiRequest {

    private static final long serialVersionUID = 1L;

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
