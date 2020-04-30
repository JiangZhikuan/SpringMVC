package com.jzk.simple.sys.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * ClassName:AppListener
 * Package:com.jzk.simple.sys.listener
 * Description:
 *
 * @Date:2020/4/22 12:36
 * @Author:JiangZhikuan
 */
public class AppListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext context=servletContextEvent.getServletContext();
        context.setAttribute("ctx",context.getContextPath());
        System.out.println("----------Servlet容器创建成功 ctx被放到servletContext作用域---------");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
