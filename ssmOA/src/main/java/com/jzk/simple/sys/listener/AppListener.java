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
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
