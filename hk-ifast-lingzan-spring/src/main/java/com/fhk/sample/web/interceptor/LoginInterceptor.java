package com.fhk.sample.web.interceptor;

import com.fhk.sample.common.module.SessionManager;
import com.fhk.sample.domain.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author: 凌瓒
 * @Date: 2022/04/17/9:43 下午
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    private static final int NOT_LOGIN_IN = 401;
    private static final String COMMON_AUTH = "888";

    private final List<String> whiteList = new ArrayList<>();

    @PostConstruct
    public void init() {
        whiteList.add("/user/register");
        whiteList.add("/user/login");
        whiteList.add("/user/current/user");
        whiteList.add("/book/read");
        whiteList.add("/shelf/readNew");
        whiteList.add("/shelf/read");
        whiteList.add("/main");

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI().replace(request.getContextPath(), "");
        if (whiteList.contains(uri)) {
            return true;
        }
        //这里为userId+username
        String auth = request.getHeader("auth");
        if (StringUtils.isBlank(auth)) {
            log.warn("缺少请求头");
            return false;
        }
        if (COMMON_AUTH.equals(auth)) {
            return true;
        }
        User currentUser = SessionManager.getCurrentUserSession();
        if (Objects.nonNull(currentUser)) {
            String token = String.format("%s_%s", currentUser.getId(), currentUser.getUsername());
            log.info("auth:{},token:{}",auth,token);
            return auth.equals(token);
        }
        log.info("此用户未在浏览器登录");
        response.setStatus(NOT_LOGIN_IN);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }


}
