package com.jzk.simple.sys.controller;

import com.jzk.simple.sys.domain.SysMenu;
import com.jzk.simple.sys.service.SysMenuService;
import com.jzk.simple.sys.utils.DataGridView;
import com.jzk.simple.sys.vo.MenuVo;
import com.jzk.simple.sys.vo.SysMenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
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

    /*
    * 加载菜单管理树
    * */
    @ResponseBody
    @RequestMapping("loadMenuManagerLeftTreeJson")
    public DataGridView loadMenuManagerLeftTreeJson(){
        List<SysMenu> menus=sysMenuService.findAllMenu();
        List<MenuVo> nodes=new ArrayList<>();
        if (menus!=null){
            for (SysMenu menu:menus){
                MenuVo m=new MenuVo();
                m.setId(menu.getId());
                m.setPid(menu.getPid());
                m.setTitle(menu.getTitle());
                m.setIcon(menu.getIcon());
                m.setHref(menu.getHref());
                m.setStatus(menu.getStatus());
                nodes.add(m);
            }
        }
        return new DataGridView(nodes);
    }
}
