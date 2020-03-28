package com.mxixm.spring.boot.chapter02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

// 声明为Controller控制器Bean，该Bean中被注解@RequestMapping标记的方法会被RequestMappingHandlerMapping扫描并包装为HandlerMethod
@Controller
public class MyRequestMapping {

    // 映射URL为/myRequestMapping，支持GET类型的请求
    @RequestMapping(path = "/myRequestMapping", method = RequestMethod.GET)
    public String requestMappingGet(String name, Map<String, Object> model) {
        // name参数可以从请求参数中自动获取并绑定，model参数也会自动作为Model模型绑定到参数中
        model.put("name", name);
        // 返回视图名，同上面例子
        return "defaultView";
    }

    @RequestMapping(path = "/myRequestMapping", method = RequestMethod.POST)
    public String requestMappingPost(Map<String, Object> model) {
        // name参数可以从请求参数中自动获取并绑定，model参数也会自动作为Model模型绑定到参数中
        model.put("name", "POST请求");
        // 返回视图名，同上面例子
        return "defaultView";
    }

}