package com.wow.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * Created by zhengzhiqing on 16/6/27.
 */
public class ValidatorUtil {

    private static final Logger logger = LoggerFactory.getLogger(ValidatorUtil.class);

    /**
     * 只获取第一个错误
     * @param result
     * @return
     */
    public static String getError(BindingResult result) {
        FieldError fieldError = result.getFieldError();
        return fieldError.getField() + ":" +  fieldError.getDefaultMessage();
    }
}
