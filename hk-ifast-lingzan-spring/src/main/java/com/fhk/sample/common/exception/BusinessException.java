package com.fhk.sample.common.exception;

import com.fhk.sample.common.rest.RestResponse;
import com.fhk.sample.util.JacksonUtil;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: 凌瓒
 * @Date: 2022/04/16/11:49 上午
 */
public class BusinessException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    protected static Map<String, String> mapMessage = new ConcurrentHashMap();
    public static final String SYSTEM_INTERNAL_ERROR = "10001";
    public static final String PARAMETER_ERROR = "10002";
    public static final String RECORD_DUPLICATED = "11001";
    public static final String RECORD_NOT_EXIST = "11002";
    public static final String API_GATEWAY_ERROR = "99999";
    protected String code;
    protected String rawMessage;

    public BusinessException(String message) {
        this("10001", message);
    }

    public BusinessException(String message, Throwable e) {
        this("10001", message, e);
    }

    public BusinessException(String code, String message) {
        super("{\"code\":\"" + code + "\", \"message\":\"" + message + "\"}");
        this.code = null;
        this.rawMessage = null;
        this.code = code;
        this.rawMessage = message;
    }

    public BusinessException(String code, String message, Throwable e) {
        super("{\"code\":\"" + code + "\", \"message\":\"" + message + "\"}", e);
        this.code = null;
        this.rawMessage = null;
        this.code = code;
        this.rawMessage = message;
    }

    public String getCode() {
        return this.code;
    }

    public String getRawMessage() {
        return this.rawMessage;
    }

    public String toRestResponseJson() {
        return JacksonUtil.toJson(new RestResponse(this.code, this.rawMessage));
    }

    public static String getMessage(int code) {
        return (String)mapMessage.get(String.valueOf(code));
    }

    static {
        mapMessage.put("10001", "系统内部错误");
        mapMessage.put("10002", "业务参数异常");
        mapMessage.put("11001", "记录重复");
        mapMessage.put("11002", "记录不存在");
    }

}
