package com.wow.user.controller;

import com.wow.user.model.Area;
import com.wow.user.service.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by zhengzhiqing on 16/7/3.
 */
@RestController
public class AreaTestController {

    private static final Logger logger = LoggerFactory.getLogger(AreaTestController.class);

    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/areas/{areaId}/subareas", method = RequestMethod.GET)
    public List<Area> findNextLevelArea(@PathVariable int areaId) {
        return areaService.findNextLevelArea(areaId);
    }
}
