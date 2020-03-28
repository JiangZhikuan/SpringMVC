package com.mxixm.spring.boot.chapter03.advice;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyControllerAdviceController {

    @GetMapping("myControllerAdvice")
    public String exceptionHandler() throws Exception {
        System.out.println("Throw Exception");
        throw new Exception("Test ControllerAdvice");
    }

}
