package com.wow.order.service.impl;

import com.wow.order.service.OrderPrepareService;
import com.wow.order.vo.PackageVo;
import com.wow.order.vo.PaymentVo;
import com.wow.user.model.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengzhiqing on 16/6/16.
 */
public class OrderPrepareServiceImpl implements OrderPrepareService {
    //从购物车进入结算页,需要经过拆单(购销、代销拆分,分属不同仓库拆分)
    public List<PackageVo> splitOrder(List<ShoppingCart> shoppingCartItem) {
        List<PackageVo> packageList = new ArrayList<PackageVo>();

        //便利所有购物车里的商品,判断商品的销售类型,将购销的和代销的拆成两部分,不同的供应商分别是不同的订单
        List<ShoppingCart> directSale = new ArrayList<ShoppingCart>();
        for (ShoppingCart shoppingCart : directSale) {
            //判断商品可以库存所在仓库,如果所有商品都在同一仓库,只有一单
            //如果部分商品在不同仓库,按仓库个数拆单,能在一个仓库发的都尽量在一个仓库发
            //如果某种商品,多个仓库都有,则该商品会被分到多个订单中
            //如果购销商品实际库存用完,但有虚拟库存,则虚拟库存部分单独成单
        }


        //代销的一个供应商一单
        List<ShoppingCart> agentSale = new ArrayList<ShoppingCart>();
        for (ShoppingCart shoppingCart : agentSale) {
            PackageVo packageVo = new PackageVo();
            packageList.add(packageVo);
        }

        return packageList;
    }

    /**
     * 按包裹计算运费
     *
     * @param packageVo
     * @return
     */
    public PackageVo calculateFreight(PackageVo packageVo) {
        //根据运费模板和具体产品重量,体积,个数,收货地址等计算运费
        return packageVo;
    }

    /**
     * 按包裹计算配送方式
     */
    public void calculateDelivoryMethod(PackageVo packageVo) {
        //购销商品-自营仓库,由尖叫设计合作的配送商配送,配送方式必须在配送商的能力范围内
        //购销商品-合作伙伴仓库,由合作伙伴配送
        //代销商品-供应商直送
    }

    /**
     * 计算支付方式
     */
    public PaymentVo calculatePaymentMethod(List<PackageVo> packageList) {
        //也需要参考配送商能支持的支付方式,如果多个子单的配送商都支持货到付款(COD),则该订单可以支持货到付款
        //只要有一家不支持,则不支持COD
        //前期为了简便起见,统一简化为:网上支付-微信
        return null;
    }
}
