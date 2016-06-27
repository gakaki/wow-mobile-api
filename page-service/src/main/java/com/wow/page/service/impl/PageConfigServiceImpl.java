package com.wow.page.service.impl;

import com.wow.page.model.PageBannerConfig;
import com.wow.page.model.PageSceneConfig;
import com.wow.page.model.PageTopicConfig;
import com.wow.page.service.PageConfigService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengzhiqing on 16/6/23.
 */
@Service
public class PageConfigServiceImpl implements PageConfigService {
    /**
     * 根据页面类型查询应该显示的Banner
     * @param pageType
     * @return
     */
    public List<PageBannerConfig> getBannersByPageType(int pageType) {
        return new ArrayList<PageBannerConfig>();
    }

    /**
     * 根据页面类型查询应该显示的场景
     * @param pageType
     * @return
     */
    public List<PageSceneConfig> getScenesByPageType(int pageType) {
        return new ArrayList<PageSceneConfig>();
    }

    /**
     * 根据页面类型查询应该显示的Topic
     * @param pageType
     * @return
     */
    public List<PageTopicConfig> getTopicsByPageType(int pageType) {
        return new ArrayList<PageTopicConfig>();
    }
}
