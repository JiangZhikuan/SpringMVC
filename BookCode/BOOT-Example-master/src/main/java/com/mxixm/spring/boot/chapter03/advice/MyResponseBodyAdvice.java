package com.mxixm.spring.boot.chapter03.advice;

import com.mxixm.spring.boot.chapter03.entity.MyData;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.io.IOException;
import java.lang.reflect.Type;

// 定义为控制器增强器
@ControllerAdvice
// 定义一个Bean
@Component
public class MyResponseBodyAdvice implements ResponseBodyAdvice<MyData> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return returnType.getParameterType() == MyData.class;
    }

    @Nullable
    @Override
    public MyData beforeBodyWrite(@Nullable MyData body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        // 根据firstName与lastName设置fullName属性，把fullName返回到响应体中
        body.setFullName(body.getFirstName() + body.getLastName());
        return body;
    }
}
