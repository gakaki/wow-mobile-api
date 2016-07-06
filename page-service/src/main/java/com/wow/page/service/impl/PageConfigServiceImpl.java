package com.wow.page.service.impl;

import com.wow.page.mapper.PageBannerConfigMapper;
import com.wow.page.mapper.PageSceneConfigMapper;
import com.wow.page.mapper.PageTopicConfigMapper;
import com.wow.page.model.PageBannerConfig;
import com.wow.page.model.PageSceneConfig;
import com.wow.page.model.PageTopicConfig;
import com.wow.page.service.PageConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public List<PageSceneConfig> getScenesByPageType(int pageType) {
        return pageSceneConfigMapper.selectByPageType(pageType);
    }

    /**
     * 根据页面类型查询应该显示的Topic
     * @param pageType
     * @return
     */
    @Override
    @Transactional(propagation= Propagation.SUPPORTS)
    @Cacheable(value = "PageCache",key="'TOPICS_IN_PAGE_TYPE_'+#pageType")
    public List<PageTopicConfig> getTopicsByPageType(int pageType) {
        return pageTopicConfigMapper.selectByPageType(pageType);
    }
}
