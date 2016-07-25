package com.wow.user.service.impl;

import com.wow.common.response.CommonResponse;
import com.wow.user.mapper.EndUserLikeBrandMapper;
import com.wow.user.mapper.EndUserLikeDesignerMapper;
import com.wow.user.mapper.EndUserLikeProductMapper;
import com.wow.user.mapper.EndUserLikeSceneMapper;
import com.wow.user.model.EndUserLikeBrand;
import com.wow.user.model.EndUserLikeDesigner;
import com.wow.user.model.EndUserLikeProduct;
import com.wow.user.model.EndUserLikeScene;
import com.wow.user.service.LikeService;
import com.wow.user.vo.LikedBrandVo;
import com.wow.user.vo.LikedDesignerVo;
import com.wow.user.vo.response.LikedBrandResponse;
import com.wow.user.vo.response.LikedDesignerResponse;
import com.wow.user.vo.response.LikedProductResponse;
import com.wow.user.vo.response.LikedSceneResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by zhengzhiqing on 16/7/24.
 */
@Service
@Transactional(value = "userTransactionManager")
public class LikeServiceImpl implements LikeService {

    private static final Logger logger = LoggerFactory.getLogger(LikeServiceImpl.class);

    @Autowired
    private EndUserLikeBrandMapper endUserLikeBrandMapper;

    @Autowired
    private EndUserLikeDesignerMapper endUserLikeDesignerMapper;

    @Autowired
    private EndUserLikeProductMapper endUserLikeProductMapper;

    @Autowired
    private EndUserLikeSceneMapper endUserLikeSceneMapper;


    /**
     * 用户喜欢品牌
     *
     * @param endUserId
     * @param brandId
     * @return
     */
    @Override
    public CommonResponse likeBrand(int endUserId, int brandId) {
        EndUserLikeBrand endUserLikeBrand = new EndUserLikeBrand();
        endUserLikeBrand.setEndUserId(endUserId);
        endUserLikeBrand.setBrandId(brandId);
        endUserLikeBrandMapper.insertSelective(endUserLikeBrand);
        return new CommonResponse();
    }

    /**
     * 删除喜欢的品牌
     *
     * @param id
     * @return
     */
    @Override
    public CommonResponse deleteLikedBrand(int id) {
        EndUserLikeBrand endUserLikeBrand = new EndUserLikeBrand();
        endUserLikeBrand.setId(id);
        endUserLikeBrand.setIsDeleted(true);
        endUserLikeBrand.setDeleteTime(new Date());
        endUserLikeBrandMapper.updateByPrimaryKey(endUserLikeBrand);
        return new CommonResponse();
    }

    /**
     * 查询用户喜欢的品牌
     *
     * @param endUserId
     * @return
     */
    @Override
    public LikedBrandResponse getLikedBrand(int endUserId) {
        LikedBrandResponse likedBrandResponse = new LikedBrandResponse();
        List<LikedBrandVo> likedBrandVoList = endUserLikeBrandMapper.selectLikedBrand(endUserId);
        likedBrandResponse.setLikedBrandVoList(likedBrandVoList);
        return likedBrandResponse;
    }

    /**
     * 用户喜欢设计师
     *
     * @param endUserId
     * @param designerId
     * @return
     */
    @Override
    public CommonResponse likeDesigner(int endUserId, int designerId) {
        EndUserLikeDesigner endUserLikeDesigner = new EndUserLikeDesigner();
        endUserLikeDesigner.setEndUserId(endUserId);
        endUserLikeDesigner.setDesignerId(designerId);
        endUserLikeDesignerMapper.insertSelective(endUserLikeDesigner);
        return new CommonResponse();
    }

    /**
     * 删除喜欢的设计师
     *
     * @param id
     * @return
     */
    @Override
    public CommonResponse deleteLikedDesigner(int id) {
        EndUserLikeDesigner endUserLikeDesigner = new EndUserLikeDesigner();
        endUserLikeDesigner.setId(id);
        endUserLikeDesigner.setIsDeleted(true);
        endUserLikeDesigner.setDeleteTime(new Date());
        endUserLikeDesignerMapper.updateByPrimaryKey(endUserLikeDesigner);
        return new CommonResponse();
    }

    /**
     * 查询用户喜欢的设计师
     *
     * @param endUserId
     * @return
     */
    @Override
    public LikedDesignerResponse getLikedDesigner(int endUserId) {
        LikedDesignerResponse likedDesignerResponse = new LikedDesignerResponse();
        //TODO
        List<LikedDesignerVo> likedDesignerVoList = endUserLikeDesignerMapper.selectLikedDesigner(endUserId);
        likedDesignerResponse.setLikedDesignerVoList(likedDesignerVoList);
        return likedDesignerResponse;
    }

    /**
     * 用户喜欢产品
     *
     * @param endUserId
     * @param productId
     * @return
     */
    @Override
    public CommonResponse likeProduct(int endUserId, int productId) {
        EndUserLikeProduct endUserLikeProduct = new EndUserLikeProduct();
        endUserLikeProduct.setEndUserId(endUserId);
        endUserLikeProduct.setProductId(productId);
        endUserLikeProductMapper.insertSelective(endUserLikeProduct);
        return new CommonResponse();
    }

    /**
     * 删除喜欢的产品
     *
     * @param id
     * @return
     */
    @Override
    public CommonResponse deleteLikedProduct(int id) {
        EndUserLikeProduct endUserLikeProduct = new EndUserLikeProduct();
        endUserLikeProduct.setId(id);
        endUserLikeProduct.setIsDeleted(true);
        endUserLikeProduct.setDeleteTime(new Date());
        endUserLikeProductMapper.updateByPrimaryKey(endUserLikeProduct);
        return new CommonResponse();
    }

    /**
     * 查询用户喜欢的产品
     *
     * @param endUserId
     * @return
     */
    @Override
    public LikedProductResponse getLikedProduct(int endUserId) {
        //TODO
        return null;
    }

    /**
     * 用户喜欢场景
     *
     * @param endUserId
     * @param sceneId
     * @return
     */
    @Override
    public CommonResponse likeScene(int endUserId, int sceneId) {
        EndUserLikeScene endUserLikeScene = new EndUserLikeScene();
        endUserLikeScene.setEndUserId(endUserId);
        endUserLikeScene.setSceneId(sceneId);
        endUserLikeSceneMapper.insertSelective(endUserLikeScene);
        return new CommonResponse();
    }

    /**
     * 删除喜欢的场景
     *
     * @param id
     * @return
     */
    @Override
    public CommonResponse deleteLikedScene(int id) {
        EndUserLikeScene endUserLikeScene = new EndUserLikeScene();
        endUserLikeScene.setId(id);
        endUserLikeScene.setIsDeleted(true);
        endUserLikeScene.setDeleteTime(new Date());
        endUserLikeSceneMapper.updateByPrimaryKey(endUserLikeScene);
        return new CommonResponse();
    }

    /**
     * 查询用户喜欢的场景
     *
     * @param endUserId
     * @return
     */
    @Override
    public LikedSceneResponse getLikedScene(int endUserId) {
        //TODO
        return null;
    }
}
