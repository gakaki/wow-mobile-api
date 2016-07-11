package com.wow.page.service.impl;

import com.wow.page.mapper.PageBannerConfigMapper;
import com.wow.page.model.PageBannerConfig;
import com.wow.page.service.PageConfigService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by fangying@wowdsgn on 2016/7/11.
 */
public class BannerPageConfigServiceImpl implements PageConfigService{

    @Autowired
    private PageBannerConfigMapper pageBannerConfigMapper;

    @Override
    public List<PageBannerConfig> getByPageType(int pageType) throws Exception {
        return pageBannerConfigMapper.selectByPageType(pageType);
    }
}
