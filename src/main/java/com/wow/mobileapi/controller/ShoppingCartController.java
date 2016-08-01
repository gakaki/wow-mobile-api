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
import com.wow.common.util.JsonUtil;
import com.wow.common.util.StringUtil;
import com.wow.common.util.ValidatorUtil;
import com.wow.mobileapi.request.user.ShoppingCartRequest;
import com.wow.user.model.ShoppingCart;
import com.wow.user.service.ShoppingCartService;
import com.wow.user.vo.ShoppingCartQueryVo;
import com.wow.user.vo.response.ShoppingCartResponse;

/**
 * 购物车相关controller
 * 
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月13日 下午2:26:51 Exp $
 */
@RestController
@RequestMapping("/v1/cart")
public class ShoppingCartController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(ShoppingCartController.class);

    @Autowired
    private ShoppingCartService shoppingCartService;

    /**
     * 添加指定的产品到购物车
     * 
     * @param request
     * @return
     */
    @RequestMapping(value = "/add", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
    public ApiResponse addProductIntoCart(ApiRequest request) {
        ShoppingCartRequest shoppingCartRequest = JsonUtil.fromJSON(request.getParamJson(), ShoppingCartRequest.class);
        ApiResponse apiResponse = new ApiResponse();

        //判断json格式参数是否有误
        if (shoppingCartRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }

        String errorMsg = ValidatorUtil.getError(shoppingCartRequest);
        //如果校验错误 则返回
        if (StringUtil.isNotEmpty(errorMsg)) {
            setInvalidParameterResponse(apiResponse, errorMsg);
            return apiResponse;
        }
        try {
            //包装购物车对象
            ShoppingCart shoppingCart = new ShoppingCart();

            //设置用户id
            Integer endUserId = getUserIdByTokenChannel(request);
            shoppingCart.setEndUserId(endUserId);
            shoppingCart.setProductId(shoppingCartRequest.getProductId());
            shoppingCart.setProductQty(shoppingCartRequest.getProductQty());

            CommonResponse commonResponse = shoppingCartService.addProductIntoCart(shoppingCart);
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(commonResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, commonResponse);
            }
        } catch (Exception e) {
            logger.error("添加产品到购物车错误---" + e);
            setInternalErrorResponse(apiResponse);
        }

        return apiResponse;
    }

    /**
     * 修改购物车产品数量
     * 
     * @param request
     * @return
     */
    @RequestMapping(value = "/modify", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
    public ApiResponse modifyCart(ApiRequest request) {
        ShoppingCartRequest shoppingCartRequest = JsonUtil.fromJSON(request.getParamJson(), ShoppingCartRequest.class);
        ApiResponse apiResponse = new ApiResponse();

        //判断json格式参数是否有误
        if (shoppingCartRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }

        String errorMsg = ValidatorUtil.getError(shoppingCartRequest);
        //如果校验错误 则返回
        if (StringUtil.isNotEmpty(errorMsg)) {
            setInvalidParameterResponse(apiResponse, errorMsg);
            return apiResponse;
        }
        try {
            //包装购物车查询对象
            ShoppingCartQueryVo query = new ShoppingCartQueryVo();

            query.setShoppingCartId(shoppingCartRequest.getShoppingCartId());
            query.setProductQty(shoppingCartRequest.getProductQty());

            CommonResponse commonResponse = shoppingCartService.updateProductInCart(query);
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(commonResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, commonResponse);
            }
        } catch (Exception e) {
            logger.error("修改购物车产品数量错误---" + e);
            setInternalErrorResponse(apiResponse);
        }

        return apiResponse;
    }

    /**
     * 删除购物车产品
     * 
     * @param request
     * @return
     */
    @RequestMapping(value = "/remove", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
    public ApiResponse removeProductsFromCart(ApiRequest request) {
        ShoppingCartRequest shoppingCartRequest = JsonUtil.fromJSON(request.getParamJson(), ShoppingCartRequest.class);
        ApiResponse apiResponse = new ApiResponse();

        //判断json格式参数是否有误
        if (shoppingCartRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }

        String errorMsg = ValidatorUtil.getError(shoppingCartRequest);
        //如果校验错误 则返回
        if (StringUtil.isNotEmpty(errorMsg)) {
            setInvalidParameterResponse(apiResponse, errorMsg);
            return apiResponse;
        }
        try {
            //包装购物车查询对象
            ShoppingCartQueryVo query = new ShoppingCartQueryVo();

            query.setShoppingCartIds(shoppingCartRequest.getShoppingCartIds());

            CommonResponse commonResponse = shoppingCartService.removeProductsFromCart(query);
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(commonResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, commonResponse);
            }
        } catch (Exception e) {
            logger.error("删除购物车产品错误---" + e);
            setInternalErrorResponse(apiResponse);
        }

        return apiResponse;
    }

    /**
     * 获取用户购物车产品信息
     * 
     * @param request
     * @return
     */
    @RequestMapping(value = "/get", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public ApiResponse queryShoppingCartByUserId(ApiRequest request) {
        ApiResponse apiResponse = new ApiResponse();

        try {
            //包装购物车查询对象
            ShoppingCartQueryVo query = new ShoppingCartQueryVo();

            Integer endUserId = getUserIdByTokenChannel(request);
            query.setEndUserId(endUserId);

            ShoppingCartResponse shoppingCartResponse = shoppingCartService.queryShoppingCartByUserId(query);
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(shoppingCartResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, shoppingCartResponse);
            } else {
                apiResponse.setData(shoppingCartResponse);
            }
        } catch (Exception e) {
            logger.error("获取用户购物车产品错误---" + e);
            setInternalErrorResponse(apiResponse);
        }

        return apiResponse;
    }

    /**
     * 添加指定的产品到购物车
     * 
     * @param request
     * @return
     */
    @RequestMapping(value = "/select", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public ApiResponse selectShoppingCart(ApiRequest request) {
        ShoppingCartRequest shoppingCartRequest = JsonUtil.fromJSON(request.getParamJson(), ShoppingCartRequest.class);
        ApiResponse apiResponse = new ApiResponse();

        //判断json格式参数是否有误
        if (shoppingCartRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }

        try {
            ShoppingCartQueryVo query = new ShoppingCartQueryVo();
            query.setShoppingCartId(shoppingCartRequest.getShoppingCartId());
            query.setIsSelected(Boolean.TRUE);

            CommonResponse commonResponse = shoppingCartService.selectOrCancelShoppingCart(query);
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(commonResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, commonResponse);
            }
        } catch (Exception e) {
            logger.error("选中购物车错误---" + e);
            setInternalErrorResponse(apiResponse);
        }

        return apiResponse;
    }

    /**
     * 取消选中的购物车
     * 
     * @param request
     * @return
     */
    @RequestMapping(value = "/cancelSelect", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public ApiResponse cancelSelectShoppingCart(ApiRequest request) {
        ShoppingCartRequest shoppingCartRequest = JsonUtil.fromJSON(request.getParamJson(), ShoppingCartRequest.class);
        ApiResponse apiResponse = new ApiResponse();

        //判断json格式参数是否有误
        if (shoppingCartRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }

        try {
            ShoppingCartQueryVo query = new ShoppingCartQueryVo();
            query.setShoppingCartId(shoppingCartRequest.getShoppingCartId());
            query.setIsSelected(Boolean.FALSE);

            CommonResponse commonResponse = shoppingCartService.selectOrCancelShoppingCart(query);
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(commonResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, commonResponse);
            }
        } catch (Exception e) {
            logger.error("取消选中购物车错误---" + e);
            setInternalErrorResponse(apiResponse);
        }

        return apiResponse;
    }

}
