package com.wow.mobileapi.controller;

import com.wow.common.request.ApiRequest;
import com.wow.common.response.ApiResponse;
import com.wow.common.util.ErrorCodeUtil;
import com.wow.common.util.ErrorResponseUtil;
import com.wow.common.util.JsonUtil;
import com.wow.mobileapi.constant.ErrorCodeConstant;
import com.wow.mobileapi.request.user.FavoriteBrandRequest;
import com.wow.mobileapi.request.user.FavoriteDesignerRequest;
import com.wow.mobileapi.request.user.FavoriteProductRequest;
import com.wow.mobileapi.request.user.FavoriteSceneRequest;
import com.wow.product.model.ProductImage;
import com.wow.product.service.ProductService;
import com.wow.user.service.FavoriteService;
import com.wow.user.vo.FavoriteBrandVo;
import com.wow.user.vo.FavoriteDesignerVo;
import com.wow.user.vo.FavoriteProductVo;
import com.wow.user.vo.FavoriteSceneVo;
import com.wow.user.vo.response.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserActionController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserActionController.class);

    @Autowired
    private FavoriteService favoriteService;
    @Autowired
    private ProductService productService;

    /**
     * 设置喜欢或取消喜欢一个品牌
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/user/brand/favorite", method = RequestMethod.POST)
    public ApiResponse favoriteUpdate(ApiRequest apiRequest) {

        ApiResponse apiResponse = new ApiResponse();
        Integer endUserId = getUserIdByTokenChannel(apiRequest);
        FavoriteBrandRequest favoriteBrandRequest = JsonUtil.fromJSON(apiRequest.getParamJson(), FavoriteBrandRequest.class);
        
        //判断json格式参数是否有误
        if (favoriteBrandRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }
        
        try {
            FavoriteCommonResponse favoriteCommonResponse = favoriteService.updateFavoriteBrand(endUserId, favoriteBrandRequest.getBrandId());
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(favoriteCommonResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, favoriteCommonResponse);
                return apiResponse;
            } else {
                apiResponse.setData(favoriteCommonResponse);
            }
        } catch (Exception e) {
            logger.error("新增用户喜欢的品牌发生错误---" + e);
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }

    /**
     * 查询用户喜欢的品牌列表
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/user/brand/favorite-list", method = RequestMethod.GET)
    public ApiResponse getFavoriteBrand(ApiRequest apiRequest) {
        ApiResponse apiResponse = new ApiResponse();
        Integer endUserId = getUserIdByTokenChannel(apiRequest);
        if (endUserId == null) {
            ErrorResponseUtil.setErrorResponse(apiResponse, ErrorCodeConstant.INVALID_TOKEN);
            return apiResponse;
        }

        try {
            FavoriteBrandResponse favoriteBrandResponse = favoriteService.getFavoriteBrand(endUserId);
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(favoriteBrandResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, favoriteBrandResponse);
            } else {
                List<FavoriteBrandVo> favoriteBrandVoList = favoriteBrandResponse.getFavoriteBrandVoList();
                favoriteBrandResponse.setFavoriteBrandVoList(favoriteBrandVoList);
                apiResponse.setData(favoriteBrandResponse);
            }
        } catch (Exception e) {
            logger.error("查找用户喜欢的品牌错误---" + e);
            e.printStackTrace();
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }

    /**
     * 检查用户是否喜欢一个品牌
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/user/brand/is-favorite", method = RequestMethod.GET)
    public ApiResponse isUserFavoriteBrand(ApiRequest apiRequest) {

        ApiResponse apiResponse = new ApiResponse();
        Integer endUserId = getUserIdByTokenChannel(apiRequest);
        FavoriteBrandRequest favoriteBrandRequest = JsonUtil.fromJSON(apiRequest.getParamJson(), FavoriteBrandRequest.class);

        //判断json格式参数是否有误
        if (favoriteBrandRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }

        try {
            FavoriteCommonResponse favoriteCommonResponse = favoriteService.isUserFavoriteBrand(endUserId, favoriteBrandRequest.getBrandId());
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(favoriteCommonResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, favoriteCommonResponse);
                return apiResponse;
            } else {
                apiResponse.setData(favoriteCommonResponse);
            }
        } catch (Exception e) {
            logger.error("检查用户是否喜欢一个品牌发生错误---" + e);
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }

    /**
     * 新增用户喜欢的设计师
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/user/designer/favorite", method = RequestMethod.POST)
    public ApiResponse favoriteDesigner(ApiRequest apiRequest) {

        ApiResponse apiResponse = new ApiResponse();
        Integer endUserId = getUserIdByTokenChannel(apiRequest);
        FavoriteDesignerRequest favoriteDesignerRequest = JsonUtil.fromJSON(apiRequest.getParamJson(), FavoriteDesignerRequest.class);
        
        //判断json格式参数是否有误
        if (favoriteDesignerRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }
        
        try {
            FavoriteCommonResponse favoriteCommonResponse = favoriteService.updateFavoriteDesigner(endUserId, favoriteDesignerRequest.getDesignerId());
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(favoriteCommonResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, favoriteCommonResponse);
                return apiResponse;
            } else {
                apiResponse.setData(favoriteCommonResponse);
            }
        } catch (Exception e) {
            logger.error("新增用户喜欢的设计师发生错误---" + e);
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }

    /**
     * 查询用户喜欢的设计师列表
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/user/designer/favorite-list", method = RequestMethod.GET)
    public ApiResponse getFavoriteDesigner(ApiRequest apiRequest) {
        ApiResponse apiResponse = new ApiResponse();
        Integer endUserId = getUserIdByTokenChannel(apiRequest);
        if (endUserId == null) {
            ErrorResponseUtil.setErrorResponse(apiResponse, ErrorCodeConstant.INVALID_TOKEN);
            return apiResponse;
        }

        try {
        	FavoriteDesignerResponse favoriteDesignerResponse = favoriteService.getFavoriteDesigner(endUserId);
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(favoriteDesignerResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, favoriteDesignerResponse);
            } else {
                List<FavoriteDesignerVo> favoriteDesignerVoList = favoriteDesignerResponse.getFavoriteDesignerVoList();
                favoriteDesignerResponse.setFavoriteDesignerVoList(favoriteDesignerVoList);
                apiResponse.setData(favoriteDesignerResponse);
            }
        } catch (Exception e) {
            logger.error("查找用户喜欢的设计师错误---" + e);
            e.printStackTrace();
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }

    /**
     * 检查用户是否喜欢一个设计师
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/user/designer/is-favorite", method = RequestMethod.GET)
    public ApiResponse isUserFavoriteDesigner(ApiRequest apiRequest) {

        ApiResponse apiResponse = new ApiResponse();
        Integer endUserId = getUserIdByTokenChannel(apiRequest);
        FavoriteDesignerRequest favoriteDesignerRequest = JsonUtil.fromJSON(apiRequest.getParamJson(), FavoriteDesignerRequest.class);

        //判断json格式参数是否有误
        if (favoriteDesignerRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }

        try {
            FavoriteCommonResponse favoriteCommonResponse = favoriteService.isUserFavoriteDesigner(endUserId, favoriteDesignerRequest.getDesignerId());
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(favoriteCommonResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, favoriteCommonResponse);
                return apiResponse;
            } else {
                apiResponse.setData(favoriteCommonResponse);
            }
        } catch (Exception e) {
            logger.error("检查用户是否喜欢一个设计师发生错误---" + e);
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }
    

    /**
     * 新增用户喜欢的产品
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/user/product/favorite", method = RequestMethod.POST)
    public ApiResponse favoriteProduct(ApiRequest apiRequest) {

        ApiResponse apiResponse = new ApiResponse();
        Integer endUserId = getUserIdByTokenChannel(apiRequest);
        FavoriteProductRequest favoriteProductRequest = JsonUtil.fromJSON(apiRequest.getParamJson(), FavoriteProductRequest.class);
        
        //判断json格式参数是否有误
        if (favoriteProductRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }
        
        try {
            FavoriteCommonResponse favoriteCommonResponse = favoriteService.updateFavoriteProduct(endUserId, favoriteProductRequest.getProductId());
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(favoriteCommonResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, favoriteCommonResponse);
                return apiResponse;
            } else {
                apiResponse.setData(favoriteCommonResponse);
            }
        } catch (Exception e) {
            logger.error("新增用户喜欢的产品发生错误---" + e);
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }



    /**
     * 查询用户喜欢的产品列表
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/user/product/favorite-list", method = RequestMethod.GET)
    public ApiResponse getFavoriteProduct(ApiRequest apiRequest, HttpServletRequest request) {
        ApiResponse apiResponse = new ApiResponse();
        //TODO: 此处污染了接口
        logger.info("get favorite product, endUserId=" + request.getAttribute("endUserId"));
//        Integer endUserId = getUserIdByTokenChannel(apiRequest);
        Integer endUserId = (Integer)request.getAttribute("endUserId");
        if (endUserId == null) {
            ErrorResponseUtil.setErrorResponse(apiResponse, ErrorCodeConstant.INVALID_TOKEN);
            return apiResponse;
        }

        try {
        	FavoriteProductResponse favoriteProductResponse = favoriteService.getFavoriteProduct(endUserId);
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(favoriteProductResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, favoriteProductResponse);
            } else {
                List<FavoriteProductVo> favoriteProductVoList = favoriteProductResponse.getFavoriteProductVoList();
                List<FavoriteProductVo> list = new ArrayList<FavoriteProductVo>();
                
                for (FavoriteProductVo favoriteProductVo : favoriteProductVoList) {
                	ProductImage pi = productService.selectProductPrimaryOneImg(favoriteProductVo.getProductId());
                	if(pi!=null){
                		favoriteProductVo.setProductImg(pi.getImgUrl());
                		list.add(favoriteProductVo);
                	}
                }
                favoriteProductResponse.setFavoriteProductVoList(favoriteProductVoList);
                apiResponse.setData(favoriteProductResponse);
            }
        } catch (Exception e) {
            logger.error("查找用户喜欢的产品错误---" + e);
            e.printStackTrace();
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }

    /**
     * 检查用户是否喜欢一个产品
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/user/product/is-favorite", method = RequestMethod.GET)
    public ApiResponse isUserFavoriteProduct(ApiRequest apiRequest) {

        ApiResponse apiResponse = new ApiResponse();
        Integer endUserId = getUserIdByTokenChannel(apiRequest);
        FavoriteProductRequest favoriteProductRequest = JsonUtil.fromJSON(apiRequest.getParamJson(), FavoriteProductRequest.class);

        //判断json格式参数是否有误
        if (favoriteProductRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }

        try {
            FavoriteCommonResponse favoriteCommonResponse = favoriteService.isUserFavoriteProduct(endUserId, favoriteProductRequest.getProductId());
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(favoriteCommonResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, favoriteCommonResponse);
                return apiResponse;
            } else {
                apiResponse.setData(favoriteCommonResponse);
            }
        } catch (Exception e) {
            logger.error("检查用户是否喜欢一个产品发生错误---" + e);
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }

//    /**
//     * 新增用户喜欢的场景
//     * @param apiRequest
//     * @return
//     */
//    @RequestMapping(value = "/v1/user/scene/favorite", method = RequestMethod.POST)
//    public ApiResponse favoriteScene(ApiRequest apiRequest) {
//
//        ApiResponse apiResponse = new ApiResponse();
//        Integer endUserId = getUserIdByTokenChannel(apiRequest);
//        FavoriteSceneRequest favoriteSceneRequest = JsonUtil.fromJSON(apiRequest.getParamJson(), FavoriteSceneRequest.class);
//
//        //判断json格式参数是否有误
//        if (favoriteSceneRequest == null) {
//            setParamJsonParseErrorResponse(apiResponse);
//            return apiResponse;
//        }
//
//        try {
//            FavoriteCommonResponse favoriteCommonResponse = favoriteService.updateFavoriteScene(endUserId, favoriteSceneRequest.getSceneId());
//            //如果处理失败 则返回错误信息
//            if (ErrorCodeUtil.isFailedResponse(favoriteCommonResponse.getResCode())) {
//                setServiceErrorResponse(apiResponse, favoriteCommonResponse);
//                return apiResponse;
//            } else {
//                apiResponse.setData(favoriteCommonResponse);
//            }
//        } catch (Exception e) {
//            logger.error("新增用户喜欢的场景发生错误---" + e);
//            setInternalErrorResponse(apiResponse);
//        }
//        return apiResponse;
//    }
//
//    /**
//     * 查询用户喜欢的场景列表
//     * @param apiRequest
//     * @return
//     */
//    @RequestMapping(value = "/v1/user/scene/favorite-list", method = RequestMethod.GET)
//    public ApiResponse getFavoriteScene(ApiRequest apiRequest) {
//        ApiResponse apiResponse = new ApiResponse();
//        Integer endUserId = getUserIdByTokenChannel(apiRequest);
//        if (endUserId == null) {
//            ErrorResponseUtil.setErrorResponse(apiResponse, ErrorCodeConstant.INVALID_TOKEN);
//            return apiResponse;
//        }
//
//        try {
//        	FavoriteSceneResponse favoriteSceneResponse = favoriteService.getFavoriteScene(endUserId);
//            //如果处理失败 则返回错误信息
//            if (ErrorCodeUtil.isFailedResponse(favoriteSceneResponse.getResCode())) {
//                setServiceErrorResponse(apiResponse, favoriteSceneResponse);
//            } else {
//                List<FavoriteSceneVo> favoriteSceneVoList = favoriteSceneResponse.getFavoriteSceneVoList();
//                favoriteSceneResponse.setFavoriteSceneVoList(favoriteSceneVoList);
//                apiResponse.setData(favoriteSceneResponse);
//            }
//        } catch (Exception e) {
//            logger.error("查找用户喜欢的场景错误---" + e);
//            e.printStackTrace();
//            setInternalErrorResponse(apiResponse);
//        }
//        return apiResponse;
//    }
}