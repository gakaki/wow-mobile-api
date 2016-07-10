package com.wow.mobileapi.controller;

/**
 * Created by zhengzhiqing on 16/6/18.
 */

import com.wow.common.error.ErrorRepositoryManager;
import com.wow.mobileapi.dto.ApiResponse;
import com.wow.mobileapi.util.ResponseUtil;
import com.wow.product.model.Brand;
import com.wow.product.model.Product;
import com.wow.product.service.BrandService;
import com.wow.product.service.ProductService;
import com.wow.stock.model.ProductVirtualStock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/products")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private BrandService brandService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ErrorRepositoryManager errorRepositoryManager;

    @RequestMapping(value = "/{productId}", method = RequestMethod.GET)
    public ApiResponse getProduct(@PathVariable Integer productId) {
        ApiResponse apiResponse = new ApiResponse();
        Product product = productService.getProductById(productId);
        if (product != null) {
            apiResponse.setResCode("0");
            apiResponse.setResMsg("Success");
            apiResponse.setData(product);
        } else {
            apiResponse.setResCode("40201");
            apiResponse.setResMsg(errorRepositoryManager.getErrorMsg("40201"));
        }
        return apiResponse;
    }

    @RequestMapping(value = "/brand/{firstLetter}", method = RequestMethod.GET)
    public List<Brand> getBrandById(@PathVariable String firstLetter) {
        logger.info("firstLetter is:" + firstLetter);
        List<Brand> brandList = brandService.getBrandsByFirstLetter(firstLetter);
        logger.info("brandList:" + brandList);
        return brandList;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> getProducts() {
        Product product = new Product();
        product.setId(1);
        product.setProductName("testproduct");
        List<Product> productList = new ArrayList<Product>();

        productList.add(product);
        return productList;
    }
}