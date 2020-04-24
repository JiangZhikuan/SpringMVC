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
        Map<String,Object> map=sysMenuService.menu();
        List<MenuVo> menuVos=(List<MenuVo>) map.get("menuInfo");
        List<MenuVo> nodes=new ArrayList<>();
        if (menuVos!=null){
            for (MenuVo menuVo:menuVos){
                MenuVo m=new MenuVo();
                m.setId(menuVo.getId());
                m.setPid(menuVo.getPid());
                m.setTitle(menuVo.getTitle());
                m.setIcon(menuVo.getIcon());
                m.setHref(menuVo.getHref());
                m.setStatus(menuVo.getStatus());
                nodes.add(m);
            }
        }
        return new DataGridView(nodes);
    }
}
