package com.wow.user.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wow.common.response.CommonResponse;
import com.wow.common.util.ErrorCodeUtil;
import com.wow.common.util.MapUtil;
import com.wow.product.model.ProductImage;
import com.wow.product.service.ProductService;
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
import com.wow.user.vo.LikedProductVo;
import com.wow.user.vo.LikedSceneVo;
import com.wow.user.vo.response.LikedBrandResponse;
import com.wow.user.vo.response.LikedDesignerResponse;
import com.wow.user.vo.response.LikedProductResponse;
import com.wow.user.vo.response.LikedSceneResponse;

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

    @Autowired
    private ProductService productService;



    /**
     * 用户喜欢品牌
     *
     * @param endUserId
     * @param brandId
     * @return
     */
    @Override
    public CommonResponse likeBrand(Integer endUserId, Integer brandId) {
        EndUserLikeBrand endUserLikeBrand = new EndUserLikeBrand();
        CommonResponse commonResponse = new CommonResponse();
        if (brandId == null) {
        	commonResponse.setResCode("40204");
        	commonResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40204"));
            return commonResponse;
        }
        
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
    public CommonResponse deleteLikedBrand(Integer id) {
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
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public LikedBrandResponse getLikedBrand(Integer endUserId) {
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
    public CommonResponse likeDesigner(Integer endUserId, Integer designerId) {
        EndUserLikeDesigner endUserLikeDesigner = new EndUserLikeDesigner();
        CommonResponse commonResponse = new CommonResponse();
        if (designerId == null) {
        	commonResponse.setResCode("40205");
        	commonResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40205"));
            return commonResponse;
        }
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
    public CommonResponse deleteLikedDesigner(Integer id) {
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
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public LikedDesignerResponse getLikedDesigner(Integer endUserId) {
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
    public CommonResponse likeProduct(Integer endUserId, Integer productId) {
        EndUserLikeProduct endUserLikeProduct = new EndUserLikeProduct();
        CommonResponse commonResponse = new CommonResponse();
        if (productId == null) {
        	commonResponse.setResCode("40202");
        	commonResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40202"));
            return commonResponse;
        }
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
    public CommonResponse deleteLikedProduct(Integer id) {
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
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public LikedProductResponse getLikedProduct(Integer endUserId) {

        LikedProductResponse likedProductResponse = new LikedProductResponse();
        List<LikedProductVo> likedProductVoList = endUserLikeProductMapper.selectLikedProduct(endUserId);
        if(likedProductVoList.size()>0){
        	List<Integer> productIds = new ArrayList<Integer>();
            for(LikedProductVo likedProductVo:likedProductVoList){
            	productIds.add(likedProductVo.getProductId());
            }
            //批量查询主图
            Map<Integer, ProductImage> productImageMap = productService.selectProductListPrimaryOneImg(productIds);
            
            List<LikedProductVo> returnLikedProductVoList = new ArrayList<LikedProductVo>();
            for(LikedProductVo likedProductVo:likedProductVoList){
            	if(MapUtil.isNotEmpty(productImageMap) && productImageMap.get(likedProductVo.getProductId()) != null){
            		likedProductVo.setProductImg(productImageMap.get(likedProductVo.getProductId()).getImgUrl());
            	}
            	returnLikedProductVoList.add(likedProductVo);
            }
            
            likedProductResponse.setLikedProductVoList(returnLikedProductVoList);
        }
        
        return likedProductResponse;
    }

    /**
     * 用户喜欢场景
     *
     * @param endUserId
     * @param sceneId
     * @return
     */
    @Override
    public CommonResponse likeScene(Integer endUserId, Integer sceneId) {
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
    public CommonResponse deleteLikedScene(Integer id) {
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
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public LikedSceneResponse getLikedScene(Integer endUserId) {

        LikedSceneResponse likedSceneResponse = new LikedSceneResponse();
        //TODO
        List<LikedSceneVo> likedSceneVoList = endUserLikeSceneMapper.selectLikedScene(endUserId);
        likedSceneResponse.setLikedSceneVoList(likedSceneVoList);
        return likedSceneResponse;
    }
}
