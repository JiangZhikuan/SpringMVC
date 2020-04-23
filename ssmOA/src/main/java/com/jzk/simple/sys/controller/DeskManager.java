package com.jzk.simple.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName:DeskManager
 * Package:com.jzk.simple.sys.controller
 * Description:
 *              工作台
 * @Date:2020/4/23 22:13
 * @Author:JZK
 */
@Controller
@RequestMapping("desk")
public class DeskManager {

    @RequestMapping("toDeskManager")
    public String toDeskManager(){
        return "system/main/deskManager";
    }
}
