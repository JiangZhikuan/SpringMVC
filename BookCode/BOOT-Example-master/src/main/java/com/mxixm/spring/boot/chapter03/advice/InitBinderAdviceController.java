package com.mxixm.spring.boot.chapter03.advice;

import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

// 定义RESTful控制器，所有处理器方法均按照@ResponseBody返回
@RestController
public class InitBinderAdviceController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // 添加yyyy-MM-dd类型的格式化工具
        binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
    }

    @GetMapping("initBinderAdvice")
    public String initBinderAdvice(Date date) {
        // 通过请求参数date获取时间，也可以使用注解@DateTimeFormat(pattern = "yyyy-MM-dd")而无需添加@InitBinder
        System.out.println(date);
        return date.toString();
    }

}
