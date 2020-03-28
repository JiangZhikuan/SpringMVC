package com.mxixm.spring.boot.chapter02.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectViewController {

    // 访问的目标请求
    @RequestMapping("/redirectView")
    public String redirectView(RedirectAttributes model) {
        // 设置重定向前的模型属性
        model.addFlashAttribute("first", "重定向前属性");
        // 返回重定向视图，转发目标是forwardTargetView
        return "redirect:redirectTargetView";
    }

    // 重定向的目标请求
    @RequestMapping("/redirectTargetView")
    public String redirectTargetView(Model model) {
        // 此时的model已经有了重定向前的属性了
        model.addAttribute("second", "重定向后属性");
        return "viewView";
    }

}
