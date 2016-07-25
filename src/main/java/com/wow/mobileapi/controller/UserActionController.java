package com.wow.mobileapi.controller;

import com.wow.common.request.ApiRequest;
import com.wow.common.response.ApiResponse;
import com.wow.common.util.ErrorCodeUtil;
import com.wow.common.util.ErrorResponseUtil;
import com.wow.mobileapi.constant.ErrorCodeConstant;
import com.wow.mobileapi.util.ImgPrefixUtil;
import com.wow.user.service.LikeService;
import com.wow.user.service.UserService;
import com.wow.user.vo.LikedBrandVo;
import com.wow.user.vo.response.LikedBrandResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserActionController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserActionController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private LikeService likeService;


    /**
     * 用户喜欢的品牌列表
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/user/brand/like", method = RequestMethod.GET)
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
                List<LikedBrandVo> likedBrandVoList = likedBrandResponse.getLikedBrandVoList();
                for (LikedBrandVo likedBrandVo : likedBrandVoList) {
                    likedBrandVo.setBrandLogoImg(ImgPrefixUtil.addPrefixForImgUrl(likedBrandVo.getBrandLogoImg()));
                }
                apiResponse.setData(likedBrandVoList);
            }
        } catch (Exception e) {
            logger.error("查找用户喜欢的品牌错误---" + e);
            e.printStackTrace();
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }

    //TODO:
    //用户喜欢品牌

    //用户喜欢设计师
    //用户喜欢的设计师列表

    //用户喜欢产品
    //用户喜欢的产品列表

}