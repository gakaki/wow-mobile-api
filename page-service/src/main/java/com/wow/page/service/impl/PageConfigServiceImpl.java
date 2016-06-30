package com.wow.page.service.impl;

import com.wow.page.mapper.PageBannerConfigMapper;
import com.wow.page.mapper.PageSceneConfigMapper;
import com.wow.page.mapper.PageTopicConfigMapper;
import com.wow.page.model.PageBannerConfig;
import com.wow.page.model.PageSceneConfig;
import com.wow.page.model.PageTopicConfig;
import com.wow.page.service.PageConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengzhiqing on 16/6/23.
 */
@Service
public class PageConfigServiceImpl implements PageConfigService {

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
    public List<PageBannerConfig> getBannersByPageType(int pageType) {
        return pageBannerConfigMapper.selectByPageType(pageType);
    }

    /**
     * 根据页面类型查询应该显示的场景
     * @param pageType
     * @return
     */
    public List<PageSceneConfig> getScenesByPageType(int pageType) {
        return pageSceneConfigMapper.selectByPageType(pageType);
    }

    /**
     * 根据页面类型查询应该显示的Topic
     * @param pageType
     * @return
     */
    public List<PageTopicConfig> getTopicsByPageType(int pageType) {
        return pageTopicConfigMapper.selectByPageType(pageType);
    }
}
