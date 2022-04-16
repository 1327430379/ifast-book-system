package com.fhk.sample.web.controller;

import com.fhk.sample.common.exception.BusinessException;
import com.fhk.sample.common.rest.RestResponse;
import com.fhk.sample.util.BeanCopierUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Author: 凌瓒
 * @Date: 2022/04/16/11:41 上午
 */
@Slf4j
@RestControllerAdvice
public abstract class BaseController {

    public <T> T convert(Object source, Class<T> targetClass) {
        return BeanCopierUtil.copyProperties(source, targetClass);
    }

    @ExceptionHandler(value = BusinessException.class)
    public RestResponse handleBusinessException(BusinessException ex) {
        return new RestResponse(ex.getCode(), ex.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public RestResponse handleException(Exception ex) {
        log.info("系统错误：{}", ex.getMessage(), ex);
        return RestResponse.FAILED;
    }
}
