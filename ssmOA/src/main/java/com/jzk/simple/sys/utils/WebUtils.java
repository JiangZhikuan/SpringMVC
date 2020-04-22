package com.jzk.simple.sys.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ClassName:WebUtils
 * Package:com.jzk.simple.sys.utils
 * Description:
 *
 * @Date:2020/4/22 13:10
 * @Author:JiangZhikuan
 */
public class WebUtils {
    public static ServletRequestAttributes getServletRequestAttributes(){
        return (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    }

    /*
    * 获取当前线程的请求对象
    * */
    public static HttpServletRequest getHttpServletRequest(){
        return getServletRequestAttributes().getRequest();
    }

    /*
    * 获取当前响应对象
    * */
    public static HttpServletResponse getHttpServletResponse(){
        return getServletRequestAttributes().getResponse();
    }

    /*
    * 得到session对象
    * */
    public static HttpSession getHttpSession(){
        return getHttpServletRequest().getSession();
    }

    /*
    * 获取servletContext对象
    * */
    public static ServletContext getServletContext(){
        return getHttpServletRequest().getServletContext();
    }
    

}
