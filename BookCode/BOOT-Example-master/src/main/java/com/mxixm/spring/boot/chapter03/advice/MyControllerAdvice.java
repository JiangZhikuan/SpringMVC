package com.mxixm.spring.boot.chapter03.advice;


import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;

@Component
// 只对MyControllerAdviceController类型应用增强器
@ControllerAdvice(assignableTypes = MyControllerAdviceController.class)
public class MyControllerAdvice {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Exception e, HandlerMethod handlerMethod) {
        System.out.println(e.getMessage());
        return handlerMethod.toString();
    }

}
