package com.mxixm.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import java.lang.reflect.InvocationTargetException;
import java.util.Locale;
import java.util.ResourceBundle;

@SpringBootApplication
public class Starter {
    // 启动入口，Java原生启动入口
    public static void main(String[] args) {
        SpringApplication.run(Starter.class, args);
    }

}
