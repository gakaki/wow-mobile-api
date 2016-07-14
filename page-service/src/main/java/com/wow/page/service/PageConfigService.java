package com.wow.page.service;

import com.wow.page.vo.response.PageBannerResponse;
import com.wow.page.vo.response.PageSceneResponse;
import com.wow.page.vo.response.PageTopicResponse;

import java.util.List;


/**
 * Created by zhengzhiqing on 16/6/23.
 */
public interface PageConfigService {
    /**
     * 根据页面类型查询应该显示的Banner
     * @param pageType
     * @return
     */
    PageBannerResponse getBannersByPageType(int pageType);

    /**
     * 根据页面类型查询应该显示的场景
     * @param pageType
     * @return
     */
    PageSceneResponse getScenesByPageType(int pageType);

    /**
     * 根据页面类型查询应该显示的Topic
     * @param pageType
     * @return
     */
    PageTopicResponse getTopicsByPageType(int pageType);

}
