package com.jzk.simple.sys.controller;

import com.jzk.simple.sys.constast.SysConstast;
import com.jzk.simple.sys.domain.SysUser;
import com.jzk.simple.sys.service.LogInfoService;
import com.jzk.simple.sys.service.SysUserService;
import com.jzk.simple.sys.utils.WebUtils;
import com.jzk.simple.sys.vo.SysLogLoginVo;
import com.jzk.simple.sys.vo.SysUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * ClassName:LoginController
 * Package:com.jzk.simple.sys.controller
 * Description:
 *             Controller登录功能控制器
 * @Date:2020/4/22 22:01
 * @Author:JZK
 */
@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private LogInfoService logInfoService;

    /*
    * 登录方法
    * */
    @RequestMapping("login")
    public String login(SysUserVo sysUserVo, Model model){
        //获取验证码
        String kaptchaExpected = (String)WebUtils.getHttpSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
        String kaptchaReceived = sysUserVo.getIdentity();
        if (kaptchaReceived == null || !kaptchaReceived.equalsIgnoreCase(kaptchaExpected))
        {
            model.addAttribute("error", SysConstast.VERIFICATION_CODE_MSG);
            return "system/main/login";
        }

        SysUser sysUser=this.sysUserService.login(sysUserVo);
        if(null!=sysUser){
            WebUtils.getHttpSession().setAttribute("user",sysUser);
            SysLogLoginVo logLoginVo=new SysLogLoginVo();
            logLoginVo.setLogintime(new Date());
            logLoginVo.setLoginname(sysUser.getRealname()+"_"+sysUser.getLoginname());
            logLoginVo.setLoginip(WebUtils.getHttpServletRequest().getRemoteAddr());
            logInfoService.addLogInfo(logLoginVo);
            return "system/main/index";
        }else {
            model.addAttribute("error", SysConstast.USER_LOGIN_ERROR_MSG);
            return "system/main/login";
        }
    }

}
