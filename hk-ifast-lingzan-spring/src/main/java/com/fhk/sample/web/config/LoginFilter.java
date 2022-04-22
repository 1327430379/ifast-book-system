//package com.fhk.sample.web.config;
//
//import com.fhk.sample.common.module.SessionManager;
//import com.fhk.sample.domain.entity.User;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Component
//public class LoginFilter extends OncePerRequestFilter {
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        String auth = request.getHeader("auth");
//        if (!StringUtils.isBlank(auth)) {
//            return;
//        }
//
//       // User user = SessionManager.getCurrentUserSession();
//
//    }
//}
