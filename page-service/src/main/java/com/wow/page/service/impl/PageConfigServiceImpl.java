package com.wow.page.service.impl;

import com.wow.common.util.CollectionUtil;
import com.wow.page.mapper.PageBannerConfigMapper;
import com.wow.page.mapper.PageProductConfigMapper;
import com.wow.page.mapper.PageSceneConfigMapper;
import com.wow.page.mapper.PageTopicConfigMapper;
import com.wow.page.model.PageBannerConfig;
import com.wow.page.model.PageProductConfig;
import com.wow.page.model.PageSceneConfig;
import com.wow.page.model.PageTopicConfig;
import com.wow.page.service.PageConfigService;
import com.wow.page.vo.PageTopicVo;
import com.wow.page.vo.ProductImageVo;
import com.wow.page.vo.response.SerialResponse;
import com.wow.product.model.*;
import com.wow.product.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;


/**
 * Created by zhengzhiqing on 16/6/23.
 */
@Service
@Transactional("pageTransactionManager")
public class PageConfigServiceImpl implements PageConfigService {

    private static final Logger logger = LoggerFactory.getLogger(PageConfigServiceImpl.class);

    //系列品主图数量限制
    private  static final  Integer serialBannerCount=5;
    @Autowired
    private PageBannerConfigMapper pageBannerConfigMapper;
    @Autowired
    private PageSceneConfigMapper pageSceneConfigMapper;
    @Autowired
    private PageTopicConfigMapper pageTopicConfigMapper;
    @Autowired
    private  PageProductConfigMapper pageProductConfigMapper;
    @Autowired
    private TopicService topicService;
    @Autowired
    private ProductService productService;
    @Autowired
    private SceneService sceneService;
    @Autowired
    private  ProductSerialService productSerialService;
    @Autowired
    private  BrandService brandService;
    @Autowired
    private  DesignerService designerService;
    /**
     * 根据页面类型查询应该显示的Banner
     * @param pageType
     * @return
     */
    @Override
    @Transactional(propagation= Propagation.SUPPORTS)
    @Cacheable(value = "PageCache",key="'BANNERS_IN_PAGE_TYPE_'+#pageType")
    public List<PageBannerConfig> getBannersByPageType(int pageType) {
        return pageBannerConfigMapper.selectByPageType(pageType);
    }

    /**
     * 根据页面类型查询应该显示的场景
     * @param pageType
     * @return
     */
    @Override
    @Transactional(propagation= Propagation.SUPPORTS)
    @Cacheable(value = "PageCache",key="'SCENES_IN_PAGE_TYPE_'+#pageType")
    public List<Scene> getScenesByPageType(int pageType) {
        List<PageSceneConfig> sceneList = pageSceneConfigMapper.selectByPageType(pageType);
        List<Scene> scenes=new ArrayList<>();
       if(CollectionUtil.isNotEmpty(sceneList))
           sceneList.forEach(
                new Consumer<PageSceneConfig>() {
                    @Override
                    public void accept(PageSceneConfig pageSceneConfig) {
                        Scene scene= sceneService.getSceneById(pageSceneConfig.getSceneId());
                        if(scene!=null)
                            scenes.add(scene);
                    }
                });
        return scenes;
    }

    /**
     * 根据页面类型查询应该显示的Topic
     * @param pageType
     * @return
     */
    @Override
    @Transactional(propagation= Propagation.SUPPORTS)
    @Cacheable(value = "PageCache",key="'TOPICS_IN_PAGE_TYPE_'+#pageType")
    public List<PageTopicVo> getTopicsByPageType(int pageType) {
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
                                                    productImageVo.setProductId(productImageVo.getProductId());
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

    @Override
    public List<SerialResponse> getSerialByPageType(int pageType) throws Exception {
        List<PageProductConfig> pageProductConfigs= pageProductConfigMapper.selectByPageType(pageType);
        if(CollectionUtil.isNotEmpty(pageProductConfigs))
        {
            List<SerialResponse> serialResponses=new ArrayList<>();
            HashSet<Integer> set=new HashSet();
            pageProductConfigs.forEach(new Consumer<PageProductConfig>() {
                @Override
                public void accept(PageProductConfig pageProductConfig) {
                        set.add(pageProductConfig.getProductId());
                }
            });
            for (Integer productId:set) {
                SerialResponse serialResponse = getSerialByProductId(productId);
                if(serialResponse!=null)
                    serialResponses.add(serialResponse);
            }
            return serialResponses;
        }
        return null;
    }


    private  SerialResponse getSerialByProductId(Integer productId) throws Exception
    {
        if(!productSerialService.isProductSerial(productId))
            return null;
        SerialResponse serialResponse=new SerialResponse();
        Product product=productService.getProductById(productId);
        if(product!=null)
        {
            serialResponse.setProductName(product.getProductName());
            serialResponse.setTips(product.getTips());
            serialResponse.setDescribe(product.getDetailDescription());
            serialResponse.setVerboseInfo(product.getVerboseInfo());
            serialResponse.setApplicableScene(product.getApplicableScene());
            serialResponse.setOrigin(product.getOriginCountry()+product.getOriginText());
            serialResponse.setWeight(product.getWeight());
            serialResponse.setMaterial(product.getMaterial());
            serialResponse.setSpec(product.getSpec());
            serialResponse.setNeedAssemble(product.getNeedAssemble());
            serialResponse.setStyle(product.getStyle());
            serialResponse.setSellingPoint(product.getSellingPoint());
            Brand brand=  brandService.getBrandById(product.getBrandId());
            if(brand!=null)
            {
                serialResponse.setBrandName(brand.getBrandCname());
                serialResponse.setBrandLogo(brand.getBrandLogoImg());
            }
            Designer designer= designerService.getPrimaryDesignerByProduct(product);
            if(designer!=null)
            {
                serialResponse.setDesignerName(designer.getDesignerName());
                serialResponse.setDesignerLogo(designer.getDesignerPhoto());
            }

            List<ProductImage> productImages=  productService.getProductImages(productId);
            if(CollectionUtil.isNotEmpty(productImages))
            {
                List<String> list=new ArrayList<>();
                Map<String,String> map=new HashMap<>();
                for (ProductImage productImage:productImages)
                {
                    if(productImage.getIsPrimary() && list.size()<serialBannerCount)
                      list.add(productImage.getImgUrl());
                    if(!productImage.getIsPrimary())
                        map.put(productImage.getImgUrl(),productImage.getImgDesc());
                }
                serialResponse.setBanner(list);
            }
            ProductPrice productPrice= productService.getProductPrice(productId);
            if(productPrice!=null)
            {
                serialResponse.setSellPrice(productPrice.getSellPrice());
                serialResponse.setOriginalPrice(productPrice.getOriginalPrice());
            }
        }
        return  serialResponse;
    }

}
