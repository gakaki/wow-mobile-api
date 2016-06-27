package com.wow.mobileapi.controller;


import com.wow.attribute.model.Attribute;
import com.wow.attribute.service.AttributeService;
import com.wow.mobileapi.dto.ApiResponse;
import com.wow.mobileapi.util.ValidatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class AttributeController {

    // 在Java类中创建 logger 实例
    private static final Logger logger = LoggerFactory.getLogger(AttributeController.class);

    @Autowired
    private AttributeService attributeService;

    @RequestMapping(value = "/v1.0/attributes", method = RequestMethod.POST)
    public ApiResponse createAttribute(@Validated @RequestBody Attribute newAttribute, BindingResult result) {
        ApiResponse apiResponse = new ApiResponse();
        if (result.hasErrors()) {
            apiResponse.setResCode("1400");
            apiResponse.setResMsg("invalid input parameter");
            Map<String, String> map = ValidatorUtil.getErrors(result);
            apiResponse.setData(map);
        } else {
            logger.info("start to add attribute:" + newAttribute);
            int createdCnt = attributeService.createAttribute(newAttribute);
            apiResponse.setResCode("0");
            apiResponse.setResMsg("success");
            apiResponse.setData(createdCnt);
        }
        return apiResponse;
    }

    @RequestMapping(value = "/v1.0/attributes/{id}", method = RequestMethod.GET)
    public ApiResponse findAttribute(@PathVariable Integer id) {
        logger.info("get attribute, id=" + id);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setResCode("0");
        apiResponse.setResMsg("");
        apiResponse.setData(attributeService.getAttributeById(id));
        return apiResponse;
    }

    @RequestMapping(value = "/v1.0/attributes", method = RequestMethod.GET)
    public ApiResponse findAttributes() {
        logger.info("get all attributes");
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setResCode("0");
        apiResponse.setResMsg("");
        apiResponse.setData(attributeService.getAllAttributes());
        return apiResponse;
    }

    @RequestMapping(value = "/v2.0/attributes/{id}", method = RequestMethod.GET)
    public com.wow.attribute.model.Attribute findAttributeV2(@PathVariable Integer id) {
        logger.info("get attribute, id=" + id);
        return attributeService.getAttributeById(id);
    }

    @RequestMapping(value = "/v1.0/attributes/{id}", method = RequestMethod.PUT)
    public int updateAttribute(@RequestBody Attribute updatedAttribute, @PathVariable Integer id) {
        logger.info("update attribute, id=" + id);
        if (updatedAttribute.getId() == null) {
            updatedAttribute.setId(id);
        }
        return attributeService.updateAttribute(updatedAttribute);
    }

    @RequestMapping(value = "/v1.0/attributes/{id}", method = RequestMethod.DELETE)
    public int deleteAttribute(@PathVariable Integer id) {
        logger.info("delete attribute, id=" + id);
        return attributeService.deleteAttributeById(id);
    }
}