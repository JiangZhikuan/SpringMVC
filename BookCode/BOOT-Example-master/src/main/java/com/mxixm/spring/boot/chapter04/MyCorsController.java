package com.mxixm.spring.boot.chapter04;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class MyCorsController {

    // 只允许Origin是https://www.baidu.com的跨域请求
    @CrossOrigin(origins = "https://www.baidu.com")
    @GetMapping("myCors")
    public String myCors() {
        return "CORS TEST";
    }

    @CrossOrigin(origins = "https://www.baidu.com", allowCredentials = "true",
            allowedHeaders = {"X-Custom-Header", "X-Other-Header"})
    @PutMapping("myComplexCors")
    public String myComplexCors() {
        return "CORS TEST";
    }

}
