package com.jzk.simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName:HomeController
 * Package:simple.comtroller
 * Description:
 *
 * @Date:2020/3/28 16:10
 * @Author:JZK
 */

@Controller
@RequestMapping("/home")
public class HomeController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
