package com.wow.mobileapi.controller;

/**
 * Created by zhengzhiqing on 16/6/18.
 */

import com.wow.product.model.Brand;
import com.wow.product.model.Product;
import com.wow.product.service.BrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private BrandService brandService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product findProduct(@PathVariable Integer id) {
        Product product = new Product();
        product.setId(id);
        product.setProductName("product-" + id);
        return product;
    }

    @RequestMapping(value = "/brand/{firstLetter}", method = RequestMethod.GET)
    public List<Brand> findBrandById(@PathVariable String firstLetter) {
        logger.info("firstLetter is:" + firstLetter);
        List<Brand> brandList = brandService.getBrandsByFirstLetter(firstLetter);
        logger.info("brandList:" + brandList);
        return brandList;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> findProducts() {
        Product product = new Product();
        product.setId(1);
        product.setProductName("testproduct");
        List<Product> productList = new ArrayList<Product>();
        productList.add(product);
        return productList;
    }
}