package com.wow.user.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wow.common.response.CommonResponse;
import com.wow.common.util.CollectionUtil;
import com.wow.common.util.DateUtil;
import com.wow.common.util.ErrorCodeUtil;
import com.wow.common.util.NumberUtil;
import com.wow.product.model.Product;
import com.wow.product.service.ProductService;
import com.wow.user.mapper.EndUserMapper;
import com.wow.user.mapper.ShoppingCartMapper;
import com.wow.user.model.EndUser;
import com.wow.user.model.ShoppingCart;
import com.wow.user.model.ShoppingCartExample;
import com.wow.user.service.ShoppingCartService;
import com.wow.user.vo.ShoppingCartResultVo;
import com.wow.user.vo.request.ShoppingCartRequest;
import com.wow.user.vo.response.ShoppingCartResponse;

/**
 * Created by zhengzhiqing on 16/6/30.
 */
@Service
@Transactional(value = "userTransactionManager")
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Autowired
    private EndUserMapper endUserMapper;

    @Autowired
    private ProductService productService;

    /**
     * 添加商品到购物车 暂不考虑组合产品 仅在用户登录的情况下调用
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
            response.setResMsg(ErrorCodeUtil.getErrorMsg("41004"));

            return response;
        }
        //业务校验结束

        request.setEndUserId(23);

        ShoppingCart shoppingCart = getShoppingCartByExample(request);
        //如果该产品已经加入到购物车 则对该产品数量进行增加操作
        if (shoppingCart != null) {
            ShoppingCart targetShoppingCart = new ShoppingCart();

            targetShoppingCart.setId(shoppingCart.getId());
            targetShoppingCart.setProductQty((byte) (shoppingCart.getProductQty() + request.getProductQty()));
            targetShoppingCart.setUpdateTime(DateUtil.currentDate());

            shoppingCartMapper.updateByPrimaryKeySelective(targetShoppingCart);
        } else {
            //否则将该产品加入到用户购物车表
            shoppingCart = wrapShoppingCart(request);

            shoppingCartMapper.insert(shoppingCart);
        }

        return response;
    }

    /**
     * 修改购物车产品数量
     *
     * @param shoppingCart
     * @return
     */
    @Override
    public CommonResponse updateProductInCart(ShoppingCartRequest request) {
        CommonResponse response = new CommonResponse();

        // 业务校验开始
        //判断相关的购物车信息id是否为空
        if (request.getShoppingCartId() == null) {
            response.setResCode("40303");
            response.setResMsg(ErrorCodeUtil.getErrorMsg("40303"));

            return response;
        }

        ShoppingCart shoppingCart = shoppingCartMapper.selectByPrimaryKey(request.getShoppingCartId());

        //判断购物车id是否存在
        if (shoppingCart == null) {
            response.setResCode("40302");
            response.setResMsg(ErrorCodeUtil.getErrorMsg("40302"));

            return response;
        }

        //业务校验结束

        //对该产品数量进行重置操作
        ShoppingCart targetShoppingCart = new ShoppingCart();

        targetShoppingCart.setId(shoppingCart.getId());
        targetShoppingCart.setProductQty(request.getProductQty());
        targetShoppingCart.setUpdateTime(DateUtil.currentDate());

        shoppingCartMapper.updateByPrimaryKeySelective(targetShoppingCart);

        return response;
    }

    /**
     * 从购物车里删除产品 支持批量删除
     *
     * @param shoppingCartIds
     * @return
     */
    @Override
    public CommonResponse removeProductsFromCart(ShoppingCartRequest request) {
        CommonResponse response = new CommonResponse();

        // 业务校验开始
        //判断相关的购物车id列表是否存在
        if (CollectionUtil.isEmpty(request.getShoppingCartIds())) {
            response.setResCode("40302");
            response.setResMsg(ErrorCodeUtil.getErrorMsg("40302"));

            return response;
        }

        //删除用户指定产品的购物车信息
        request.setIsDeleted(Boolean.TRUE);
        request.setUpdateTime(DateUtil.currentDate());

        shoppingCartMapper.updateByPrimaryKeys(request);

        return response;
    }

    @Override
    public CommonResponse queryByUserId(ShoppingCartRequest request) {
        CommonResponse response = new CommonResponse();

        // 业务校验开始
        //判断用户id是否为空
        if (request.getEndUserId() == null) {
            response.setResCode("40304");
            response.setResMsg(ErrorCodeUtil.getErrorMsg("40304"));

            return response;
        }

        EndUser endUser = endUserMapper.selectByPrimaryKey(request.getEndUserId());

        if (endUser == null) {
            response.setResCode("40305");
            response.setResMsg(ErrorCodeUtil.getErrorMsg("40305"));

            return response;
        }

        ShoppingCartResponse shoppingCartResponse = new ShoppingCartResponse();

        request.setDeleted(Boolean.FALSE);
        List<ShoppingCartResultVo> shoppingCartResult = shoppingCartMapper.queryByUserId(request);

        shoppingCartResponse.setShoppingCartResult(shoppingCartResult);

        //计算购物车商品总价
        BigDecimal totalPrice = calculateShoppingCartPrice(shoppingCartResult);

        shoppingCartResponse.setTotalPrice(totalPrice);

        return shoppingCartResponse;
    }

    /**
     * 
     * 计算用户购物车总价 拆分为分进行计算
     * @param shoppingCartResult
     * @return
     */
    private BigDecimal calculateShoppingCartPrice(List<ShoppingCartResultVo> shoppingCartResult) {
        if (CollectionUtil.isEmpty(shoppingCartResult)) {
            return new BigDecimal("0.00");
        }

        long totalPrice = 0L;
        for (ShoppingCartResultVo shoppingCart : shoppingCartResult) {
            long productPrice = NumberUtil.convertToFen(shoppingCart.getSellPrice());
            totalPrice += productPrice * shoppingCart.getProductQty();
        }

        return NumberUtil.convertToFen(totalPrice);
    }

    
    /**
     * 根据购物车用户id 产品id 获取购物车信息
     * 
     * @param request
     * @return
     */
    private ShoppingCart getShoppingCartByExample(ShoppingCartRequest request) {
        //判断该产品用户是否已经加入到购物车
        ShoppingCartExample shoppingCartExample = new ShoppingCartExample();
        ShoppingCartExample.Criteria criteria = shoppingCartExample.createCriteria();
        criteria.andEndUserIdEqualTo(request.getEndUserId());
        criteria.andProductIdEqualTo(request.getProductId());
        criteria.andIsDeletedEqualTo(Boolean.FALSE);

        return shoppingCartMapper.selectUniqueByExample(shoppingCartExample);
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
