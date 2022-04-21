package com.fhk.sample.web.controller;

import com.fhk.sample.common.constants.ExceptionCode;
import com.fhk.sample.common.exception.BusinessException;
import com.fhk.sample.common.rest.RestResponse;
import com.fhk.sample.util.BeanCopierUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;

/**
 * @Author: 凌瓒
 * @Date: 2022/04/16/11:41 上午
 */
@Slf4j
@ControllerAdvice
public abstract class BaseController {

    public <T> T convert(Object source, Class<T> targetClass) {
        return BeanCopierUtil.copyProperties(source, targetClass);
    }

    @ExceptionHandler(value = BusinessException.class)
    public RestResponse<Void> handleBusinessException(BusinessException ex) {
        log.info("business error :{}", ex.getMessage());
        return new RestResponse<>(ex.getCode(), ex.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public RestResponse<Void> handleException(Exception ex) {
        log.error("系统错误：{}", ex.getMessage(), ex);
        return RestResponse.fail("系统错误");
    }

    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    public RestResponse handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException exception) {
        return RestResponse.fail("参数错误");
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public RestResponse<Void> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        String msg;
        FieldError fieldError = exception.getBindingResult().getFieldError();
        if (fieldError != null) {
            msg = fieldError.getDefaultMessage();
        } else {
            List errors;
            if ((errors = exception.getBindingResult().getAllErrors()).size() > 0) {
                msg = ((ObjectError) errors.get(0)).getDefaultMessage();
            } else {
                msg = "参数错误";
            }
        }

        return RestResponse.fail(ExceptionCode.PARAM_ERROR.getCode(), msg);
    }

    @ExceptionHandler({BindException.class})
    public RestResponse<Void> handleBindException(BindException exception) {
        String msg = exception.getBindingResult().getFieldError().getDefaultMessage();
        return RestResponse.fail(ExceptionCode.PARAM_ERROR.getCode(), msg);
    }

    @ExceptionHandler(DataAccessException.class)
    public RestResponse<Void> handleSQLIntegrityConstraintViolationException(DataAccessException exception) {
        String msg = "数据库处理出错";
        if (exception instanceof DataIntegrityViolationException) {
            log.warn("唯一索引字段数据重复：{}",exception.getMessage(),exception);
             msg = "数据项重复";
        }
        log.warn("数据库处理出错：{}", exception.getMessage(),exception);
        return RestResponse.fail(ExceptionCode.FAIL.getCode(),msg);
    }

}
