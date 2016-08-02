package com.wow.price.job;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.wow.price.model.ProductPrice;
import com.wow.price.service.PriceService;

/**
 * Created by zhengzhiqing on 16/7/30.
 */
public class ProductSerialPriceCalculator {

    private static final Logger logger = LoggerFactory.getLogger(ProductSerialPriceCalculator.class);
    
    @Autowired
    private PriceService priceService;
    
    
    @Scheduled(cron = "0 0 1 * * ?") //每天1点跑一次
    public void adjustProductSerialPrice() {
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	logger.info("开始更新最小价格变更的系列产品"+df.format(new Date()));
    	
    	SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");
    	Date nowDate = new Date();
    	String updateEndTime = dateFormater.format(nowDate);
    	
    	Calendar calendar = Calendar.getInstance();
    	calendar.add(Calendar.DATE, -1); //得到前一天
    	Date date = calendar.getTime();
    	String updateStartTime = dateFormater.format(date);
    	
    	List<ProductPrice> priceChangedProductList = priceService.selectPriceChangedProduct(updateStartTime, updateEndTime);
    	
    	for(ProductPrice productPrice:priceChangedProductList){
    		priceService.updateProductMinPrice(productPrice.getProductId(), productPrice.getSellPrice());
    	}
    	
    	logger.info("结束更新最小价格变更的系列产品"+df.format(new Date())+",更新结果明细："+priceChangedProductList);
    }
}
