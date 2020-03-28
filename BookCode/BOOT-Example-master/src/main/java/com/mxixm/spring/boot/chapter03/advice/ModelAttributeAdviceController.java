package com.mxixm.spring.boot.chapter03.advice;

import com.mxixm.spring.boot.chapter03.entity.MyData;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Date;

@Controller
public class ModelAttributeAdviceController {

    // 定义模型属性方法，把返回值添加到Model中，属性名为data
    @ModelAttribute("data")
    public MyData myData() {
        MyData myData = new MyData();
        myData.setFirstName("Guang");
        myData.setLastName("shan");
        return myData;
    }

    // 模型中存在模型方法定义的属性，可直接使用
    @GetMapping("modelAttributeAdvice1")
    public String modelAttributeAdvice1() {
        return "myModelAttributeReturn";
    }

    @GetMapping("modelAttributeAdvice2")
    public String modelAttributeAdvice1(@ModelAttribute("data") MyData myData) {
        // 通过@ModelAttribute标记的参数可以正常引入模型属性方法定义的模型属性
        System.out.println(myData);
        return "myModelAttributeReturn";
    }

}
