package com.mxixm.spring.boot.chapter02.model;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@SessionAttributes("name")
public class MyModelBinding {

    @RequestMapping(path = "/mapModel")
    public String mapModelBinding(Map<String, Object> map) {
        // 声明Map类型，此时传入的参数是ExtendedModelMap的实例，操作时使用Map接口的方法
        map.put("name", "Map类型的Model");
        return "defaultView";
    }

    @RequestMapping(path = "/modelModel")
    public String modelModelBinding(Model model) {
        // 声明Model类型，使用Model的接口方法操作数据
        model.addAttribute("name", "Model类型的Model");
        return "defaultView";
    }

    @RequestMapping(path = "/modelMapModel")
    public String modelMapModelBinding(ModelMap modelMap) {
        // 绑定ModelMap类型，使用两种方式添加属性
        modelMap.addAttribute("name", "ModelMap类型的Model");
        modelMap.put("date", new Date());
        return "defaultView";
    }

    @RequestMapping(path = "/defaultView")
    public Map createModel() {
        Map<String, Object> model = new HashMap<>(2);
        // 这里也可以创建ModelMap类型或者ExtendModelMap类型，都是可以的。
        // ModelMap model = new ModelMap();
        model.put("name", "自行创建Model");
        return model;
    }

    @RequestMapping(path = "/modelAndViewModel")
    public ModelAndView modelAndViewModelBinding() {
        Map<String, Object> model = new HashMap<>(2);
        model.put("name", "ModelAndView类型");
        // 返回ModelAndView，第一个参数是视图名，第二个参数是模型。
        return new ModelAndView("defaultView", model);
    }

}
