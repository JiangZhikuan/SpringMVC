package com.jzk.simple.sys.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jzk.simple.sys.constast.SysConstast;
import com.jzk.simple.sys.domain.SysMenu;
import com.jzk.simple.sys.domain.SysUser;
import com.jzk.simple.sys.service.SysMenuService;
import com.jzk.simple.sys.utils.DataGridView;
import com.jzk.simple.sys.utils.ResultObj;
import com.jzk.simple.sys.utils.WebUtils;
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
 *              Controller:菜单相关
 * @Date:2020/4/24 13:13
 * @Author:JiangZhikuan
 */
@Controller
@RequestMapping("menu")
public class MenuController {

    @Autowired
    private SysMenuService sysMenuService;

    /*
    * 登录初始化功能菜单
    * */
    @ResponseBody
    @GetMapping("loadIndexMenuJson")
    public Map<String,Object> loadIndexMenuJson(SysMenuVo sysMenuVo){
        SysUser sysUser=(SysUser)WebUtils.getHttpSession().getAttribute("user");
        return sysMenuService.menu(SysConstast.AVAILABLE_TRUE,sysUser.getUserid());
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


    /*
    * 加载全部按钮
    * */
    @ResponseBody
    @RequestMapping("loadAllMenu")
    public DataGridView loadAllMenu(SysMenuVo sysMenuVo){
        sysMenuVo.setStatus(true);
        Page<Object> page= PageHelper.startPage(sysMenuVo.getPage(),sysMenuVo.getLimit());
        List<SysMenu> sysMenus=sysMenuService.findAllMenu(sysMenuVo);
        return new DataGridView(page.getTotal(),sysMenus);
    }


    /*
    * 增加按钮
    * */
    @ResponseBody
    @RequestMapping("addMenu")
    public ResultObj addMenu(SysMenuVo sysMenuVo){
        try {
            sysMenuVo.setIcon("fa "+sysMenuVo.getIcon());
            this.sysMenuService.addMenu(sysMenuVo);
            return ResultObj.ADD_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /*
    * 修改按钮
    * */
    @ResponseBody
    @RequestMapping("updateMenu")
    public ResultObj updateMenu(SysMenuVo sysMenuVo){
        try {
            sysMenuVo.setIcon("fa "+sysMenuVo.getIcon());
            this.sysMenuService.updateMenu(sysMenuVo);
            return ResultObj.UPDATE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

    /*
    *判断是否有子节点
    * */
    @ResponseBody
    @RequestMapping("checkMenuHasChildren")
    public ResultObj checkMenuHasChildren(SysMenuVo sysMenuVo){
        Integer count=this.sysMenuService.queryMenuByPid(sysMenuVo.getId());
        return count>0?ResultObj.STATUS_TRUE:ResultObj.STATUS_FALSE;
    }

    /*
    * 删除按钮
    * */
    @ResponseBody
    @RequestMapping("deleteMenu")
    public ResultObj deleteMenu(SysMenuVo sysMenuVo){
        try {
            this.sysMenuService.deleteMenu(sysMenuVo);
            return ResultObj.DELETE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
}
