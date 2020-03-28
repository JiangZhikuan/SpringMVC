package com.mxixm.spring.boot.chapter02.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

// 声明BeanName为/myController，使用BeanNameUrlHandlerMapping注册这个Handler
@Component("/myController")
public class MyController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // model数据支持使用Map类型
        Map<String, Object> model = new HashMap<>(2);
        model.put("name", "Guangshan");
        // 返回视图mycontroller，视图绑定的数据为model
        return new ModelAndView("defaultView", model);
    }
}
