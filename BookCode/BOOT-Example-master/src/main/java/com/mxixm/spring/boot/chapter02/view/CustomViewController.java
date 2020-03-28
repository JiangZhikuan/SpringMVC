package com.mxixm.spring.boot.chapter02.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

@Controller
public class CustomViewController {

    @RequestMapping("/beanNameView")
    public String beanNameView(Model model) {
        // 添加一个Model属性
        model.addAttribute("name", "beanNameView");
        // 返回ViewName，用于查找
        return "beanNameViewBean";
    }

    @RequestMapping("/returnView")
    public View returnView(Model model) {
        // 添加一个Model属性
        model.addAttribute("name", "returnView");
        // 直接返回View类型
        return new CustomView();
    }

}
