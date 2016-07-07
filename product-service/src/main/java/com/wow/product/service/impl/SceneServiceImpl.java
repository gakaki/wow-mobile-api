package com.wow.product.service.impl;

import com.wow.product.mapper.SceneMapper;
import com.wow.product.model.Scene;
import com.wow.product.model.SceneExample;
import com.wow.product.service.ProductCombineService;
import com.wow.product.service.SceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by fangying@wowdsgn on 2016/7/7.
 */
@Service
@Transactional(value = "productTransactionManager")
public class SceneServiceImpl implements SceneService {
    @Autowired
    private SceneMapper sceneMapper;
    @Autowired
    private ProductCombineService productCombineService;
    @Override
    public int createScene(Scene scene) {
        return sceneMapper.insertSelective(scene);
    }

    @Override
    public Scene getSceneById(int sceneId) {
        return sceneMapper.selectByPrimaryKey(sceneId);
    }

    @Override
    public int updateScene(Scene scene) {
        return sceneMapper.updateByPrimaryKeySelective(scene);
    }

    @Override
    public int deleteScene(Scene scene) {
        if(scene!=null) {
            scene.setIsDeleted(true);
            return updateScene(scene);
        }
        return 0;
    }

    /**
     * 绑定组合产品到一个场景(场景本质上就是一个组合产品) (好像并不需要这样一个方法)
     * @param scene
     * @param productId  组合产品ID
     * @return
     */
    @Override
    public int bindProductCombineIntoScene(Scene scene,int productId) {
        if(scene!=null) {
            scene.setProductId(productId);
            return updateScene(scene);
        }
        return 0;
    }

    /**
     * 查询所有场景
     * @return
     */
    @Override
    @Transactional(propagation= Propagation.SUPPORTS)
    public List<Scene> getScenes() {
        return sceneMapper.selectAll();
    }

    /**
     * 查询组合产品是否绑定到一个场景
     * @param productId 组合产品ID
     * @return
     */
    @Override
    public boolean isProductCombineBindScene(int productId) {
        SceneExample example=new SceneExample();
        example.or().andProductIdEqualTo(productId).andIsDeletedEqualTo(false);
        return sceneMapper.selectByExample(example).isEmpty();
    }
}
