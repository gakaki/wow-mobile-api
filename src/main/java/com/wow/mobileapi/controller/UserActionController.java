package com.wow.mobileapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wow.common.request.ApiRequest;
import com.wow.common.response.ApiResponse;
import com.wow.common.response.CommonResponse;
import com.wow.common.util.ErrorCodeUtil;
import com.wow.common.util.ErrorResponseUtil;
import com.wow.common.util.JsonUtil;
import com.wow.mobileapi.constant.ErrorCodeConstant;
import com.wow.user.service.LikeService;
import com.wow.user.vo.request.LikedBrandRequest;
import com.wow.user.vo.request.LikedDesignerRequest;
import com.wow.user.vo.request.LikedProductRequest;
import com.wow.user.vo.request.LikedSceneRequest;
import com.wow.user.vo.response.LikedBrandResponse;
import com.wow.user.vo.response.LikedDesignerResponse;
import com.wow.user.vo.response.LikedProductResponse;
import com.wow.user.vo.response.LikedSceneResponse;

@RestController
public class UserActionController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserActionController.class);

    @Autowired
    private LikeService likeService;

    /**
     * 新增用户喜欢的品牌
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/user/like/brand/add", method = RequestMethod.POST)
    public ApiResponse addUserLikeBrand(ApiRequest apiRequest) {

        ApiResponse apiResponse = new ApiResponse();
        Integer endUserId = getUserIdByTokenChannel(apiRequest);
        LikedBrandRequest likedBrandRequest = JsonUtil.fromJSON(apiRequest.getParamJson(), LikedBrandRequest.class);
        
        //判断json格式参数是否有误
        if (likedBrandRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }
        
        try {
            CommonResponse commonResponse = likeService.likeBrand(endUserId, likedBrandRequest.getBrandId());
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(commonResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, commonResponse);
                return apiResponse;
            }
        } catch (Exception e) {
            logger.error("新增用户喜欢的品牌发生错误---" + e);
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }

    /**
     * 删除用户喜欢的品牌
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/user/like/brand/delete", method = RequestMethod.POST)
    public ApiResponse deleteUserLikeBrand(ApiRequest apiRequest) {

        ApiResponse apiResponse = new ApiResponse();
        LikedBrandRequest likedBrandRequest = JsonUtil.fromJSON(apiRequest.getParamJson(), LikedBrandRequest.class);
        
        //判断json格式参数是否有误
        if (likedBrandRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }
        
        try {
            CommonResponse commonResponse = likeService.deleteLikedBrand(likedBrandRequest.getId());
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(commonResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, commonResponse);
                return apiResponse;
            }
        } catch (Exception e) {
            logger.error("删除用户喜欢的品牌发生错误---" + e);
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }
    
    /**
     * 查询用户喜欢的品牌列表
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/user/like/brand", method = RequestMethod.GET)
    public ApiResponse getUserLikedBrand(ApiRequest apiRequest) {
        ApiResponse apiResponse = new ApiResponse();
        Integer endUserId = getUserIdByTokenChannel(apiRequest);
        if (endUserId == null) {
            ErrorResponseUtil.setErrorResponse(apiResponse, ErrorCodeConstant.INVALID_TOKEN);
            return apiResponse;
        }

        try {
            LikedBrandResponse likedBrandResponse = likeService.getLikedBrand(endUserId);
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(likedBrandResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, likedBrandResponse);
            } else {
                apiResponse.setData(likedBrandResponse);
            }
        } catch (Exception e) {
            logger.error("查找用户喜欢的品牌错误---" + e);
            e.printStackTrace();
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }


    /**
     * 新增用户喜欢的设计师
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/user/like/designer/add", method = RequestMethod.POST)
    public ApiResponse addUserLikeDesigner(ApiRequest apiRequest) {

        ApiResponse apiResponse = new ApiResponse();
        Integer endUserId = getUserIdByTokenChannel(apiRequest);
        LikedDesignerRequest likedDesignerRequest = JsonUtil.fromJSON(apiRequest.getParamJson(), LikedDesignerRequest.class);
        
        //判断json格式参数是否有误
        if (likedDesignerRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }
        
        try {
            CommonResponse commonResponse = likeService.likeDesigner(endUserId, likedDesignerRequest.getDesignerId());
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(commonResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, commonResponse);
                return apiResponse;
            }
        } catch (Exception e) {
            logger.error("新增用户喜欢的设计师发生错误---" + e);
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }

    /**
     * 删除用户喜欢的设计师
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/user/like/designer/delete", method = RequestMethod.POST)
    public ApiResponse deleteUserLikeDesigner(ApiRequest apiRequest) {

        ApiResponse apiResponse = new ApiResponse();
        LikedDesignerRequest likedDesignerRequest = JsonUtil.fromJSON(apiRequest.getParamJson(), LikedDesignerRequest.class);
        
        //判断json格式参数是否有误
        if (likedDesignerRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }
        
        try {
            CommonResponse commonResponse = likeService.deleteLikedBrand(likedDesignerRequest.getId());
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(commonResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, commonResponse);
                return apiResponse;
            }
        } catch (Exception e) {
            logger.error("删除用户喜欢的设计师发生错误---" + e);
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }
    
    /**
     * 查询用户喜欢的设计师列表
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/user/like/designer", method = RequestMethod.GET)
    public ApiResponse getUserLikedDesigner(ApiRequest apiRequest) {
        ApiResponse apiResponse = new ApiResponse();
        Integer endUserId = getUserIdByTokenChannel(apiRequest);
        if (endUserId == null) {
            ErrorResponseUtil.setErrorResponse(apiResponse, ErrorCodeConstant.INVALID_TOKEN);
            return apiResponse;
        }

        try {
        	LikedDesignerResponse likedDesignerResponse = likeService.getLikedDesigner(endUserId);
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(likedDesignerResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, likedDesignerResponse);
            } else {
                apiResponse.setData(likedDesignerResponse);
            }
        } catch (Exception e) {
            logger.error("查找用户喜欢的设计师错误---" + e);
            e.printStackTrace();
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }
    

    /**
     * 新增用户喜欢的产品
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/user/like/product/add", method = RequestMethod.POST)
    public ApiResponse addUserLikeProduct(ApiRequest apiRequest) {

        ApiResponse apiResponse = new ApiResponse();
        Integer endUserId = getUserIdByTokenChannel(apiRequest);
        LikedProductRequest likedProductRequest = JsonUtil.fromJSON(apiRequest.getParamJson(), LikedProductRequest.class);
        
        //判断json格式参数是否有误
        if (likedProductRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }
        
        try {
            CommonResponse commonResponse = likeService.likeBrand(endUserId, likedProductRequest.getProductId());
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(commonResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, commonResponse);
                return apiResponse;
            }
        } catch (Exception e) {
            logger.error("新增用户喜欢的产品发生错误---" + e);
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }

    /**
     * 删除用户喜欢的产品
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/user/like/product/delete", method = RequestMethod.POST)
    public ApiResponse deleteUserLikeProduct(ApiRequest apiRequest) {

        ApiResponse apiResponse = new ApiResponse();
        LikedProductRequest likedProductRequest = JsonUtil.fromJSON(apiRequest.getParamJson(), LikedProductRequest.class);
        
        //判断json格式参数是否有误
        if (likedProductRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }
        
        try {
            CommonResponse commonResponse = likeService.deleteLikedBrand(likedProductRequest.getId());
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(commonResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, commonResponse);
                return apiResponse;
            }
        } catch (Exception e) {
            logger.error("删除用户喜欢的产品发生错误---" + e);
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }
    
    /**
     * 查询用户喜欢的产品列表
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/user/like/product", method = RequestMethod.GET)
    public ApiResponse getUserLikedProduct(ApiRequest apiRequest) {
        ApiResponse apiResponse = new ApiResponse();
        Integer endUserId = getUserIdByTokenChannel(apiRequest);
        if (endUserId == null) {
            ErrorResponseUtil.setErrorResponse(apiResponse, ErrorCodeConstant.INVALID_TOKEN);
            return apiResponse;
        }

        try {
        	LikedProductResponse likedProductResponse = likeService.getLikedProduct(endUserId);
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(likedProductResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, likedProductResponse);
            } else {
                apiResponse.setData(likedProductResponse);
            }
        } catch (Exception e) {
            logger.error("查找用户喜欢的产品错误---" + e);
            e.printStackTrace();
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }
    

    /**
     * 新增用户喜欢的场景
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/user/like/scene/add", method = RequestMethod.POST)
    public ApiResponse addUserLikeScene(ApiRequest apiRequest) {

        ApiResponse apiResponse = new ApiResponse();
        Integer endUserId = getUserIdByTokenChannel(apiRequest);
        LikedSceneRequest likedSceneRequest = JsonUtil.fromJSON(apiRequest.getParamJson(), LikedSceneRequest.class);
        
        //判断json格式参数是否有误
        if (likedSceneRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }
        
        try {
            CommonResponse commonResponse = likeService.likeBrand(endUserId, likedSceneRequest.getSceneId());
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(commonResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, commonResponse);
                return apiResponse;
            }
        } catch (Exception e) {
            logger.error("新增用户喜欢的场景发生错误---" + e);
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }

    /**
     * 删除用户喜欢的场景
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/user/like/scene/delete", method = RequestMethod.POST)
    public ApiResponse deleteUserLikeScene(ApiRequest apiRequest) {

        ApiResponse apiResponse = new ApiResponse();
        LikedSceneRequest likedSceneRequest = JsonUtil.fromJSON(apiRequest.getParamJson(), LikedSceneRequest.class);
        
        //判断json格式参数是否有误
        if (likedSceneRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }
        
        try {
            CommonResponse commonResponse = likeService.deleteLikedBrand(likedSceneRequest.getId());
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(commonResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, commonResponse);
                return apiResponse;
            }
        } catch (Exception e) {
            logger.error("删除用户喜欢的场景发生错误---" + e);
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }
    
    /**
     * 查询用户喜欢的场景列表
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/user/like/scene", method = RequestMethod.GET)
    public ApiResponse getUserLikedScene(ApiRequest apiRequest) {
        ApiResponse apiResponse = new ApiResponse();
        Integer endUserId = getUserIdByTokenChannel(apiRequest);
        if (endUserId == null) {
            ErrorResponseUtil.setErrorResponse(apiResponse, ErrorCodeConstant.INVALID_TOKEN);
            return apiResponse;
        }

        try {
        	LikedSceneResponse likedSceneResponse = likeService.getLikedScene(endUserId);
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(likedSceneResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, likedSceneResponse);
            } else {
                apiResponse.setData(likedSceneResponse);
            }
        } catch (Exception e) {
            logger.error("查找用户喜欢的场景错误---" + e);
            e.printStackTrace();
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }
    
    

}