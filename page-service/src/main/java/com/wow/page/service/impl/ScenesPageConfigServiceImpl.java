package com.wow.page.service.impl;

import com.wow.page.mapper.PageSceneConfigMapper;
import com.wow.page.model.PageSceneConfig;
import com.wow.page.service.PageConfigService;
import com.wow.product.model.Scene;
import com.wow.product.service.ProductService;
import com.wow.product.service.SceneService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by fangying@wowdsgn on 2016/7/11.
 */
public class ScenesPageConfigServiceImpl implements  PageConfigService{
    @Autowired
    private SceneService sceneService;
    @Autowired
    private PageSceneConfigMapper pageSceneConfigMapper;

    public List<Scene> getByPageType(int pageType) throws Exception {
        List<PageSceneConfig> sceneList = pageSceneConfigMapper.selectByPageType(pageType);
        List<Scene> scenes=new ArrayList<>();
        if(!sceneList.isEmpty()) {
            sceneList.forEach(
                    new Consumer<PageSceneConfig>() {
                        @Override
                        public void accept(PageSceneConfig pageSceneConfig) {
                            Scene scene = sceneService.getSceneById(pageSceneConfig.getSceneId());
                            scene.setSceneImg("http://www.wowdsgn.com" + scene.getSceneImg());
                            if (scene != null)
                                scenes.add(scene);
                        }
                    });
        }
        return scenes;
    }
}
