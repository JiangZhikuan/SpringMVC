package com.mxixm.spring.boot.chapter02.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.handler.SimpleServletHandlerAdapter;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

import java.util.Collections;

@Configuration
public class HandlerMappingConfig {

    @Bean
    public SimpleServletHandlerAdapter simpleServletHandlerAdapter() {
        return new SimpleServletHandlerAdapter();
    }

    @Bean
    public SimpleUrlHandlerMapping MyHttpRequestHandler() {
        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        // 设置高优先
        mapping.setOrder(Ordered.HIGHEST_PRECEDENCE);
        mapping.setUrlMap(Collections.singletonMap("httpRequestHandler",
                new MyHttpRequestHandler()));
        return mapping;
    }

}
