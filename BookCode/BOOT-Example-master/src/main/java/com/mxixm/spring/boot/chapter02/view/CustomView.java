package com.mxixm.spring.boot.chapter02.view;

import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

// 声明为Bean，BeanName为beanNameViewBean
@Component("beanNameViewBean")
public class CustomView implements View {

    // 返回该View支持text/html类型的ContentType，用于查找到多个View时选择最优匹配结果
    @Override
    public String getContentType() {
        return MediaType.TEXT_HTML_VALUE;
    }
    // 执行视图的渲染操作，第一个参数是处理器逻辑中Model处理逻辑产生的Model模型数据。
    @Override
    public void render(@Nullable Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 从Model中拿到模型参数
        Object name = model.get("name");
        // 返回页面内容
        response.getWriter().append("name is " + name);
    }
}
