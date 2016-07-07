package com.wow.product.service;


import com.wow.product.model.ProductShortListInTopic;
import com.wow.product.model.Topic;

import java.util.List;

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
     * 删除专题信息
     *
     * @param topicId
     * @return
     */
    int deleteTopic(int topicId);

    /**
     * 将产品分组绑定到专题
     *
     * @param topic
     * @return
     */
    int bindGroupToTopic(Topic topic);

    /**
     * 根据ID查询专题
     * @param topicId
     * @return
     */
    Topic getTopicById(int topicId) ;

    /**
     * 根据名称查询专题
     * @param topicName
     * @return
     */
    Topic getTopicByName(String topicName) throws Exception;

    /**
     * 查询所有专题
     * @return
     */
    List<Topic> getAllTopics();

    //table: product_short_list_in_topic

    /**
     * 增加在专题里随带展示的产品
     * @param productShortListInTopics
     * @return
     */
    int createProductShortListInTopic(List<ProductShortListInTopic> productShortListInTopics);

    /**
     * 修改在专题里随带展示的产品
     * @param productShortListInTopics
     * @return
     */
    int updateProductShortListInTopic(List<ProductShortListInTopic> productShortListInTopics);

    /**
     * 删除在专题里随带展示的产品
     * @param productShortListInTopics
     * @return
     */
    int deleteProductShortListInTopic(List<ProductShortListInTopic> productShortListInTopics);

    /**
     * 查询在专题里随带展示的产品
     * @param topicId
     * @return
     */
    List<ProductShortListInTopic> getProductShortListInTopic(int topicId);
}
