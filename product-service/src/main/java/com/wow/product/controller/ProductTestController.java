package com.wow.product.controller;

import com.wow.product.model.Product;
import com.wow.product.service.ProductService;
import org.hibernate.validator.cfg.defs.DecimalMaxDef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * Created by fangying@wowdsgn on 2016/7/1.
 */
@RestController
public class ProductTestController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/product/{productId}", method = RequestMethod.GET)
    public Product selectAttributeById(@PathVariable Integer productId) {
        Product product=new Product();
        product.setId(2);
        product.setUpdateTime(new java.util.Date());
        product.setCreateTime(new java.util.Date());
        product.setApplicableScene("");
        product.setApprovalTime(new java.util.Date());
        product.setIsDeleted(false);
        product.setAssembleTips("");
        product.setBrandId(0);
        product.setCanSale(false);
        product.setCanShow(false);
        product.setCategoryId(389);
        product.setColor("黑色");
        product.setDeliveryFeeType(new Byte((byte) 0));
        product.setHeight((short)1);
        product.setIsBundling(false);
        product.setIsFragile(false);
        product.setIsImport(false);
        product.setIsPresale(false);
        product.setLength((short)0);
       product.setMaterial("");
        product.setNeedAssemble(false);
        product.setOnShelfTime(new java.util.Date());
        product.setDetailDescription("");
        product.setOriginAreaId(1);
        product.setOriginText("");
        product.setPostSaleServiceDesc("");
        product.setProductModel("");
        product.setProductName("");
        product.setProductStatus((short)0);
        product.setProductType(new Byte((byte) 0));
        product.setOnShelfTime(new java.util.Date());
        product.setOriginCountry("");
        product.setRejectReason("");
        product.setSellingPoint("");
        product.setSeoDesc("");
        product.setSeoKey("");
        product.setSizeText("");
        product.setSpec("");
        product.setSeoTitle("");
        product.setSpecImg("");
        product.setStyle("");
        product.setTips("");
        product.setVerboseInfo("");
        product.setViewPlatform(new Byte((byte) 0));
        product.setWeight( new BigDecimal(1));
        product.setWeightText("");
        product.setWidth((short)1);
        productService.updateProduct(product);
        return null;
    }
}
