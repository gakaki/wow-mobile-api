package com.wow.mobileapi.controller;


import com.wow.attribute.model.Attribute;
import com.wow.attribute.service.AttributeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping
public class AttributeController {

    // 在Java类中创建 logger 实例
    private static final Logger logger = LoggerFactory.getLogger(AttributeController.class);

    @Autowired
    private AttributeService attributeService;

    @RequestMapping(value = "/v1.0/attributes", method = RequestMethod.POST)
//    @Deprecated
    public int createAttribute(@RequestBody Attribute newAttribute) {
        logger.info("start to add attribute");
        return attributeService.createAttribute(newAttribute);
    }

    @RequestMapping(value = "/v1.0/attributes/{id}", method = RequestMethod.GET)
    public com.wow.attribute.model.Attribute findAttribute(@PathVariable Integer id) {
        logger.info("get attribute, id=" + id);
        return attributeService.getAttributeById(id);
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