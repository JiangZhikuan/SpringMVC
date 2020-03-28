package com.mxixm.spring.boot.chapter03.mapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping
public class MethodMappingController {

    @RequestMapping(path = "path1", method = RequestMethod.GET)
    public String path1() {
        return "index";
    }

    @RequestMapping(path = "path1", method = RequestMethod.POST)
    public String path2() {
        return "index";
    }

}