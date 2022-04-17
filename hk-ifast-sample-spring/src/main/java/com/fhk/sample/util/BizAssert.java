package com.fhk.sample.util;

import com.fhk.sample.common.constants.ExceptionCode;
import com.fhk.sample.common.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;

public class BizAssert {

	public static void isTrue(boolean expression, String message) {
		 isTrue(expression, ExceptionCode.FAIL.getCode(), message);
	}
	
	public static void isTrue(boolean expression, String code, String message) {
		if (!expression) {
			throw new BusinessException(code, message);
		}
		
	}

	public static void isNull(Object object, String message) {
		isNull(object, ExceptionCode.FAIL.getCode() , message);
	}

	public static void isNotNull(Object object, String message) {
		isNotNull(object, ExceptionCode.FAIL.getCode() , message);
	}

	public static void isNull(Object object, String code, String message) {
		if (object != null) {
			if(StringUtils.isNoneBlank(code)) {
				throw new BusinessException(code, message);
			} else {
				throw new BusinessException(message);
			}

		}
	}
	public static void isNotNull(Object object, String code, String message) {
		if (object == null) {
			if(StringUtils.isNoneBlank(code)) {
				throw new BusinessException(code, message);
			} else {
				throw new BusinessException(message);
			}

		}
	}
}
