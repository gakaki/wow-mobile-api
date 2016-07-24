package com.wow.product.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wow.product.model.Product;
import com.wow.product.model.ProductSerial;
import com.wow.product.service.ProductSerialService;
import com.wow.product.service.ProductService;

/**
 * Created by fangying@wowdsgn on 2016/7/1.
 */
@RestController
public class ProductTestController {
    @Autowired
    private ProductService productService;

    @Autowired
    ProductSerialService productSerialService;

    @RequestMapping(value = "/product/{productId}", method = RequestMethod.GET)
    public Product selectAttributeById(@PathVariable Integer productId) {
        Product product=new Product();
        product.setId(2);
        product.setUpdateTime(new java.util.Date());
        product.setCreateTime(new java.util.Date());
        product.setApprovalTime(new java.util.Date());
        product.setIsDeleted(false);
        product.setAssembleTips("");
        product.setBrandId(0);
        product.setCanSale(false);
        product.setCanShow(false);
        product.setCategoryId(389);
//        product.setColor("黑色");
//        product.setDeliveryFeeType(new Byte((byte) 0));
        product.setHeight((short)1);
        product.setIsBundling(false);
        product.setIsFragile(false);
        product.setIsImport(false);
//        product.setIsPresale(false);
        product.setLength((short)0);
       product.setMaterialText("");
        product.setNeedAssemble(false);
        product.setOnShelfTime(new java.util.Date());
        product.setDetailDescription("");
        product.setOriginCity("");
//        product.setPostSaleServiceDesc("");
        product.setProductModel("");
        product.setProductName("");
        product.setProductStatus((byte)0);
        product.setProductType(new Byte((byte) 0));
        product.setOnShelfTime(new java.util.Date());
//        product.setOriginCountry("");
        product.setRejectReason("");
        product.setSellingPoint("");
        product.setSeoDesc("");
        product.setSeoKey("");
        product.setSizeText("");
//        product.setSpec("");
        product.setSeoTitle("");
//        product.setSpecImg("");
//        product.setStyle("");
        product.setTips("");
        product.setVerboseInfo("");
        product.setViewPlatform(new Byte((byte) 0));
        product.setWeight( new BigDecimal(1));
        product.setWeightText("");
        product.setWidth((short)1);
        productService.updateProduct(product);
        return null;
    }

    @RequestMapping(value = "/productSerial",method = RequestMethod.GET)
     public ProductSerial selectProductSerial()
    {
        List<ProductSerial> productSerials=new ArrayList<>();
//        ProductSerial productSerial=new ProductSerial();
//        productSerial.setCreateTime(new java.util.Date());
//        productSerial.setUpdateTime(new java.util.Date());
//        productSerial.setCreateBy("fangy");
//        productSerial.setIsDeleted(false);
//        productSerial.setIsPrimary(true);
//        productSerial.setProductId(1);
//        productSerial.setSubProductId(2);
//        productSerial.setUpdateBy("");
//        productSerials.add(productSerial);
        ProductSerial productSerial1=new ProductSerial();
        productSerial1.setCreateTime(new java.util.Date());
        productSerial1.setUpdateTime(new java.util.Date());
        productSerial1.setCreateBy("fangy1");
        productSerial1.setId(2);
        productSerial1.setIsDeleted(false);
        productSerial1.setIsPrimary(false);
        productSerial1.setProductId(2);
        productSerial1.setSubProductId(-1);
        productSerial1.setUpdateBy("");
        productSerials.add(productSerial1);
        productSerialService.deleteProductSerial(1);
       return null;
    }
}
