package com.mxixm.spring.boot.chapter03.mapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"type-1", "type-2"})
public class PathMappingController {

    @RequestMapping({"method-1", "method-2"})
    public String index() {
        return "index";
    }

}