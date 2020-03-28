package com.mxixm.spring.boot.chapter03.argument;

import com.mxixm.spring.boot.chapter03.entity.MyData;
import com.mxixm.spring.boot.chapter03.entity.PersonData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("from")
public class ModelAttributeResolveController {

    @RequestMapping("modelAttribute/{name}")
    public String modelAttribute(@ModelAttribute PersonData data) {
        return "defaultView";
    }

    @GetMapping("sessionAttributesFrom")
    public String sessionAttributes(Model model) {
        MyData myData = new MyData();
        myData.setFirstName("Guang");
        myData.setLastName("shan");
        // 设置model中from属性值，因为存在@SessionAttributes("from")，随后该值会被设置到Session中
        model.addAttribute("from", myData);
        return "defaultView";
    }

    @GetMapping("sessionAttributes")
    public String sessionAttributes(@ModelAttribute("from") MyData myData, SessionStatus sessionStatus) {
        // 可以取到sessionAttributesFrom请求中设置的from的值
        System.out.println(myData);
        // 标记完成，清除session中的值
        sessionStatus.setComplete();
        return "defaultView";
    }

}
