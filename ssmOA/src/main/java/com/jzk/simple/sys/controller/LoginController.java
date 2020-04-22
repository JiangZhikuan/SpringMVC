package com.jzk.simple.sys.controller;

import com.jzk.simple.sys.constast.SysConstast;
import com.jzk.simple.sys.domain.SysUser;
import com.jzk.simple.sys.service.SysUserService;
import com.jzk.simple.sys.utils.WebUtils;
import com.jzk.simple.sys.vo.SysUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName:LoginController
 * Package:com.jzk.simple.sys.controller
 * Description:
 *
 * @Date:2020/4/22 22:01
 * @Author:JZK
 */
@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    private SysUserService sysUserService;

    /*
    * 跳转登录界面
    * */
    @RequestMapping("toLogin")
    public String toLogin(){
        return "system/main/login";
    }

    /*
    * 登录方法
    * */
    @RequestMapping("login")
    public String login(SysUserVo sysUserVo, Model model){
        SysUser sysUser=this.sysUserService.login(sysUserVo);
        if(null!=sysUser){
            WebUtils.getHttpSession().setAttribute("user",sysUser);
            return "system/main/index";
        }else {
            model.addAttribute("error", SysConstast.USER_LOGIN_ERROR_MSG);
            return "system/main/login";
        }
    }

}
