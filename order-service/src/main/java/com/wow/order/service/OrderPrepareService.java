package com.wow.order.service;

import com.wow.order.vo.OrderVo;
import com.wow.order.vo.PackageVo;
import com.wow.user.model.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

/**
 * 订单预处理服务
 * <p>
 * Created by zhengzhiqing on 16/6/16.
 */
public interface OrderPrepareService {

    /**
     * 从购物车进入结算页,需要经过拆单(购销、代销拆分,分属不同仓库拆分)
     *
     * @param shoppingCartItem
     * @return
     */
    List<PackageVo> splitOrder(List<ShoppingCart> shoppingCartItem);

    /**
     * 按包裹计算运费
     *
     * @param packageVo
     * @return
     */
    PackageVo calculateFreight(PackageVo packageVo);
}
