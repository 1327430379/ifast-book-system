package com.fhk.sample.common.constants;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: 凌瓒
 * @Date: 2022/04/16/11:56 上午
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ExceptionCode {

    SUCCESS("0", "操作成功"),
    INVOKE("-1", "接口调用失败"),
    PARAM_ERROR("-2", "参数错误"),
    PASSWORD_INPUT_ERROR("-3", "密码输入错误"),
    USER_SESSION_FAILURE("-4", "用户会话失效"),
    FAIL("100000", "操作失败"),
    NOT_SUPPORTED("100001", "渠道不支持该接口"),
    VALIDATION_FAIL("1000", "数据验证失败"),
    INVALID_PARAM("2000", "参数不合法"),
    DAO_ERR("60000", " 数据库访问异常"),
    SYSTEM_ERR("100001", "系统异常，请联系管理员");

    private final String code;
    private final String msg;


}
