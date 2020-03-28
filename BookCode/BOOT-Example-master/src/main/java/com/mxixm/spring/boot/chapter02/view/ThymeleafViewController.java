package com.mxixm.spring.boot.chapter02.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ThymeleafViewController {

    @RequestMapping("/thymeleafView")
    public String thymeleafView(Model model) {
        // 为Model添加属性
        model.addAttribute("name", "光闪");
        model.addAttribute("sex", 1);
        List<String> hobbies = new ArrayList<>();
        hobbies.add("计算机");
        hobbies.add("数学");
        hobbies.add("游戏");
        // 添加List类型的属性
        model.addAttribute("hobbies", hobbies);
        return "thymeleafView";
    }

}
