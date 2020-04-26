package com.jzk.simple.sys.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
@RequestMapping("menu")
public class MenuController {

    @Autowired
    private SysMenuService sysMenuService;

    @ResponseBody
    @GetMapping("loadIndexMenuJson")
    public Map<String,Object> loadIndexMenuJson(){
        return sysMenuService.menu();
    }

    /*
    * 加载菜单管理树
    * */
    @ResponseBody
    @RequestMapping("loadMenuManagerLeftTreeJson")
    public DataGridView loadMenuManagerLeftTreeJson(SysMenuVo sysMenuVo){
        List<SysMenu> menus=sysMenuService.findAllMenu(sysMenuVo);
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


    @ResponseBody
    @RequestMapping("loadAllMenu")
    public DataGridView loadAllMenu(SysMenuVo sysMenuVo){
        sysMenuVo.setStatus(true);
        Page<Object> page= PageHelper.startPage(sysMenuVo.getPage(),sysMenuVo.getLimit());
        List<SysMenu> sysMenus=sysMenuService.findAllMenu(sysMenuVo);
        return new DataGridView(page.getTotal(),sysMenus);
    }
}
