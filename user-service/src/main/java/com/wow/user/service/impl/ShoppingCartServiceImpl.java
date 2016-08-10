package com.wow.user.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wow.common.constant.CommonConstant;
import com.wow.common.enums.ProductStatusEnum;
import com.wow.common.response.CommonResponse;
import com.wow.common.util.CollectionUtil;
import com.wow.common.util.DateUtil;
import com.wow.common.util.ErrorCodeUtil;
import com.wow.common.util.MapUtil;
import com.wow.common.util.NumberUtil;
import com.wow.price.model.ProductPrice;
import com.wow.price.service.PriceService;
import com.wow.price.vo.ProductListPriceResponse;
import com.wow.price.vo.ProductPriceResponse;
import com.wow.product.mapper.ProductSerialMapper;
import com.wow.product.model.Product;
import com.wow.product.model.ProductSerial;
import com.wow.product.model.ProductSerialExample;
import com.wow.product.service.ProductService;
import com.wow.stock.service.StockService;
import com.wow.stock.vo.AvailableStockVo;
import com.wow.stock.vo.response.AvailableStockResponse;
import com.wow.stock.vo.response.AvailableStocksResponse;
import com.wow.user.mapper.ShoppingCartMapper;
import com.wow.user.model.ShoppingCart;
import com.wow.user.model.ShoppingCartExample;
import com.wow.user.service.ShoppingCartService;
import com.wow.user.vo.ShoppingCartQueryVo;
import com.wow.user.vo.ShoppingCartResultVo;
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
    private ProductService productService;

    @Autowired
    private StockService stockService;

    @Autowired
    private PriceService priceService;

    @Autowired
    private ProductSerialMapper productSerialMapper;

    /**
     * 添加商品到购物车 暂不考虑组合产品 仅在用户登录的情况下调用
     *
     * @param shoppingCart
     * @return
     */
    @Override
    public CommonResponse addProductIntoCart(ShoppingCartQueryVo query) {
        CommonResponse response = new CommonResponse();

        // 业务校验开始
        //如果产品id为空 则直接返回
        if (query.getProductId() == null) {
            response.setResCode("40316");
            response.setResMsg(ErrorCodeUtil.getErrorMsg("40316"));

            return response;
        }

        //判断相关的产品id是否存在
        Product product = productService.getProductById(query.getProductId());
        if (product == null) {
            response.setResCode("40301");
            response.setResMsg(ErrorCodeUtil.getErrorMsg("40301"));

            return response;
        }

        //如果产品类型不是普通品 则无法加入到购物车
        if (product.getProductType().byteValue() != CommonConstant.ONE.byteValue()) {
            response.setResCode("40327");
            response.setResMsg(ErrorCodeUtil.getErrorMsg("40327"));

            return response;
        }

        //如果产品未上架 则直接返回错误提示
        if (product.getProductStatus().intValue() == ProductStatusEnum.PRODUCT_STATUS_TO_BE_SHELVE.getKey()) {
            response.setResCode("40325");
            response.setResMsg(ErrorCodeUtil.getErrorMsg("40325"));

            return response;
        }

        //如果产品已下架 则直接返回错误提示
        if (product.getProductStatus().intValue() == ProductStatusEnum.ORDER_STATUS_OFF_SHELVE.getKey()) {
            response.setResCode("40322");
            response.setResMsg(ErrorCodeUtil.getErrorMsg("40322"));

            return response;
        }
        //业务校验结束

        //如果购物车数量为空 则默认为1
        if (query.getProductQty() == null) {
            query.setProductQty((byte) 1);
        }

        //调用获取产品价格服务
        ProductPriceResponse priceResponse = priceService.getProductPrice(product.getId());

        //判断服务是否调用成功 如果处理失败 则返回错误信息
        if (ErrorCodeUtil.isFailedResponse(priceResponse.getResCode())) {
            response.setResCode(priceResponse.getResCode());
            response.setResMsg(priceResponse.getResMsg());

            return response;
        }

        ProductPrice productPrice = priceResponse.getProductPrice();

        //设置产品的价格和重量快照
        query.setSellPrice(productPrice == null ? BigDecimal.ZERO : productPrice.getSellPrice());
        query.setWeight(product.getWeight());

        ShoppingCart shoppingCart = getShoppingCartByExample(query);
        //如果该产品未加入到购物车则新增
        if (shoppingCart == null) {
            shoppingCart = wrapShoppingCart(query);

            shoppingCartMapper.insertSelective(shoppingCart);
        } else {
            //如果该产品已经加入到购物车 则对该产品数量进行增加操作
            ShoppingCart targetShoppingCart = new ShoppingCart();

            targetShoppingCart.setId(shoppingCart.getId());
            //对购物车中的产品数量进行增加
            targetShoppingCart.setProductQty((byte) (shoppingCart.getProductQty() + query.getProductQty()));
            targetShoppingCart.setUpdateTime(DateUtil.currentDate());

            shoppingCartMapper.updateByPrimaryKeySelective(targetShoppingCart);
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

        //判断购物车id是否已经被删除
        if (shoppingCart.getIsDeleted()) {
            response.setResCode("40328");
            response.setResMsg(ErrorCodeUtil.getErrorMsg("40328"));

            return response;
        }

        //判断加入的产品是否有库存 如果库存不足 则直接返回
        AvailableStockResponse availableStockResponse = stockService.getAvailableStock(shoppingCart.getProductId());
        if (ErrorCodeUtil.isFailedResponse(availableStockResponse.getResCode())) {
            response.setResCode(availableStockResponse.getResCode());
            response.setResMsg(ErrorCodeUtil.getErrorMsg(availableStockResponse.getResCode()));

            return response;
        }

        //判断库存是否可用 如果当前可用库存小于要加入购物车的数量 则直接返回
        AvailableStockVo availableStockVo = availableStockResponse.getAvailableStockVo();
        if (availableStockVo == null || availableStockVo.getTotalAvailableStockQty() < query.getProductQty()) {
            response.setResCode("50608");
            response.setResMsg(ErrorCodeUtil.getErrorMsg("50608"));

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

        ShoppingCartExample shoppingCartExample = new ShoppingCartExample();
        ShoppingCartExample.Criteria criteria = shoppingCartExample.createCriteria();
        criteria.andIdIn(query.getShoppingCartIds());
        criteria.andIsDeletedEqualTo(Boolean.FALSE);

        List<ShoppingCart> shoppingCarts = shoppingCartMapper.selectByExample(shoppingCartExample);

        //如果需要删除的购物车列表和参数请求的不一致 则直接返回错误
        if (shoppingCarts.size() != query.getShoppingCartIds().size()) {
            response.setResCode("40329");
            response.setResMsg(ErrorCodeUtil.getErrorMsg("40329"));

            return response;
        }

        //删除用户指定产品的购物车信息
        query.setIsDeleted(Boolean.TRUE);
        query.setUpdateTime(DateUtil.currentDate());
        //设置期望的删除标记为未删除(丢弃已经删除的防并发)
        query.setExpectIsDeleted(Boolean.FALSE);

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

        //调用获取产品价格服务
        ProductListPriceResponse priceResponse = priceService.batchGetProductPrice(productIds);

        //判断服务是否调用成功 如果处理失败 则返回错误信息
        if (ErrorCodeUtil.isFailedResponse(priceResponse.getResCode())) {
            response.setResCode(priceResponse.getResCode());
            response.setResMsg(priceResponse.getResMsg());

            return response;
        }

        //设置产品价格
        setProductPrice(shoppingCartResult, priceResponse.getMap());

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
        response.setTotalAmount(totalPrice);

        return response;
    }

    /**
     * 设置产品价格
     * 
     * @param shoppingCartResult
     * @param map
     */
    private void setProductPrice(List<ShoppingCartResultVo> shoppingCartResult, Map<Integer, ProductPrice> map) {
        if (MapUtil.isEmpty(map)) {
            return;
        }

        ProductPrice productPrice = null;

        //设置产品可用库存信息
        for (ShoppingCartResultVo shoppingCart : shoppingCartResult) {
            productPrice = map.get(shoppingCart.getProductId());

            //设置产品库存
            if (productPrice != null) {
                shoppingCart.setSellPrice(productPrice.getSellPrice());
            }
        }
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
            stockVo = getStockByProductId(stockList, shoppingCart.getProductId());

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
        if (CollectionUtil.isEmpty(stockList)) {
            return null;
        }

        for (AvailableStockVo stock : stockList) {
            if (productId.intValue() == stock.getProductId()) {
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
            return CommonConstant.ZERO_BIGDECIMAL;
        }

        long totalPrice = 0L;
        for (ShoppingCartResultVo shoppingCart : shoppingCartResult) {
            //判断产品状态是否为空
            if (shoppingCart.getProductStatus() == null) {
                continue;
            }

            //转化产品状态名称
            shoppingCart.setProductStatusName(ProductStatusEnum.get((int) shoppingCart.getProductStatus()));

            long productPrice = NumberUtil.convertToFen(shoppingCart.getSellPrice());
            long sellTotalAmount = productPrice * shoppingCart.getProductQty();
            shoppingCart.setProductTotalAmount(NumberUtil.convertToYuan(sellTotalAmount));

            //是否已上架
            boolean isShelve = shoppingCart.getProductStatus().intValue() == ProductStatusEnum.ORDER_STATUS_SHELVE
                .getKey();
            //是否已选中
            boolean isSelected = shoppingCart.getIsSelected() == null ? false : shoppingCart.getIsSelected();
            //仅计算已经上架并且用户选中的购物车产品价格
            if (isShelve && isSelected) {
                totalPrice += sellTotalAmount;
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
    private ShoppingCart getShoppingCartByExample(ShoppingCartQueryVo query) {
        //判断该产品用户是否已经加入到购物车
        ShoppingCartExample shoppingCartExample = new ShoppingCartExample();
        ShoppingCartExample.Criteria criteria = shoppingCartExample.createCriteria();

        criteria.andEndUserIdEqualTo(query.getEndUserId());
        criteria.andProductIdEqualTo(query.getProductId());
        criteria.andIsDeletedEqualTo(Boolean.FALSE);

        return shoppingCartMapper.selectUniqueByExample(shoppingCartExample);
    }

    /**
     * 包装购物车信息
     * 
     * @param shoppingCart2
     * @return
     */
    private ShoppingCart wrapShoppingCart(ShoppingCartQueryVo query) {
        ShoppingCart newShoppingCart = new ShoppingCart();

        newShoppingCart.setEndUserId(query.getEndUserId());
        newShoppingCart.setProductId(query.getProductId());

        //获取父产品信息
        ProductSerial parentProduct = getParentProduct(query.getProductId());
        newShoppingCart.setParentProductId(parentProduct == null ? 0 : parentProduct.getProductId());

        newShoppingCart.setProductQty(query.getProductQty());
        newShoppingCart.setProductPrice(query.getSellPrice());
        newShoppingCart.setWeight(query.getWeight());

        newShoppingCart.setCreateTime(DateUtil.currentDate());
        newShoppingCart.setUpdateTime(DateUtil.currentDate());

        newShoppingCart.setIsDeleted(Boolean.FALSE); //默认不删除
        newShoppingCart.setIsSelected(Boolean.TRUE);//默认选中

        return newShoppingCart;
    }

    /**
     * 根据产品id获取父产品信息
     * 
     * @param productId
     * @return
     */
    private ProductSerial getParentProduct(Integer productId) {
        ProductSerialExample productSerialExample = new ProductSerialExample();
        ProductSerialExample.Criteria criteria = productSerialExample.createCriteria();
        criteria.andSubProductIdEqualTo(productId);

        return productSerialMapper.selectUniqueByExample(productSerialExample);
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

        return cnt == null ? 0 : cnt;
    }

    @Override
    public CommonResponse selectOrCancelShoppingCart(ShoppingCartQueryVo query) {
        CommonResponse response = new CommonResponse();

        // 业务校验开始
        //判断相关的购物车id列表是否存在
        if (CollectionUtil.isEmpty(query.getShoppingCartIds())) {
            response.setResCode("40302");
            response.setResMsg(ErrorCodeUtil.getErrorMsg("40302"));

            return response;
        }

        //选中或者取消用户指定的购物车信息
        query.setUpdateTime(DateUtil.currentDate());

        shoppingCartMapper.updateByPrimaryKeys(query);

        return response;
    }

}
