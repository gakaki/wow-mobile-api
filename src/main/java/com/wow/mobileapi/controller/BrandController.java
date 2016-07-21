package com.wow.mobileapi.controller;

import com.wow.common.request.ApiRequest;
import com.wow.common.response.ApiResponse;
import com.wow.common.util.ErrorCodeUtil;
import com.wow.mobileapi.constant.BizConstant;
import com.wow.page.service.PageConfigService;
import com.wow.page.vo.response.PageBannerResponse;
import com.wow.page.vo.response.PageCategoryResponse;
import com.wow.page.vo.response.PageProductResponse;
import com.wow.product.model.Brand;
import com.wow.product.service.BrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by zhengzhiqing on 16/6/23.
 */
@RestController
public class BrandController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(BrandController.class);

    @Autowired
    private BrandService brandService;

    @RequestMapping(value = "/v1/product/brand/firstletter", method = RequestMethod.GET)
    public ApiResponse getBrandByFirstLetter(ApiRequest apiRequest) {
//        List<Brand> brandList = brandService.getBrandsByFirstLetter(firstLetter);
//        logger.info("brandList:" + brandList);
//        return brandList;
        return null;
    }
}