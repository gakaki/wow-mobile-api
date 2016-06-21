package com.wow.product.service;


import com.wow.product.model.Topic;
import com.wow.product.model.TopicDisplayRule;
import com.wow.product.model.TopicProductDisplayRule;

/**
 * 专题服务
 * Created by zhengzhiqing on 16/6/17.
 */
public interface TopicService {
    /**
     * 创建专题
     *
     * @param topic
     * @return
     */
    int createTopic(Topic topic);

    /**
     * 更新专题信息
     *
     * @param topic
     * @return
     */
    int updateTopic(Topic topic);

    /**
     * 将产品分组绑定到专题
     *
     * @param topic
     * @return
     */
    int bindGroupToTopic(Topic topic);

    /**
     * 在特定页面上显示专题的规则,包括显示哪些专题,排序是什么
     *
     * @param topicDisplayRule
     * @return
     */
    int createTopicDisplayRule(TopicDisplayRule topicDisplayRule);

    /**
     * 更新特定页面上显示专题的规则,包括显示哪些专题,排序是什么
     *
     * @param topicDisplayRule
     * @return
     */
    int updateTopicDisplayRule(TopicDisplayRule topicDisplayRule);

    /**
     * @param topicProductDisplayRule
     * @return
     */
    int createTopicProductDisplayRule(TopicProductDisplayRule topicProductDisplayRule);

    /**
     * @param topicProductDisplayRule
     * @return
     */
    int updateTopicProductDisplayRule(TopicProductDisplayRule topicProductDisplayRule);
}
