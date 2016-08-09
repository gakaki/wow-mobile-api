package com.wow.product.service;


import com.wow.product.vo.response.TopicResponse;

/**
 * 专题服务
 * Created by zhengzhiqing on 16/6/17.
 */
public interface TopicService {
//    /**
//     * 创建专题
//     *
//     * @param topic
//     * @return
//     */
//    CommonResponse createTopic(Topic topic);
//
//    /**
//     * 更新专题信息
//     *
//     * @param topic
//     * @return
//     */
//    CommonResponse updateTopic(Topic topic);
//
//    /**
//     * 删除专题信息
//     *
//     * @param topicId
//     * @return
//     */
//    CommonResponse deleteTopic(int topicId);

//    /**
//     * 将产品分组绑定到专题
//     *
//     * @param topic
//     * @return
//     */
//    CommonResponse bindGroupToTopic(Topic topic);

    /**
     * 根据ID查询专题
     * @param topicId
     * @return
     */
    TopicResponse getTopicById(int topicId);



//    /**
//     * 查询所有专题
//     * @return
//     */
//    List<Topic> getAllTopics();

//    /**
//     * 增加在专题里随带展示的产品
//     * @param productShortListInTopics
//     * @return
//     */
//    int createProductShortListInTopic(List<ProductShortListInTopic> productShortListInTopics);

//    /**
//     * 修改在专题里随带展示的产品
//     * @param productShortListInTopics
//     * @return
//     */
//    int updateProductShortListInTopic(List<ProductShortListInTopic> productShortListInTopics);

//    /**
//     * 删除在专题里随带展示的产品
//     * @param productShortListInTopics
//     * @return
//     */
//    int deleteProductShortListInTopic(List<ProductShortListInTopic> productShortListInTopics);

//    /**
//     * 查询在专题里随带展示的产品
//     * @param topicId
//     * @return
//     */
//    List<ProductShortListInTopic> getProductShortListInTopic(int topicId);
}
