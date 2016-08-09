package com.wow.product.service.impl;

import com.wow.common.util.BeanUtil;
import com.wow.product.mapper.TopicMapper;
import com.wow.product.model.Topic;
import com.wow.product.service.TopicService;
import com.wow.product.vo.response.TopicResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by fangying@wowdsgn on 2016/7/7.
 */
@Service
@Transactional(value = "productTransactionManager")
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicMapper topicMapper;

//    @Autowired
//    private ProductShortListInTopicMapper productShortListInTopicMapper;

//    @Override
//    public CommonResponse createTopic(Topic topic) {
//        return topicMapper.insertSelective(topic);
//    }
//
//    @Override
//    public CommonResponse updateTopic(Topic topic) {
//        return topicMapper.updateByPrimaryKeySelective(topic);
//    }
//
//    @Override
//    public CommonResponse deleteTopic(int topicId) {
//        Topic topic= getTopicById(topicId);
//        if(topic!=null) {
//            topic.setIsDeleted(true);
//            return updateTopic(topic);
//        }
//        return 0;
//    }
//    /**
//     * 将产品分组绑定到专题
//     *
//     * @param topic
//     * @return
//     */
//    @Override
//    public CommonResponse bindGroupToTopic(Topic topic) {
//        return 0;
//    }

    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public TopicResponse getTopicById(int topicId) {
        TopicResponse topicResponse = new TopicResponse();
        Topic topic =  topicMapper.selectByPrimaryKey(topicId);
        BeanUtil.copyProperties(topic, topicResponse);
        return topicResponse;
    }

//    @Override
//    @Transactional(propagation= Propagation.NOT_SUPPORTED)
//    public Topic getTopicByName(String topicName) throws Exception{
//
//            TopicExample topicExample=new TopicExample();
//            topicExample.or().andTopicNameEqualTo(topicName).andIsDeletedEqualTo(false);
//            return topicMapper.selectByExample(topicExample).get(0);
//    }
//
//    @Override
//    @Transactional(propagation= Propagation.NOT_SUPPORTED)
//    public List<Topic> getAllTopics() {
//        return topicMapper.selectAll();
//    }
//
//    @Override
//    public int createProductShortListInTopic(List<ProductShortListInTopic> productShortListInTopics) {
//        if(!productShortListInTopics.isEmpty())
//            for(ProductShortListInTopic productShortListInTopic:productShortListInTopics)
//            {
//                productShortListInTopicMapper.insertSelective(productShortListInTopic);
//            }
//        return 0;
//    }
//
//    @Override
//    public int updateProductShortListInTopic(List<ProductShortListInTopic> productShortListInTopics) {
//        if(!productShortListInTopics.isEmpty())
//            for(ProductShortListInTopic productShortListInTopic:productShortListInTopics)
//            {
//                productShortListInTopicMapper.updateByPrimaryKeySelective(productShortListInTopic);
//            }
//        return 0;
//    }
//
//    @Override
//    public int deleteProductShortListInTopic(List<ProductShortListInTopic> productShortListInTopics) {
//        if(!productShortListInTopics.isEmpty()) {
//            for(ProductShortListInTopic productShortListInTopic:productShortListInTopics)
//            {
//                productShortListInTopic.setIsDeleted(true);
//            }
//            updateProductShortListInTopic(productShortListInTopics);
//        }
//        return 0;
//    }
//
//    @Override
//    @Transactional(propagation= Propagation.NOT_SUPPORTED)
//    public List<ProductShortListInTopic> getProductShortListInTopic(int topicId) {
//        ProductShortListInTopicExample productShortListInTopicExample=new ProductShortListInTopicExample();
//        productShortListInTopicExample.or().andIsDeletedEqualTo(false).andTopicIdEqualTo(topicId);
//        return productShortListInTopicMapper.selectByExample(productShortListInTopicExample);
//    }
}
