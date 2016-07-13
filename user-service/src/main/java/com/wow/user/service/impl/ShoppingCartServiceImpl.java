package com.wow.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wow.common.response.CommonResponse;
import com.wow.common.util.CollectionUtil;
import com.wow.common.util.DateUtil;
import com.wow.product.model.Product;
import com.wow.product.service.ProductService;
import com.wow.user.mapper.ShoppingCartMapper;
import com.wow.user.model.ShoppingCart;
import com.wow.user.model.ShoppingCartExample;
import com.wow.user.service.ShoppingCartService;
import com.wow.user.vo.request.ShoppingCartRequest;

/**
 * Created by zhengzhiqing on 16/6/30.
 */
@Service
@Transactional(value = "userTransactionManager")
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Autowired
    private ProductService productService;

    /**
     * 添加商品到购物车 暂不考虑组合产品
     *
     * @param shoppingCart
     * @return
     */
    @Override
    public CommonResponse addProductIntoCart(ShoppingCartRequest request) {
        CommonResponse response = new CommonResponse();

        // 业务校验开始
        //判断相关的产品id是否存在
        Product product = productService.getProductById(request.getProductId());
        if (product == null) {
            response.setResCode("41004");
            response.setResMsg("产品id不存在");

            return response;
        }
        //业务校验结束
        
        request.setEndUserId(23);

        //判断该产品用户是否已经加入到购物车
        ShoppingCartExample shoppingCartExample = new ShoppingCartExample();
        ShoppingCartExample.Criteria criteria = shoppingCartExample.createCriteria();
        criteria.andEndUserIdEqualTo(request.getEndUserId());
        criteria.andProductIdEqualTo(request.getProductId());

        List<ShoppingCart> shoppingCarts = shoppingCartMapper.selectByExample(shoppingCartExample);
        //如果该产品已经加入到购物车 则对该产品数量进行增加操作
        if (CollectionUtil.isNotEmpty(shoppingCarts)) {
            ShoppingCart shoppingCart = shoppingCarts.get(0);

            ShoppingCart targetShoppingCart = new ShoppingCart();

            targetShoppingCart.setId(shoppingCart.getId());
            targetShoppingCart.setProductQty((byte) (shoppingCart.getProductQty() + request.getProductQty()));
            targetShoppingCart.setUpdateTime(DateUtil.currentDate());

            shoppingCartMapper.updateByPrimaryKeySelective(targetShoppingCart);

        } else {
            //否则将该产品加入到用户购物车表
            ShoppingCart shoppingCart = wrapShoppingCart(request);

            shoppingCartMapper.insert(shoppingCart);
        }

        return response;
    }

    /**
     * 包装购物车信息
     * 
     * @param request
     * @return
     */
    private ShoppingCart wrapShoppingCart(ShoppingCartRequest request) {
        ShoppingCart shoppingCart = new ShoppingCart();

        //根据token获取用户id 方法待定
        shoppingCart.setEndUserId(request.getEndUserId());
        shoppingCart.setProductId(request.getProductId());
        shoppingCart.setProductQty(request.getProductQty());
        shoppingCart.setCreateTime(DateUtil.currentDate());
        shoppingCart.setUpdateTime(DateUtil.currentDate());
        shoppingCart.setIsDeleted(Boolean.FALSE); //默认不删除

        return shoppingCart;
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
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<ShoppingCart> queryShoppingCart(int endUserId) {
        return shoppingCartMapper.selectByEndUser(endUserId);
    }
}
