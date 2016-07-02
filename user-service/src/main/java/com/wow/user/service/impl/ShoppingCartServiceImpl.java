package com.wow.user.service.impl;

import com.wow.user.mapper.ShoppingCartMapper;
import com.wow.user.model.ShoppingCart;
import com.wow.user.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhengzhiqing on 16/6/30.
 */
@Service
@Transactional(value = "userTransactionManager")
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    /**
     * 添加商品到购物车
     *
     * @param shoppingCart
     * @return
     */
    @Override
    public int addProductIntoCart(ShoppingCart shoppingCart) {
        return shoppingCartMapper.insert(shoppingCart);
    }

    /**
     * 修改购物车里的产品
     *
     * @param shoppingCart
     * @return
     */
    @Override
    public int updateProductInCart(ShoppingCart shoppingCart) {
        return shoppingCartMapper.updateByPrimaryKeySelective(shoppingCart);
    }

    /**
     * 从购物车里删除产品
     *
     * @param shoppingCartIds
     * @return
     */
    @Override
    public int removeProductsFromCart(List<Integer> shoppingCartIds) {
        int i = 0;
        for (Integer shoppingCartId : shoppingCartIds) {
            shoppingCartMapper.deleteByPrimaryKey(shoppingCartId);
            i++;
        }
        return i;
    }

    /**
     * 查询购物车信息
     *
     * @param endUserId
     * @return
     */
    @Override
    public List<ShoppingCart> queryShoppingCart(int endUserId) {
        return shoppingCartMapper.selectByEndUser(endUserId);
    }
}
