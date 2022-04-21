package com.fhk.sample.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author: 凌瓒
 * @Date: 2022/04/17/9:45 下午
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(userLoginInterceptor()).addPathPatterns("/**");
//    }
//
//    @Bean
//    @Primary
//    public LoginInterceptor userLoginInterceptor() {
//        return new LoginInterceptor();
//    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/app/std/**");
    }
}
