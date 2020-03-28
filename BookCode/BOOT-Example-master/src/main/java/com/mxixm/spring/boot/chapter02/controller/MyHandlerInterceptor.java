package com.mxixm.spring.boot.chapter02.controller;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 实现HandlerInterceptor接口
public class MyHandlerInterceptor implements HandlerInterceptor {

    /**
     * Handler执行前触发
     * @param request 原始的HTTP请求
     * @param response 原始的HTTP响应
     * @param handler 执行的目标处理器
     * @return 返回true则继续执行，否则中断执行
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Handler执行前触发，执行的Handler是" + handler);
        return true;
    }

    /**
     * Handler执行成功后触发
     * @param request 原始的HTTP请求
     * @param response 原始的HTTP响应
     * @param handler 执行的目标处理器
     * @param modelAndView 处理器的执行结果
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("Handler执行成功后触发，执行的Handler是：" + handler + "，处理结果ModelAndView是：" + modelAndView);
    }

    /**
     * @param request 原始的HTTP请求
     * @param response 原始的HTTP响应
     * @param handler 查找到的目标处理器
     * @param ex 执行过程中发生的异常，没有发生异常则为null
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("Handler执行完成后触发，执行的Handler是：" + handler + "，是否发生了异常：" + (ex != null ? "是" : "否"));
    }
}
