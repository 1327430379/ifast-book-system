

package com.fhk.sample.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fhk.sample.common.exception.BusinessException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class JacksonUtil {
    public static ObjectMapper objectMapper = new ObjectMapper();

    public JacksonUtil() {
    }

    public static <T> T readValue(String jsonStr, Class<T> valueType) {
        try {
            return objectMapper.readValue(jsonStr, valueType);
        } catch (Exception var3) {
            throw new BusinessException("JacksonUtil.readValue(String,Class<T>)执行异常", var3);
        }
    }

    public static <T> T readValue(String jsonStr, TypeReference<T> valueTypeRef) {
        try {
            return objectMapper.readValue(jsonStr, valueTypeRef);
        } catch (Exception var3) {
            throw new BusinessException("JacksonUtil.readValue(String,TypeReference<T>)执行异常", var3);
        }
    }

    public static <T> T readValue(String jsonStr, Class<?> parametrized, Class<?>... parameterClasses) {
        JavaType type = objectMapper.getTypeFactory().constructParametricType(parametrized, parameterClasses);

        try {
            return objectMapper.readValue(jsonStr, type);
        } catch (IOException var5) {
            throw new BusinessException("JacksonUtil.readValue(String,Class<?>,Class...)执行异常", var5);
        }
    }


    public static String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception var2) {
            throw new BusinessException("JacksonUtil.toJSon执行异常", var2);
        }
    }

    public static Map<String, Object> toMap(String jsonStr) {
        try {
            return (Map)objectMapper.readValue(jsonStr, new TypeReference<HashMap<String, Object>>() {
            });
        } catch (Exception var2) {
            throw new BusinessException("JacksonUtil.toMap(String)执行异常", var2);
        }
    }

    static {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
}
