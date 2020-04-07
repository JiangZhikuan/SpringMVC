package com.jzk.simple.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jzk.simple.model.User;
import com.jzk.simple.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * ClassName:UserController
 * Package:simple.comtroller
 * Description:
 *
 * @Date:2020/3/30 15:25
 * @Author:JiangZhikuan
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @RequestMapping("/getUser")
    public void getUser(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        int id=Integer.parseInt(request.getParameter("id"));
        User user=userService.selectUser(id);
        ObjectMapper mapper=new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(user));
        response.getWriter().close();
    }

}
