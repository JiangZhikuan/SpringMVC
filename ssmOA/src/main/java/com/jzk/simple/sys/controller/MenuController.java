package com.jzk.simple.sys.controller;

import com.jzk.simple.sys.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * ClassName:MenuController
 * Package:com.jzk.simple.sys.controller
 * Description:
 *
 * @Date:2020/4/24 13:13
 * @Author:JiangZhikuan
 */
@Controller
@RequestMapping("login")
public class MenuController {

    @Autowired
    private SysMenuService sysMenuService;

    @ResponseBody
    @GetMapping("menu")
    public Map<String,Object> menu(){
        return sysMenuService.menu();
    }
}
