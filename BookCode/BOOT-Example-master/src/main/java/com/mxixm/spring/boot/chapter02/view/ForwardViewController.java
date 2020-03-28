package com.mxixm.spring.boot.chapter02.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ForwardViewController {

    // 访问的目标请求
    @RequestMapping("/forwardView")
    public String forwardView(Model model) {
        // 设置转发前的模型属性
        model.addAttribute("info", "转发前属性");
        // 返回转发视图，转发目标是forwardTargetView
        return "forward:forwardTargetView";
    }

    // 转发的目标请求
    @RequestMapping("/forwardTargetView")
    public String forwardTargetView(HttpServletRequest request, Model model) {
        // 注入HttpServletRequest类型的参数，拿到原始的request
        // 通过request.getAttribute获取请求属性，拿到转发前模型中的属性
        Object first = request.getAttribute("info");
        // 设置模型属性
        model.addAttribute("first", first);
        model.addAttribute("second", "转发后属性");
        return "viewView";
    }

}
