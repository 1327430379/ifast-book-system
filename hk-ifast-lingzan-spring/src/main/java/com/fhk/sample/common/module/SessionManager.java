package com.fhk.sample.common.module;

import com.fhk.sample.common.constants.ExceptionCode;
import com.fhk.sample.domain.entity.User;
import com.fhk.sample.util.BizAssert;
import com.fhk.sample.util.ServletRequestUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author: 凌瓒
 * @Date: 2022/04/17/9:14 上午
 */
public class SessionManager {

    private static final String USER_SESSION_ATTRIBUTE_PARAM = "current_user";

    public static User getCurrentUserSession() {
        HttpServletRequest request = ServletRequestUtil.getHttpServletRequest();
        HttpSession session = request.getSession();
        Object userObj = session.getAttribute(USER_SESSION_ATTRIBUTE_PARAM);
        ExceptionCode code = ExceptionCode.USER_SESSION_FAILURE;
        BizAssert.isNotNull(userObj,code.getCode(),code.getMsg());
        return  (User) userObj;
    }

    public static void saveUserSession(User user) {
        HttpServletRequest request = ServletRequestUtil.getHttpServletRequest();
        HttpSession session = request.getSession();
        session.setAttribute(USER_SESSION_ATTRIBUTE_PARAM,user);
    }

    public static void invalidate() {
        HttpServletRequest request = ServletRequestUtil.getHttpServletRequest();
        HttpSession session = request.getSession();
        session.invalidate();
    }
}
