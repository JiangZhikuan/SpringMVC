package com.mxixm.spring.mvc.controller;

import com.mxixm.spring.mvc.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("/")
    public String index(Model model) {
        String name = demoService.getName(1);
        model.addAttribute("name", name);
        return "index";
    }

}
