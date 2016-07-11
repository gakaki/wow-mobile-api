package com.wow.page.service.impl;

import com.wow.page.mapper.PageTopicConfigMapper;
import com.wow.page.model.PageBannerConfig;
import com.wow.page.model.PageSceneConfig;
import com.wow.page.model.PageTopicConfig;
import com.wow.page.service.PageConfigService;
import com.wow.page.vo.PageTopicVo;
import com.wow.page.vo.ProductImageVo;
import com.wow.product.model.ProductImage;
import com.wow.product.model.ProductShortListInTopic;
import com.wow.product.model.Topic;
import com.wow.product.service.ProductService;
import com.wow.product.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by fangying@wowdsgn on 2016/7/11.
 */
public class TopicsPageConfigServiceImpl implements  PageConfigService {

    @Autowired
    private PageTopicConfigMapper pageTopicConfigMapper;

    @Autowired
    private TopicService topicService;
    @Autowired
    private ProductService productService;

    public List<PageTopicVo> getByPageType(int pageType) throws Exception {
        List<PageTopicConfig> topicList = pageTopicConfigMapper.selectByPageType(pageType);
        List<PageTopicVo> pageTopicVos=new ArrayList<>();
        if(!topicList.isEmpty())
            topicList.forEach(new Consumer<PageTopicConfig>() {
                @Override
                public void accept(PageTopicConfig pageTopicConfig) {
                    Topic topic= topicService.getTopicById(pageTopicConfig.getTopicId());
                    if(topic!=null) {
                        PageTopicVo pageTopicVo=new PageTopicVo();
                        pageTopicVo.setGroupId(topic.getGroupId());
                        pageTopicVo.setId(topic.getId());
                        pageTopicVo.setTopicContentDetails(topic.getTopicContentDetails());
                        pageTopicVo.setTopicDesc(topic.getTopicDesc());
                        pageTopicVo.setTopicImg(topic.getTopicImg());
                        pageTopicVo.setTopicImgLink(topic.getTopicImgLink());
                        pageTopicVo.setTopicMainTitle(topic.getTopicMainTitle());
                        pageTopicVo.setTopicName(topic.getTopicName());
                        pageTopicVo.setTopicType(topic.getTopicType());
                        List<ProductImageVo> productImageVos=new ArrayList<ProductImageVo>();
                        List<ProductShortListInTopic> productShortListInTopics=topicService.getProductShortListInTopic(topic.getId());
                        topicService.getProductShortListInTopic(topic.getId()).stream().filter(o->o.getShortListInTopic()==true).toArray();
                        if(!productShortListInTopics.isEmpty()) {
                            productShortListInTopics.forEach(new Consumer<ProductShortListInTopic>() {
                                @Override
                                public void accept(ProductShortListInTopic productShortListInTopic) {
                                    if (productShortListInTopic.getShortListInTopic()) {
                                        List<ProductImage> productImages = productService.getProductImages(productShortListInTopic.getProductId());
                                        if (!productImages.isEmpty()) {
                                            productImages.forEach(new Consumer<ProductImage>() {
                                                @Override
                                                public void accept(ProductImage productImage) {
                                                    ProductImageVo productImageVo = new ProductImageVo();
                                                    productImageVo.setGroupId(productShortListInTopic.getGroupId());
                                                    productImageVo.setSortOrder(productShortListInTopic.getSortOrder());
                                                    productImageVo.setProductId(productShortListInTopic.getProductId());
                                                    productImageVo.setImgDesc(productImage.getImgDesc());
                                                    productImageVo.setImgName(productImage.getImgName());
                                                    productImageVo.setImgUrl(productImage.getImgUrl());
                                                    productImageVo.setViewPlatform(productImage.getViewPlatform());
                                                    productImageVos.add(productImageVo);
                                                }
                                            });
                                        }
                                    }
                                }
                            });
                        }
                        pageTopicVo.setImages(productImageVos);
                        pageTopicVos.add(pageTopicVo);
                    }
                }
            });
        return pageTopicVos;
    }
}
