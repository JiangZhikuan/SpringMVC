package com.mxixm.spring.boot.chapter06;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 用于调试模式的控制器
@Controller
public class DebugController {

    @GetMapping("/debug")
    public String debug() {
        return "debugView";
    }

}
