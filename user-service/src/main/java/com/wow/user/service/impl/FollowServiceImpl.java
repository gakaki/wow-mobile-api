package com.wow.user.service.impl;

import com.wow.user.mapper.EndUserFollowBrandMapper;
import com.wow.user.mapper.EndUserFollowDesignerMapper;
import com.wow.user.mapper.EndUserFollowProductMapper;
import com.wow.user.mapper.EndUserFollowSceneMapper;
import com.wow.user.model.EndUserFollowBrand;
import com.wow.user.model.EndUserFollowDesigner;
import com.wow.user.model.EndUserFollowProduct;
import com.wow.user.model.EndUserFollowScene;
import com.wow.user.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by zhengzhiqing on 16/6/30.
 */
@Service
@Transactional(value = "userTransactionManager")
public class FollowServiceImpl implements FollowService {

    @Autowired
    private EndUserFollowSceneMapper endUserFollowSceneMapper;
    @Autowired
    private EndUserFollowBrandMapper endUserFollowBrandMapper;
    @Autowired
    private EndUserFollowDesignerMapper endUserFollowDesignerMapper;
    @Autowired
    private EndUserFollowProductMapper endUserFollowProductMapper;

    /**
     * 用户关注品牌
     *
     * @param endUserId
     * @param brandId
     * @return
     */
    @Override
    public int followBrand(int endUserId, int brandId) {
        EndUserFollowBrand endUserFollowBrand = new EndUserFollowBrand();
        endUserFollowBrand.setEndUserId(endUserId);
        endUserFollowBrand.setIsDeleted(false);
        endUserFollowBrand.setBrandId(brandId);
        endUserFollowBrand.setFollowTime(new Date());
        endUserFollowBrand.setIsCancelled(false);
        return endUserFollowBrandMapper.insertSelective(endUserFollowBrand);
    }

    /**
     * 用户取消关注品牌
     *
     * @param endUserId
     * @param brandId
     * @return
     */
    @Override
    public int cancelFollowBrand(int endUserId, int brandId) {
        return endUserFollowBrandMapper.cancelFollowBrand(endUserId, brandId);
    }

    /**
     * 用户关注设计师
     *
     * @param endUserId
     * @param designerId
     * @return
     */
    @Override
    public int followDesigner(int endUserId, int designerId) {
        EndUserFollowDesigner endUserFollowDesigner = new EndUserFollowDesigner();
        endUserFollowDesigner.setIsCancelled(false);
        endUserFollowDesigner.setFollowTime(new Date());
        endUserFollowDesigner.setIsDeleted(false);
        endUserFollowDesigner.setDesignerId(designerId);
        endUserFollowDesigner.setEndUserId(endUserId);
        return endUserFollowDesignerMapper.insertSelective(endUserFollowDesigner);
    }

    /**
     * 用户取消关注设计师
     *
     * @param endUserId
     * @param designerId
     * @return
     */
    @Override
    public int cancelFollowDesigner(int endUserId, int designerId) {
        return endUserFollowDesignerMapper.cancelFollowDesigner(endUserId, designerId);
    }

    /**
     * 用户关注产品
     *
     * @param endUserId
     * @param productId
     * @return
     */
    @Override
    public int followProduct(int endUserId, int productId) {
        EndUserFollowProduct endUserFollowProduct = new EndUserFollowProduct();
        endUserFollowProduct.setEndUserId(endUserId);
        endUserFollowProduct.setIsDeleted(false);
        endUserFollowProduct.setFollowTime(new Date());
        endUserFollowProduct.setIsCancelled(false);
        endUserFollowProduct.setProductId(productId);
        return endUserFollowProductMapper.insertSelective(endUserFollowProduct);
    }

    /**
     * 用户取消关注产品
     *
     * @param endUserId
     * @param productId
     * @return
     */
    @Override
    public int cancelFollowProduct(int endUserId, int productId) {
        return endUserFollowProductMapper.cancelFollowProduct(endUserId, productId);
    }

    /**
     * 用户关注场景
     *
     * @param endUserId
     * @param sceneId
     * @return
     */
    @Override
    public int followScene(int endUserId, int sceneId) {
        EndUserFollowScene endUserFollowScene = new EndUserFollowScene();
        endUserFollowScene.setIsCancelled(false);
        endUserFollowScene.setFollowTime(new Date());
        endUserFollowScene.setIsDeleted(false);
        endUserFollowScene.setEndUserId(endUserId);
        endUserFollowScene.setSceneId(sceneId);
        return endUserFollowSceneMapper.insertSelective(endUserFollowScene);
    }

    /**
     * 用户取消关注场景
     *
     * @param endUserId
     * @param sceneId
     * @return
     */
    @Override
    public int cancelFollowScene(int endUserId, int sceneId) {
        return endUserFollowSceneMapper.cancelFollowScene(endUserId, sceneId);
    }
}
