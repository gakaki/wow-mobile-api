package com.wow.common.util;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

/**
 * Created by zhengzhiqing on 16/6/27.
 */
public class ValidatorUtil {

    //获取Validator实例
    private static final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    /**
     * 只获取第一个错误
     * @param <T>
     * @param result
     * @return
     */
    public static <T> String getError(T request) {
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(request);

        if (CollectionUtil.isNotEmpty(constraintViolations)) {
            //返回第一个错误信息
            StringBuilder sb = new StringBuilder();

            for (ConstraintViolation<T> constraintViolation : constraintViolations) {
                return sb.append(constraintViolation.getPropertyPath()).append(": ")
                    .append(constraintViolation.getMessage()).toString();
            }
        }

        return "";
    }
}
