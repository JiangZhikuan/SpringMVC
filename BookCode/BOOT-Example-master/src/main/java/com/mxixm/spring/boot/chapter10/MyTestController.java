package com.mxixm.spring.boot.chapter10;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyTestController {

    @RequestMapping("test1")
    public String test1() {
        return "";
    }
}
