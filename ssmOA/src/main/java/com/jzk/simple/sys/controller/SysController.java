package com.jzk.simple.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName:SysController
 * Package:com.jzk.simple.sys.controller
 * Description:
 *
 * @Date:2020/4/24 14:56
 * @Author:JiangZhikuan
 */
@Controller
@RequestMapping("sys")
public class SysController {

    /*
    * 跳转菜单管理
    * */
    @RequestMapping("toMenuManager")
    public String toMenuManager(){
        return "system/main/menuManager";
    }

    /*
    * 跳转菜单管理左边的菜单树界面
    * */
    @RequestMapping("toMenuLeft")
    public String toMenuLeft(){
        return "system/main/menuLeft";
    }

    /*
    * 跳转菜单管理右边菜单列表
    * */
    @RequestMapping("toMenuRight")
    public String toMenuRight(){
        return "system/main/menuRight";
    }
}
