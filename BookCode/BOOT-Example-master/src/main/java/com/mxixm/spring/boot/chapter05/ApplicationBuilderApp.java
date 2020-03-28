package com.mxixm.spring.boot.chapter05;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class ApplicationBuilderApp {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>(2);
        map.put("mykey", "myvalue");
        SpringApplicationBuilder builder = new SpringApplicationBuilder();
        builder.sources(ApplicationBuilderApp.class)   // 指定配置源类
                .properties(map)                        // 指定默认属性，属性源之一
                .build()                                // 构建SpringApplication
                .run(args);                             // 执行，传入命令行参数
    }

}
