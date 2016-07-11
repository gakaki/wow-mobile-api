package com.wow.page.service.impl;

import com.wow.page.pageEnum.PageType;
import com.wow.page.service.PageConfigService;
import com.wow.page.service.PageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;


/**
 * Created by fangying@wowdsgn on 2016/7/11.
 */
@Service
@Transactional("pageTransactionManager")
public class PageServiceImpl implements PageService{

    private static final Logger logger = LoggerFactory.getLogger(PageServiceImpl.class);
    private  static  final    String suffix="PageConfigServiceImpl";
    @Override
    @Transactional(propagation= Propagation.SUPPORTS)
    @Cacheable(value = "PageCache",key="'PAGE_TYPE_'+#pageType")
    public Object getByPageType(int pageType) throws Exception {

        PageType type=PageType.values()[pageType];
        Assert.isNull(type,"找不到该类型");
        logger.info("详情页查询："+type.getName());
        String  className= type+suffix;
        try {
             Object o =Class.forName(className);
            if(o instanceof PageConfigService )
            {
               return ((PageConfigService)o).getByPageType(pageType);
            }
        }
       catch (Exception e)
       {
           e.printStackTrace();
           logger.error("详情页查询失败：pageType"+type.getName()+" ;出错信息："+e);
       }

        return null;
    }
}
