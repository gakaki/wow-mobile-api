package com.wow.user.service.impl;

import com.wow.common.constant.CommonConstant;
import com.wow.common.enums.ProductStatusEnum;
import com.wow.common.response.CommonResponse;
import com.wow.common.util.CollectionUtil;
import com.wow.common.util.DateUtil;
import com.wow.common.util.ErrorCodeUtil;
import com.wow.common.util.NumberUtil;
import com.wow.product.model.Product;
import com.wow.product.service.ProductService;
import com.wow.stock.service.StockService;
import com.wow.stock.vo.AvailableStockVo;
import com.wow.stock.vo.response.AvailableStocksResponse;
import com.wow.user.mapper.EndUserMapper;
import com.wow.user.mapper.ShoppingCartMapper;
import com.wow.user.model.EndUser;
import com.wow.user.model.ShoppingCart;
import com.wow.user.model.ShoppingCartExample;
import com.wow.user.service.ShoppingCartService;
import com.wow.user.vo.ShoppingCartQueryVo;
import com.wow.user.vo.ShoppingCartResultVo;
import com.wow.user.vo.response.ShoppingCartResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private StockService stockService;

    /**
     * 添加商品到购物车 暂不考虑组合产品 仅在用户登录的情况下调用
     *
     * @param shoppingCart
     * @return
     */
    @Override
    public CommonResponse addProductIntoCart(ShoppingCart shoppingCart) {
        CommonResponse response = new CommonResponse();

        // 业务校验开始
        //如果产品id为空 则直接返回
        if(shoppingCart.getProductId()==null){
            response.setResCode("40316");
            response.setResMsg(ErrorCodeUtil.getErrorMsg("40316"));
            
            return response;
        }
        
        //判断相关的产品id是否存在
        Product product = productService.getProductById(shoppingCart.getProductId());
        if (product == null) {
            response.setResCode("40301");
            response.setResMsg(ErrorCodeUtil.getErrorMsg("40301"));

            return response;
        }
        //业务校验结束

        ShoppingCart newShoppingCart = getShoppingCartByExample(shoppingCart);
        //如果该产品已经加入到购物车 则对该产品数量进行增加操作
        if (newShoppingCart != null) {
            ShoppingCart targetShoppingCart = new ShoppingCart();

            targetShoppingCart.setId(newShoppingCart.getId());
            //对购物车中的产品数量进行增加
            targetShoppingCart.setProductQty((byte) (newShoppingCart.getProductQty() + shoppingCart.getProductQty()));
            targetShoppingCart.setUpdateTime(DateUtil.currentDate());

            shoppingCartMapper.updateByPrimaryKeySelective(targetShoppingCart);
        } else {
            //否则将该产品加入到用户购物车表
            shoppingCart = wrapShoppingCart(shoppingCart);

            shoppingCartMapper.insertSelective(shoppingCart);
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
    public CommonResponse updateProductInCart(ShoppingCartQueryVo query) {
        CommonResponse response = new CommonResponse();

        // 业务校验开始
        //判断相关的购物车信息id是否为空
        if (query.getShoppingCartId() == null) {
            response.setResCode("40303");
            response.setResMsg(ErrorCodeUtil.getErrorMsg("40303"));

            return response;
        }

        ShoppingCart shoppingCart = shoppingCartMapper.selectByPrimaryKey(query.getShoppingCartId());

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
        targetShoppingCart.setProductQty(query.getProductQty());
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
    public CommonResponse removeProductsFromCart(ShoppingCartQueryVo query) {
        CommonResponse response = new CommonResponse();

        // 业务校验开始
        //判断相关的购物车id列表是否存在
        if (CollectionUtil.isEmpty(query.getShoppingCartIds())) {
            response.setResCode("40302");
            response.setResMsg(ErrorCodeUtil.getErrorMsg("40302"));

            return response;
        }

        //删除用户指定产品的购物车信息
        query.setIsDeleted(Boolean.TRUE);
        query.setUpdateTime(DateUtil.currentDate());

        shoppingCartMapper.updateByPrimaryKeys(query);

        return response;
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public ShoppingCartResponse queryShoppingCartByUserId(ShoppingCartQueryVo query) {
        ShoppingCartResponse response = new ShoppingCartResponse();

        // 业务校验开始
        //判断用户id是否为空
        if (query.getEndUserId() == null) {
            response.setResCode("40303");
            response.setResMsg(ErrorCodeUtil.getErrorMsg("40303"));

            return response;
        }

        EndUser endUser = endUserMapper.selectByPrimaryKey(query.getEndUserId());

        if (endUser == null) {
            response.setResCode("40304");
            response.setResMsg(ErrorCodeUtil.getErrorMsg("40304"));

            return response;
        }

        List<ShoppingCartResultVo> shoppingCartResult = shoppingCartMapper.queryByUserId(query);

        if (CollectionUtil.isEmpty(shoppingCartResult)) {
            return response;
        }

        //购物车产品id列表
        List<Integer> productIds = getProductIds(shoppingCartResult);

        //调用获取产品库存服务
        AvailableStocksResponse stocksResponse = stockService.batchGetAvailableStock(productIds);

        //判断服务是否调用成功 如果处理失败 则返回错误信息
        if (ErrorCodeUtil.isFailedResponse(stocksResponse.getResCode())) {
            response.setResCode(stocksResponse.getResCode());
            response.setResMsg(stocksResponse.getResMsg());

            return response;
        }

        //设置产品库存
        setProductStock(shoppingCartResult, stocksResponse.getAvailableStockVoList());

        //计算购物车商品总价
        BigDecimal totalPrice = calculateShoppingCartPrice(shoppingCartResult);

        response.setShoppingCartResult(shoppingCartResult);
        response.setTotalPrice(totalPrice);

        return response;
    }

    /**
     * 获取产品id列表
     * 
     * @param shoppingCartResult
     * @return
     */
    private List<Integer> getProductIds(List<ShoppingCartResultVo> shoppingCartResult) {
        List<Integer> productIds = new ArrayList<>(shoppingCartResult.size());

        for (ShoppingCartResultVo shoppingCart : shoppingCartResult) {
            productIds.add(shoppingCart.getProductId());
        }

        return productIds;
    }

    /**
    * 设置相应产品的库存
    * 
    * @param shoppingCartResult
    * @param stockMap
    * @return
    */
    private void setProductStock(List<ShoppingCartResultVo> shoppingCartResult, List<AvailableStockVo> stockList) {
        if (CollectionUtil.isEmpty(stockList)) {
            return;
        }

        AvailableStockVo stockVo = null;

        //设置产品可用库存信息
        for (ShoppingCartResultVo shoppingCart : shoppingCartResult) {
            stockVo=getStockByProductId(stockList,shoppingCart.getProductId());

            //设置产品库存
            if (stockVo != null) {
                shoppingCart.setProductStock((short) stockVo.getTotalAvailableStockQty());
            }
        }
    }
    
    
    
    /**
     * 根据产品id获取产品库存
     * @param stockList 
     * 
     * @param productId
     * @return
     */
    private AvailableStockVo getStockByProductId(List<AvailableStockVo> stockList, Integer productId) {
        if(CollectionUtil.isEmpty(stockList)){
            return  null;
        }
        
        for (AvailableStockVo stock : stockList) {
            if(productId.intValue()==stock.getProductId()){
                return stock;
            }
        }
        
        return null;
    }

    /**
     * 
     * 计算用户购物车总价(单位为分进行计算)以及获取产品的库存 
     * @param shoppingCartResult
     * @return
     */
    private BigDecimal calculateShoppingCartPrice(List<ShoppingCartResultVo> shoppingCartResult) {
        if (CollectionUtil.isEmpty(shoppingCartResult)) {
            return CommonConstant.ZEROB_IGDECIMAL;
        }

        long totalPrice = 0L;
        for (ShoppingCartResultVo shoppingCart : shoppingCartResult) {
            if (shoppingCart.getProductStatus() != null) {
                //转化产品状态名称
                shoppingCart.setProductStatusName(ProductStatusEnum.get((int) shoppingCart.getProductStatus()));

                long productPrice = NumberUtil.convertToFen(shoppingCart.getSellPrice());
                long sellTotalAmount = productPrice * shoppingCart.getProductQty();
                shoppingCart.setSellTotalAmount(NumberUtil.convertToYuan(sellTotalAmount));

                //仅计算已经上架的产品价格
                if (shoppingCart.getProductStatus().intValue() == ProductStatusEnum.ORDER_STATUS_SHELVE.getKey()) {
                    totalPrice += sellTotalAmount;
                }
            }

        }

        return NumberUtil.convertToYuan(totalPrice);
    }

    /**
     * 根据购物车用户id 产品id 获取购物车信息
     * 
     * @param request
     * @return
     */
    private ShoppingCart getShoppingCartByExample(ShoppingCart shoppingCart) {
        //判断该产品用户是否已经加入到购物车
        ShoppingCartExample shoppingCartExample = new ShoppingCartExample();
        ShoppingCartExample.Criteria criteria = shoppingCartExample.createCriteria();

        criteria.andEndUserIdEqualTo(shoppingCart.getEndUserId());
        criteria.andProductIdEqualTo(shoppingCart.getProductId());
        criteria.andIsDeletedEqualTo(Boolean.FALSE);

        return shoppingCartMapper.selectUniqueByExample(shoppingCartExample);
    }

    /**
     * 包装购物车信息
     * 
     * @param shoppingCart2
     * @return
     */
    private ShoppingCart wrapShoppingCart(ShoppingCart shoppingCart) {
        ShoppingCart newShoppingCart = new ShoppingCart();

        //根据token获取用户id 方法待定
        newShoppingCart.setEndUserId(shoppingCart.getEndUserId());
        newShoppingCart.setProductId(shoppingCart.getProductId());
        newShoppingCart.setProductQty(shoppingCart.getProductQty());
        newShoppingCart.setCreateTime(DateUtil.currentDate());
        newShoppingCart.setUpdateTime(DateUtil.currentDate());
        newShoppingCart.setIsDeleted(Boolean.FALSE); //默认不删除

        return newShoppingCart;
    }

    /**
     * 查询购物车信息
     *
     * @param endUserId
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<ShoppingCart> queryShoppingCart(int endUserId) {
        return shoppingCartMapper.selectByEndUser(endUserId);
    }

    /**
     * @param endUserId
     * @return
     */
    @Override
    public int getProductQtyInCart(int endUserId) {
        Integer cnt = shoppingCartMapper.getProductQtyInCart(endUserId);
        if (cnt == null) {
            cnt = 0;
        }
        return cnt;
    }

}
