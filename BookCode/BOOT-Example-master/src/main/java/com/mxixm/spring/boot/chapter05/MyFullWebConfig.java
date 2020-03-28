package com.mxixm.spring.boot.chapter05;

import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class MyFullWebConfig implements WebMvcConfigurer {

    /**
     * 配置异步请求支持的相关参数与组件
     * @param configurer 异步支持配置器
     */
    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        // 设置默认异步超时时间为30秒
        configurer.setDefaultTimeout(30 * 1000);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 添加重定向视图控制器，对于/路径的请求，重定向到/user下
        registry.addRedirectViewController("/","/user");
        // 添加视图控制器，对于/user/**模式的请求，直接使用视图/assets/index.html进行响应。
        registry.addViewController("/user/**").setViewName("/assets/index.html");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 添加静态资源处理器，对于/static/**路径模式的请求，在classpath下的assets文件夹中查找对应的静态资源并返回
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/assets/")
                .setCachePeriod(24 * 60 * 60);  // 在浏览器中缓存24小时
    }
}