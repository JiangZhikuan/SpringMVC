package com.mxixm.spring.boot.chapter03.mapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ParamMappingController {

    @RequestMapping("myForm")
    public String myForm() {
        return "myFormView";
    }

    @RequestMapping(path = "myFormSubmit", params = {"agreed=true"})
    public String myFormAgreedSubmit(String firstName, String lastName, Model model) {
        model.addAttribute("fullName", firstName  + "." + lastName);
        return "myFormAgreedView";
    }

    @RequestMapping(path = "myFormSubmit", params = {"agreed!=true"})
    public String myFormNoAgreeSubmit() {
        return "myFormNotAgreeView";
    }

}
