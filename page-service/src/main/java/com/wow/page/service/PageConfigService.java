package com.wow.page.service;

import com.wow.page.model.PageBannerConfig;


import com.wow.page.vo.PageTopicVo;
import com.wow.page.vo.response.SerialResponse;
import com.wow.product.model.Scene;


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
    List<PageBannerConfig>  getBannersByPageType(int pageType);

    /**
     * 根据页面类型查询应该显示的场景
     * @param pageType
     * @return
     */
    List<Scene> getScenesByPageType(int pageType);

    /**
     * 根据页面类型查询应该显示的Topic
     * @param pageType
     * @return
     */
    List<PageTopicVo> getTopicsByPageType(int pageType);

    List<SerialResponse> getSerialByPageType(int pageType) throws Exception;
}
