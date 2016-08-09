package com.wow.mobileapi.request.topic;

import com.wow.common.request.ApiRequest;

import javax.validation.constraints.NotNull;

/**
 * Created by win7 on 2016/8/5.
 */
public class TopicQueryRequest extends ApiRequest {

    private static final long serialVersionUID = 1L;
    @NotNull
    private Integer topicId;

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }
}
