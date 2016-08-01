package com.wow.user.service.impl;

import com.wow.common.util.CollectionUtil;
import com.wow.common.util.ErrorCodeUtil;
import com.wow.user.mapper.EndUserFavoriteBrandMapper;
import com.wow.user.mapper.EndUserFavoriteDesignerMapper;
import com.wow.user.mapper.EndUserFavoriteProductMapper;
import com.wow.user.mapper.EndUserFavoriteSceneMapper;
import com.wow.user.model.*;
import com.wow.user.service.FavoriteService;
import com.wow.user.vo.FavoriteBrandVo;
import com.wow.user.vo.FavoriteDesignerVo;
import com.wow.user.vo.FavoriteProductVo;
import com.wow.user.vo.FavoriteSceneVo;
import com.wow.user.vo.response.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhengzhiqing on 16/7/24.
 */
@Service
@Transactional(value = "userTransactionManager")
public class FavoriteServiceImpl implements FavoriteService {

    private static final Logger logger = LoggerFactory.getLogger(FavoriteServiceImpl.class);

    @Autowired
    private EndUserFavoriteBrandMapper endUserFavoriteBrandMapper;

    @Autowired
    private EndUserFavoriteDesignerMapper endUserFavoriteDesignerMapper;

    @Autowired
    private EndUserFavoriteProductMapper endUserFavoriteProductMapper;

    @Autowired
    private EndUserFavoriteSceneMapper endUserFavoriteSceneMapper;


    /**
     * 用户喜欢品牌
     *
     * @param endUserId
     * @param brandId
     * @return
     */
    @Override
    public FavoriteCommonResponse updateFavoriteBrand(Integer endUserId, Integer brandId) {
        EndUserFavoriteBrand endUserFavoriteBrand = new EndUserFavoriteBrand();
        FavoriteCommonResponse favoriteCommonResponse = new FavoriteCommonResponse();

        if (brandId == null) {
        	favoriteCommonResponse.setResCode("40204");
        	favoriteCommonResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40204"));
            return favoriteCommonResponse;
        }
        //如果没找到记录,新增
        //如果找到记录,is_favorite取反
        EndUserFavoriteBrandExample endUserFavoriteBrandExample = new EndUserFavoriteBrandExample();
        EndUserFavoriteBrandExample.Criteria criteria = endUserFavoriteBrandExample.createCriteria();
        criteria.andEndUserIdEqualTo(endUserId);
        criteria.andBrandIdEqualTo(brandId);
        List<EndUserFavoriteBrand> list = endUserFavoriteBrandMapper.selectByExample(endUserFavoriteBrandExample);

        if (CollectionUtil.isEmpty(list)) {
            //新增
            endUserFavoriteBrand.setEndUserId(endUserId);
            endUserFavoriteBrand.setBrandId(brandId);
            endUserFavoriteBrand.setIsFavorite(true);
            endUserFavoriteBrandMapper.insertSelective(endUserFavoriteBrand);
            favoriteCommonResponse.setFavorite(true);
        } else {
            endUserFavoriteBrand = list.get(0);
            favoriteCommonResponse.setFavorite(!endUserFavoriteBrand.getIsFavorite());
            endUserFavoriteBrand.setIsFavorite(!endUserFavoriteBrand.getIsFavorite());
            endUserFavoriteBrandMapper.updateByPrimaryKeySelective(endUserFavoriteBrand);
        }
        return favoriteCommonResponse;
    }

    /**
     * 查询用户是否喜欢一个品牌
     *
     * @param endUserId
     * @param brandId
     * @return
     */
    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public FavoriteCommonResponse isUserFavoriteBrand(Integer endUserId, Integer brandId) {
        EndUserFavoriteBrand endUserFavoriteBrand = new EndUserFavoriteBrand();
        FavoriteCommonResponse favoriteCommonResponse = new FavoriteCommonResponse();

        if (brandId == null) {
            favoriteCommonResponse.setResCode("40204");
            favoriteCommonResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40204"));
            return favoriteCommonResponse;
        }

        EndUserFavoriteBrandExample endUserFavoriteBrandExample = new EndUserFavoriteBrandExample();
        EndUserFavoriteBrandExample.Criteria criteria = endUserFavoriteBrandExample.createCriteria();
        criteria.andEndUserIdEqualTo(endUserId);
        criteria.andBrandIdEqualTo(brandId);
        List<EndUserFavoriteBrand> list = endUserFavoriteBrandMapper.selectByExample(endUserFavoriteBrandExample);

        if (CollectionUtil.isEmpty(list)) {
            favoriteCommonResponse.setFavorite(false);
        } else {
            endUserFavoriteBrand = list.get(0);
            favoriteCommonResponse.setFavorite(endUserFavoriteBrand.getIsFavorite());
        }
        return favoriteCommonResponse;
    }

    /**
     * 查询用户喜欢的品牌
     *
     * @param endUserId
     * @return
     */
    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public FavoriteBrandResponse getFavoriteBrand(Integer endUserId) {
        FavoriteBrandResponse favoriteBrandResponse = new FavoriteBrandResponse();
        List<FavoriteBrandVo> favoriteBrandVoList = endUserFavoriteBrandMapper.selectFavoriteBrand(endUserId);
        favoriteBrandResponse.setFavoriteBrandVoList(favoriteBrandVoList);
        return favoriteBrandResponse;
    }

    /**
     * 用户喜欢设计师
     *
     * @param endUserId
     * @param designerId
     * @return
     */
    @Override
    public FavoriteCommonResponse updateFavoriteDesigner(Integer endUserId, Integer designerId) {
        EndUserFavoriteDesigner endUserFavoriteDesigner = new EndUserFavoriteDesigner();
        FavoriteCommonResponse favoriteCommonResponse = new FavoriteCommonResponse();
        if (designerId == null) {
        	favoriteCommonResponse.setResCode("40205");
        	favoriteCommonResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40205"));
            return favoriteCommonResponse;
        }
        //如果没找到记录,新增
        //如果找到记录,is_favorite取反
        EndUserFavoriteDesignerExample endUserFavoriteDesignerExample = new EndUserFavoriteDesignerExample();
        EndUserFavoriteDesignerExample.Criteria criteria = endUserFavoriteDesignerExample.createCriteria();
        criteria.andEndUserIdEqualTo(endUserId);
        criteria.andDesignerIdEqualTo(designerId);
        List<EndUserFavoriteDesigner> list = endUserFavoriteDesignerMapper.selectByExample(endUserFavoriteDesignerExample);

        if (CollectionUtil.isEmpty(list)) {
            //新增
            endUserFavoriteDesigner.setEndUserId(endUserId);
            endUserFavoriteDesigner.setDesignerId(designerId);
            endUserFavoriteDesigner.setIsFavorite(true);
            endUserFavoriteDesignerMapper.insertSelective(endUserFavoriteDesigner);
            favoriteCommonResponse.setFavorite(true);
        } else {
            endUserFavoriteDesigner = list.get(0);
            favoriteCommonResponse.setFavorite(!endUserFavoriteDesigner.getIsFavorite());
            endUserFavoriteDesigner.setIsFavorite(!endUserFavoriteDesigner.getIsFavorite());
            endUserFavoriteDesignerMapper.updateByPrimaryKeySelective(endUserFavoriteDesigner);
        }
        return favoriteCommonResponse;
    }

    /**
     * 查询用户喜欢的设计师
     *
     * @param endUserId
     * @return
     */
    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public FavoriteDesignerResponse getFavoriteDesigner(Integer endUserId) {
        FavoriteDesignerResponse favoriteDesignerResponse = new FavoriteDesignerResponse();
        //TODO
        List<FavoriteDesignerVo> favoriteDesignerVoList = endUserFavoriteDesignerMapper.selectFavoriteDesigner(endUserId);
        favoriteDesignerResponse.setFavoriteDesignerVoList(favoriteDesignerVoList);
        return favoriteDesignerResponse;
    }

    /**
     * 查询用户是否喜欢一个设计师
     *
     * @param endUserId
     * @param designerId
     * @return
     */
    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public FavoriteCommonResponse isUserFavoriteDesigner(Integer endUserId, Integer designerId) {
        EndUserFavoriteDesigner endUserFavoriteDesigner = new EndUserFavoriteDesigner();
        FavoriteCommonResponse favoriteCommonResponse = new FavoriteCommonResponse();

        if (designerId == null) {
            favoriteCommonResponse.setResCode("40205");
            favoriteCommonResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40205"));
            return favoriteCommonResponse;
        }

        EndUserFavoriteDesignerExample endUserFavoriteDesignerExample = new EndUserFavoriteDesignerExample();
        EndUserFavoriteDesignerExample.Criteria criteria = endUserFavoriteDesignerExample.createCriteria();
        criteria.andEndUserIdEqualTo(endUserId);
        criteria.andDesignerIdEqualTo(designerId);
        List<EndUserFavoriteDesigner> list = endUserFavoriteDesignerMapper.selectByExample(endUserFavoriteDesignerExample);

        if (CollectionUtil.isEmpty(list)) {
            favoriteCommonResponse.setFavorite(false);
        } else {
            endUserFavoriteDesigner = list.get(0);
            favoriteCommonResponse.setFavorite(endUserFavoriteDesigner.getIsFavorite());
        }
        return favoriteCommonResponse;
    }

    /**
     * 用户喜欢产品
     *
     * @param endUserId
     * @param productId
     * @return
     */
    @Override
    public FavoriteCommonResponse updateFavoriteProduct(Integer endUserId, Integer productId) {
        EndUserFavoriteProduct endUserFavoriteProduct = new EndUserFavoriteProduct();
        FavoriteCommonResponse favoriteCommonResponse = new FavoriteCommonResponse();
        if (productId == null) {
        	favoriteCommonResponse.setResCode("40202");
        	favoriteCommonResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40202"));
            return favoriteCommonResponse;
        }
        //如果没找到记录,新增
        //如果找到记录,is_favorite取反
        EndUserFavoriteProductExample endUserFavoriteProductExample = new EndUserFavoriteProductExample();
        EndUserFavoriteProductExample.Criteria criteria = endUserFavoriteProductExample.createCriteria();
        criteria.andEndUserIdEqualTo(endUserId);
        criteria.andProductIdEqualTo(productId);
        List<EndUserFavoriteProduct> list = endUserFavoriteProductMapper.selectByExample(endUserFavoriteProductExample);

        if (CollectionUtil.isEmpty(list)) {
            //新增
            endUserFavoriteProduct.setEndUserId(endUserId);
            endUserFavoriteProduct.setProductId(productId);
            endUserFavoriteProduct.setIsFavorite(true);
            endUserFavoriteProductMapper.insertSelective(endUserFavoriteProduct);
            favoriteCommonResponse.setFavorite(true);
        } else {
            endUserFavoriteProduct = list.get(0);
            favoriteCommonResponse.setFavorite(!endUserFavoriteProduct.getIsFavorite());
            endUserFavoriteProduct.setIsFavorite(!endUserFavoriteProduct.getIsFavorite());
            endUserFavoriteProductMapper.updateByPrimaryKeySelective(endUserFavoriteProduct);
        }
        return favoriteCommonResponse;
    }

    /**
     * 查询用户喜欢的产品
     *
     * @param endUserId
     * @return
     */
    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public FavoriteProductResponse getFavoriteProduct(Integer endUserId) {

        FavoriteProductResponse favoriteProductResponse = new FavoriteProductResponse();
        //TODO
        List<FavoriteProductVo> favoriteProductVoList = endUserFavoriteProductMapper.selectFavoriteProduct(endUserId);
        favoriteProductResponse.setFavoriteProductVoList(favoriteProductVoList);
        return favoriteProductResponse;
    }

    /**
     * 查询用户是否喜欢一个产品
     *
     * @param endUserId
     * @param productId
     * @return
     */
    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public FavoriteCommonResponse isUserFavoriteProduct(Integer endUserId, Integer productId) {
        EndUserFavoriteProduct endUserFavoriteProduct = new EndUserFavoriteProduct();
        FavoriteCommonResponse favoriteCommonResponse = new FavoriteCommonResponse();

        if (productId == null) {
            favoriteCommonResponse.setResCode("40202");
            favoriteCommonResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40202"));
            return favoriteCommonResponse;
        }

        EndUserFavoriteProductExample endUserFavoriteProductExample = new EndUserFavoriteProductExample();
        EndUserFavoriteProductExample.Criteria criteria = endUserFavoriteProductExample.createCriteria();
        criteria.andEndUserIdEqualTo(endUserId);
        criteria.andProductIdEqualTo(productId);
        List<EndUserFavoriteProduct> list = endUserFavoriteProductMapper.selectByExample(endUserFavoriteProductExample);

        if (CollectionUtil.isEmpty(list)) {
            favoriteCommonResponse.setFavorite(false);
        } else {
            endUserFavoriteProduct = list.get(0);
            favoriteCommonResponse.setFavorite(endUserFavoriteProduct.getIsFavorite());
        }
        return favoriteCommonResponse;
    }

//    /**
//     * 用户喜欢场景
//     *
//     * @param endUserId
//     * @param sceneId
//     * @return
//     */
//    @Override
//    public FavoriteCommonResponse updateFavoriteScene(Integer endUserId, Integer sceneId) {
//        EndUserFavoriteScene endUserFavoriteScene = new EndUserFavoriteScene();
//        FavoriteCommonResponse favoriteCommonResponse = new FavoriteCommonResponse();
//        if (sceneId == null) {
//            favoriteCommonResponse.setResCode("40202");
//            favoriteCommonResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40202"));
//            return favoriteCommonResponse;
//        }
//
//        //如果没找到记录,新增
//        //如果找到记录,is_favorite取反
//        EndUserFavoriteSceneExample endUserFavoriteSceneExample = new EndUserFavoriteSceneExample();
//        EndUserFavoriteSceneExample.Criteria criteria = endUserFavoriteSceneExample.createCriteria();
//        criteria.andEndUserIdEqualTo(endUserId);
//        criteria.andSceneIdEqualTo(sceneId);
//        List<EndUserFavoriteScene> list = endUserFavoriteSceneMapper.selectByExample(endUserFavoriteSceneExample);
//
//        if (CollectionUtil.isEmpty(list)) {
//            //新增
//            endUserFavoriteScene.setEndUserId(endUserId);
//            endUserFavoriteScene.setSceneId(sceneId);
//            endUserFavoriteScene.setIsFavorite(true);
//            endUserFavoriteSceneMapper.insertSelective(endUserFavoriteScene);
//            favoriteCommonResponse.setFavorite(true);
//        } else {
//            endUserFavoriteScene = list.get(0);
//            favoriteCommonResponse.setFavorite(!endUserFavoriteScene.getIsFavorite());
//            endUserFavoriteScene.setIsFavorite(!endUserFavoriteScene.getIsFavorite());
//            endUserFavoriteSceneMapper.updateByPrimaryKeySelective(endUserFavoriteScene);
//        }
//        return favoriteCommonResponse;
//    }
//
//    /**
//     * 查询用户喜欢的场景
//     *
//     * @param endUserId
//     * @return
//     */
//    @Override
//    @Transactional(propagation= Propagation.NOT_SUPPORTED)
//    public FavoriteSceneResponse getFavoriteScene(Integer endUserId) {
//        FavoriteSceneResponse favoriteSceneResponse = new FavoriteSceneResponse();
//        List<FavoriteSceneVo> favoriteSceneVoList = endUserFavoriteSceneMapper.selectFavoriteScene(endUserId);
//        favoriteSceneResponse.setFavoriteSceneVoList(favoriteSceneVoList);
//        return favoriteSceneResponse;
//    }
//
//    /**
//     * 查询用户是否喜欢一个场景
//     *
//     * @param endUserId
//     * @param sceneId
//     * @return
//     */
//    @Override
//    @Transactional(propagation= Propagation.NOT_SUPPORTED)
//    public FavoriteCommonResponse isUserFavoriteScene(Integer endUserId, Integer sceneId) {
//        EndUserFavoriteScene endUserFavoriteScene = new EndUserFavoriteScene();
//        FavoriteCommonResponse favoriteCommonResponse = new FavoriteCommonResponse();
//
//        if (sceneId == null) {
//            favoriteCommonResponse.setResCode("40202");
//            favoriteCommonResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40202"));
//            return favoriteCommonResponse;
//        }
//
//        EndUserFavoriteSceneExample endUserFavoriteSceneExample = new EndUserFavoriteSceneExample();
//        EndUserFavoriteSceneExample.Criteria criteria = endUserFavoriteSceneExample.createCriteria();
//        criteria.andEndUserIdEqualTo(endUserId);
//        criteria.andSceneIdEqualTo(sceneId);
//        List<EndUserFavoriteScene> list = endUserFavoriteSceneMapper.selectByExample(endUserFavoriteSceneExample);
//
//        if (CollectionUtil.isEmpty(list)) {
//            favoriteCommonResponse.setFavorite(false);
//        } else {
//            endUserFavoriteScene = list.get(0);
//            favoriteCommonResponse.setFavorite(endUserFavoriteScene.getIsFavorite());
//        }
//        return favoriteCommonResponse;
//    }
}
