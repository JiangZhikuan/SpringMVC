package com.mxixm.spring.boot.chapter08.debug;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// 用于调试的启动器，在这里添加的启动器不会查找到其他包中的组件
@SpringBootApplication
@Controller
public class DebuggerStarter {
    // 启动入口，Java原生启动入口
    public static void main(String[] args)  {
        SpringApplication.run(DebuggerStarter.class, args);
    }

    @GetMapping("debugger")
    @ResponseBody
    public String debugger() {
        return "debugger";
    }

}
