package com.wow.page.service;

import java.util.List;

import com.wow.page.vo.response.PageBannerResponse;
import com.wow.page.vo.response.PageCategoryResponse;
import com.wow.page.vo.response.PageProductResponse;
import com.wow.page.vo.response.PageSceneResponse;
import com.wow.page.vo.response.PageTopicResponse;


/**
 * Created by zhengzhiqing on 16/6/23.
 */
public interface PageConfigService {
    /**
     * 根据页面类型查询应该显示的Banner
     * @param pageType
     * @return
     */
    PageBannerResponse getBannersByPageType(byte pageType);

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

    /**
     * 根据页面类型查询页面上的商品配置
     * @param pageType
     * @param moduleType
     * @param moduleNewType
     * @return
     */
    PageProductResponse getProductsOnPage(int pageType,List<Byte> moduleType);

    /**
     * 根据页面类型查询页面上的分类配置
     * @param pageType
     * @param level
     * @return
     */
    PageCategoryResponse getCategoriesOnPage(int pageType,int level);

}
