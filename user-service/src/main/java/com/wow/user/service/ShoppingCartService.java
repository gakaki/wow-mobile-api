package com.wow.user.service;

import java.util.List;

import com.wow.common.response.CommonResponse;
import com.wow.user.model.ShoppingCart;
import com.wow.user.vo.ShoppingCartQueryVo;
import com.wow.user.vo.response.ShoppingCartResponse;

/**
 * Created by zhengzhiqing on 16/6/30.
 */
public interface ShoppingCartService {
    /**
     * 添加商品到购物车
     * @param shoppingCart
     * @return
     */
    CommonResponse addProductIntoCart(ShoppingCart shoppingCart);

    /**
     * 修改购物车里的产品
     * @param shoppingCart
     * @return
     */
    CommonResponse updateProductInCart(ShoppingCartQueryVo query);

    /**
     * 从购物车里批量删除产品
     * @param shoppingCartIds
     * @return
     */
    CommonResponse removeProductsFromCart(ShoppingCartQueryVo query);

    /**
     * 查询购物车信息
     * @param endUserId
     * @return
     */
    List<ShoppingCart> queryShoppingCart(int endUserId);

    /**
     * 获取用户购物车信息列表明细
     * 
     * @param request
     * @return
     */
    ShoppingCartResponse queryShoppingCartByUserId(ShoppingCartQueryVo query);

}
