package com.wow.mobileapi.controller;


import com.wow.attribute.model.Attribute;
import com.wow.attribute.service.AttributeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/attributes")
public class AttributeController {

    // 在Java类中创建 logger 实例
    private static final Logger logger = LoggerFactory.getLogger(AttributeController.class);

    @Autowired
    private AttributeService attributeService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public com.wow.attribute.model.Attribute findAttribute(@PathVariable Integer id) {
        logger.info("get attribute, id=" + id);
        return attributeService.getAttributeById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public com.wow.attribute.model.Attribute updateAttribute(@RequestBody Attribute updatedAttribute,
                                                             @PathVariable Integer id) {
        logger.info("update attribute, id=" + id);
        Attribute attribute = attributeService.getAttributeById(id);
        attribute.setAttributeName(updatedAttribute.getAttributeName());
        attribute.setShowName(updatedAttribute.getShowName());
        attribute.setCreateTime(new Date());
        attribute.setUpdateTime(new Date());
        int updateCnt = attributeService.updateAttribute(attribute);
        logger.info("update count=" + updateCnt);
        return attributeService.getAttributeById(id);
    }
}