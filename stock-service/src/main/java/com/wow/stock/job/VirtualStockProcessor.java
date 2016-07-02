package com.wow.stock.job;

/**
 * Created by zhengzhiqing on 16/7/2.
 */

import com.wow.stock.model.ProductVirtualStock;
import com.wow.stock.service.StockService;
import com.wow.stock.vo.OrderWithVirtualStockProcessResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class VirtualStockProcessor {

    private static final Logger logger = LoggerFactory.getLogger(VirtualStockProcessor.class);

    @Autowired
    StockService stockService;
    /**
     * 处理因为虚拟库存而pending的订单
     */
    @Scheduled(fixedRate = 5000) //only for testing
//    @Scheduled(cron = "0 0 0 * * ?") //每天0点跑一次
    public List<OrderWithVirtualStockProcessResult> processOrderPendingOnVirtualStock() {
        List<OrderWithVirtualStockProcessResult> orderWithVirtualStockProcessResults =
                new ArrayList<OrderWithVirtualStockProcessResult>();
        //要注意防并发,如果有两个实例,需要一种锁算法
        logger.info("开始处理因为虚拟库存而等待的订单");

        List<ProductVirtualStock> productVirtualStockList
                = stockService.selectAllProductsWithFrozenVirtualStock();
        logger.info("有虚拟冻结的产品个数:" + productVirtualStockList.size());
        for (ProductVirtualStock productVirtualStock: productVirtualStockList) {
            orderWithVirtualStockProcessResults.add(
                    processProductWithFrozenVirtualStock(productVirtualStock));
        }

        logger.info("处理结束,本次处理结果明细" + orderWithVirtualStockProcessResults);
        //异步发个邮件给到干系人
        //sendMain();
        return orderWithVirtualStockProcessResults;
    }

    /**
     * 处理单个产品
     * @param productVirtualStock
     * @return
     */
    private OrderWithVirtualStockProcessResult processProductWithFrozenVirtualStock(
            ProductVirtualStock productVirtualStock) {
        OrderWithVirtualStockProcessResult orderWithVirtualStockProcessResult
                = new OrderWithVirtualStockProcessResult();
        //TODO:
        //查找产品在各仓库的可用库存数量,如果有一个仓库有足够库存 > 虚拟冻结
        //则将虚拟冻结的数量冻结到该仓库,同时,将虚拟冻结调减相应个数(同时也调减虚拟库存数量)
        //如果多个仓库都没有足够库存,则可用的都冻结上,记住数量,同时解冻虚拟冻结库存
        //如果总数能满足,但没有任一个仓库能单独满足,则挑选最少的仓库满足
        //至此,虚拟冻结转真实冻结已经完成
        //接下来,找到虚拟冻结的订单项,修改真实冻结和虚拟冻结的数量
        //TODO: 如果一个产品有部分是实际库存有部分是虚拟库存,则订单项里记录的仓库信息可能会发生变化
        return orderWithVirtualStockProcessResult;
    }
}