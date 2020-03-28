package com.mxixm.spring.boot.chapter03.advice;

import com.mxixm.spring.boot.chapter03.entity.MyData;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import java.io.IOException;
import java.lang.reflect.Type;

// 定义为控制器增强器
@ControllerAdvice
// 定义一个Bean，接口RequestBodyAdvice可用类RequestBodyAdviceAdapter代替
@Component
public class MyRequestBodyAdvice implements RequestBodyAdvice {

    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        // 只支持MyData类型增强
        return methodParameter.getParameterType() == MyData.class;
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
        return inputMessage;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        // 根据firstName与lastName设置fullName属性
        MyData myData = (MyData) body;
        // 可以在@RequestBody中获取fullName属性
        myData.setFullName(myData.getFirstName() + myData.getLastName());
        return myData;
    }

    @Nullable
    @Override
    public Object handleEmptyBody(@Nullable Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return null;
    }

}
