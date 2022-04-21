

package com.fhk.sample.common.rest;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lingzan
 */
public class RestResponse<T> {
    public static final String SUCCESS_CODE = "0";
    public static final String SUCCESS_MSG = "success";
    public static final String DEFAULT_ERR_CODE = "100000";
    public static final String DEFAULT_ERR_MSG = "fail";
    private String resultCode;
    private String resultMsg;
    private T data;
    public static final RestResponse<String> SUCCEED = new RestResponse("0", "success");
    public static final RestResponse<String> FAILED = new RestResponse("100000", "fail");
    public static final RestResponse<Void> VOID = new RestResponse((Object)null);
    public static final RestResponse<Boolean> TRUE;
    public static final RestResponse<Boolean> FALSE;

    public RestResponse() {
        this(null);
    }

    public RestResponse(T data) {
        this.resultCode = "0";
        this.resultMsg = "success";
        this.data = data;
    }

    public RestResponse(String resultCode, String resultMessage) {
        this.resultCode = resultCode;
        this.resultMsg = resultMessage;
    }

    public RestResponse(String resultCode, String resultMessage, T data) {
        this.resultCode = resultCode;
        this.resultMsg = resultMessage;
        this.data = data;
    }

    public static  RestResponse<Void> success() {
        return new RestResponse<>();
    }


    public static <T> RestResponse<T> success(T data) {
        return new RestResponse<>(data);
    }
    public static <T> RestResponse<T> fail(String msg) {
        return new RestResponse(DEFAULT_ERR_CODE,msg,null);
    }

    public static <T> RestResponse<T> fail(String code,String msg) {
        return new RestResponse(code,msg,null);
    }

    public static RestResponse<Long> createLong(Long value) {
        return new RestResponse(value);
    }

    public static RestResponse<Short> createShort(Short value) {
        return new RestResponse(value);
    }

    public static RestResponse<Integer> createInteger(Integer value) {
        return new RestResponse(value);
    }

    public static RestResponse<Float> createFloat(Float value) {
        return new RestResponse(value);
    }

    public static RestResponse<Double> createDouble(Double value) {
        return new RestResponse(value);
    }

    public static RestResponse<BigDecimal> createBigDecimal(BigDecimal value) {
        return new RestResponse(value);
    }

    public static RestResponse<Object> createObject(Object obj) {
        return new RestResponse(obj);
    }


    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getResultCode() {
        return this.resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return this.resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap();
        map.put("resultCode", this.resultCode);
        map.put("resultMsg", this.resultMsg);
        map.put("data", this.data);
        return map;
    }

    @Override
    public String toString() {
        return "RestResponse [resultCode=" + this.resultCode + ", resultMsg=" + this.resultMsg + ", data=" + this.data + "]";
    }

    static {
        TRUE = new RestResponse<Boolean>("0", "success", Boolean.TRUE);
        FALSE = new RestResponse<Boolean>("0", "success", Boolean.FALSE);
    }
}
