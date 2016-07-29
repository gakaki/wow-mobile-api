package com.wow.page.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wow.common.constant.BizConstant;
import com.wow.common.util.CollectionUtil;
import com.wow.common.util.ErrorCodeUtil;
import com.wow.common.util.MapUtil;
import com.wow.page.mapper.PageBannerConfigMapper;
import com.wow.page.mapper.PageCategoryConfigMapper;
import com.wow.page.mapper.PageProductConfigMapper;
import com.wow.page.mapper.PageSceneConfigMapper;
import com.wow.page.mapper.PageTopicConfigMapper;
import com.wow.page.model.PageBannerConfig;
import com.wow.page.model.PageBannerConfigExample;
import com.wow.page.model.PageSceneConfig;
import com.wow.page.model.PageTopicConfig;
import com.wow.page.service.PageConfigService;
import com.wow.page.vo.PageCategoryVo;
import com.wow.page.vo.PageProductNewVo;
import com.wow.page.vo.PageProductVo;
import com.wow.page.vo.PageTopicVo;
import com.wow.page.vo.ProductImageVo;
import com.wow.page.vo.response.PageBannerResponse;
import com.wow.page.vo.response.PageCategoryResponse;
import com.wow.page.vo.response.PageProductResponse;
import com.wow.page.vo.response.PageSceneResponse;
import com.wow.page.vo.response.PageTopicResponse;
import com.wow.price.model.ProductPrice;
import com.wow.price.service.PriceService;
import com.wow.price.vo.ProductListPriceResponse;
import com.wow.product.model.ProductImage;
import com.wow.product.model.ProductShortListInTopic;
import com.wow.product.model.Scene;
import com.wow.product.model.Topic;
import com.wow.product.service.ProductService;
import com.wow.product.service.SceneService;
import com.wow.product.service.TopicService;


/**
 * Created by zhengzhiqing on 16/6/23.
 */
@Service
@Transactional("pageTransactionManager")
public class PageConfigServiceImpl implements PageConfigService {

    private static final Logger logger = LoggerFactory.getLogger(PageConfigServiceImpl.class);


    @Autowired
    private PageBannerConfigMapper pageBannerConfigMapper;
    @Autowired
    private PageSceneConfigMapper pageSceneConfigMapper;
    @Autowired
    private PageTopicConfigMapper pageTopicConfigMapper;
    @Autowired
    private PageProductConfigMapper pageProductConfigMapper;
    @Autowired
    private PageCategoryConfigMapper pageCategoryConfigMapper;

    @Autowired
    private TopicService topicService;
    @Autowired
    private ProductService productService;
    @Autowired
    private SceneService sceneService;
    @Autowired
    private PriceService priceService;

    /**
     * 根据页面类型查询应该显示的Banner
     * @param pageType
     * @return
     */
    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
//    @Cacheable(value = "PageCache",key="'BANNERS_IN_PAGE_TYPE_'+#pageType")
    public PageBannerResponse getBannersByPageType(byte pageType) {
        PageBannerResponse pageBannerResponse = new PageBannerResponse();
        PageBannerConfigExample pageBannerConfigExample = new PageBannerConfigExample();
        pageBannerConfigExample.setOrderByClause("page_module_type asc, sort_order asc");
        PageBannerConfigExample.Criteria criteria = pageBannerConfigExample.createCriteria();
        criteria.andPageTypeEqualTo(pageType);
        criteria.andIsEnabledEqualTo(true);
        Date now = new Date();
        criteria.andActiveFromLessThanOrEqualTo(now);
        criteria.andActiveToGreaterThan(now);

        List<PageBannerConfig> pageBannerConfigList = pageBannerConfigMapper.selectByExample(pageBannerConfigExample);
        if (CollectionUtil.isNotEmpty(pageBannerConfigList)) {
            pageBannerResponse.setPageBannerConfigList(pageBannerConfigList);
        } else {
            pageBannerResponse.setResCode("50301");
            pageBannerResponse.setResMsg(ErrorCodeUtil.getErrorMsg("50301"));
        }
        return pageBannerResponse;
    }

    /**
     * 根据页面类型查询应该显示的场景
     * @param pageType
     * @return
     */
    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    @Cacheable(value = "PageCache",key="'SCENES_IN_PAGE_TYPE_'+#pageType")
    public PageSceneResponse getScenesByPageType(int pageType) {
        PageSceneResponse pageSceneResponse = new PageSceneResponse();
        List<PageSceneConfig> pageSceneConfigList =  pageSceneConfigMapper.selectByPageType(pageType);
        List<Scene> scenes =new ArrayList<>();
        if (CollectionUtil.isNotEmpty(pageSceneConfigList)) {
            for (PageSceneConfig pageSceneConfig : pageSceneConfigList) {
                Scene scene = sceneService.getSceneById(pageSceneConfig.getSceneId());
                if (scene != null) {
                    scenes.add(scene);
                }
            }
            pageSceneResponse.setSceneList(scenes);
        } else {
            pageSceneResponse.setResCode("50302");
            pageSceneResponse.setResMsg(ErrorCodeUtil.getErrorMsg("50302"));
        }
        return pageSceneResponse;
    }

    /**
     * 根据页面类型查询应该显示的Topic
     * @param pageType
     * @return
     */
    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    @Cacheable(value = "PageCache",key="'TOPICS_IN_PAGE_TYPE_'+#pageType")
    public PageTopicResponse getTopicsByPageType(int pageType) {
        PageTopicResponse pageTopicResponse = new PageTopicResponse();
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
        pageTopicResponse.setPageTopicVoList(pageTopicVos);
        return pageTopicResponse;
    }

    /**
     * 根据页面类型查询页面上的商品配置
     * 针对page_module_type(本周上新)
     * 按是否有效和顺序展示,最多10个
     * 如果发现不足10个(包括0个),自动获取最新上线的商品,补足
     *
     * 单品推荐的也一并返回
     *
     * @param pageType
     * @param moduleType
     * @return
     */
    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public PageProductResponse getProductsOnPage(int pageType,List<Byte> moduleType) {
        PageProductResponse pageProductResponse = new PageProductResponse();
        List<PageProductVo> pageProductList = pageProductConfigMapper.selectFindPageProduct(pageType);
        if(pageProductList.size()>0){
        	PageProductVo recommendProduct = new PageProductVo();
            List<PageProductNewVo> pageProductNewVoList = new ArrayList<PageProductNewVo>();
            List<Integer> productIds = new ArrayList<Integer>();
            for(PageProductVo pageProductVo:pageProductList){
            	productIds.add(pageProductVo.getProductId());
            }
            
            //批量查询价格
            ProductListPriceResponse batchGetProductPrice = priceService.batchGetProductPrice(productIds);
            Map<Integer, ProductPrice> priceMap = new HashMap<Integer, ProductPrice>();
            if (batchGetProductPrice != null && MapUtil.isNotEmpty(batchGetProductPrice.getMap())) {
                priceMap = batchGetProductPrice.getMap();
            }
            
            //批量查询主图
            Map<Integer, ProductImage> productImageMap = productService.selectProductListPrimaryOneImg(productIds);

            for(PageProductVo pageProductVo:pageProductList){
                PageProductNewVo productNewVo = new PageProductNewVo();
                if(pageProductVo.getPageModuleType() == BizConstant.PAGE_MODULE_TYPE_PRODUCT){
                    if(priceMap.get(pageProductVo.getProductId())!=null) {
                    	recommendProduct = pageProductVo;
                    	if(MapUtil.isNotEmpty(productImageMap) && productImageMap.get(pageProductVo.getProductId()) != null){
                    		recommendProduct.setProductImg(productImageMap.get(pageProductVo.getProductId()).getImgUrl());
                    	}
                    	if(MapUtil.isNotEmpty(priceMap) && priceMap.get(pageProductVo.getProductId()) != null){
    	                	recommendProduct.setSellPrice(priceMap.get(pageProductVo.getProductId()).getSellPrice());
    	                	recommendProduct.setOriginalPrice(priceMap.get(pageProductVo.getProductId()).getOriginalPrice());
                    	}
                    }
                }else if(pageProductVo.getPageModuleType() == BizConstant.PAGE_MODULE_TYPE_PRODUCT_NEWARRIVAL){
                    if(priceMap.get(pageProductVo.getProductId())!=null) {
                        productNewVo.setProductId(pageProductVo.getProductId());
                        productNewVo.setProductName(pageProductVo.getProductName());
                    	if(MapUtil.isNotEmpty(productImageMap) && productImageMap.get(pageProductVo.getProductId()) != null){
                    		productNewVo.setProductImg(productImageMap.get(pageProductVo.getProductId()).getImgUrl());
                    	}
                    	if(MapUtil.isNotEmpty(priceMap) && priceMap.get(pageProductVo.getProductId()) != null){
                    		productNewVo.setSellPrice(priceMap.get(pageProductVo.getProductId()).getSellPrice());
                    	}
                    }
                    pageProductNewVoList.add(productNewVo);
                }
            }
            
            pageProductResponse.setRecommendProduct(recommendProduct);
            pageProductResponse.setPageNewProductVoList(pageProductNewVoList);
        }
        
        return pageProductResponse;
    }

    /**
     * 根据页面类型查询页面上的分类配置
     *
     * @param pageType
     * @return
     */
    @Override
    public PageCategoryResponse getCategoriesOnPage(int pageType,int level) {
    	PageCategoryResponse pageCategoryResponse = new PageCategoryResponse();
    	List<PageCategoryVo> categoryList = pageCategoryConfigMapper.selectByParentCategoryId(pageType,level);
    	pageCategoryResponse.setPageCategoryVoList(categoryList);
        return pageCategoryResponse;
    }


}
