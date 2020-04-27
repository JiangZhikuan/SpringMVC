package com.jzk.simple.sys.service.impl;

import com.jzk.simple.sys.domain.SysMenu;
import com.jzk.simple.sys.mapper.SysMenuMapper;
import com.jzk.simple.sys.service.SysMenuService;
import com.jzk.simple.sys.utils.TreeUtil;
import com.jzk.simple.sys.vo.MenuVo;
import com.jzk.simple.sys.vo.SysMenuVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName:SysMenuServiceImpl
 * Package:com.jzk.simple.sys.service.impl
 * Description:
 *
 * @Date:2020/4/24 12:57
 * @Author:JiangZhikuan
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Resource
    private SysMenuMapper sysMenuMapper;

    /*
    * 界面菜单加载
    * */
    @Override
    public Map<String, Object> menu() {
        SysMenuVo sysMenuVo=new SysMenuVo();
        sysMenuVo.setStatus(true);
        Map<String, Object> map = new HashMap<>();
        List<SysMenu> menuList=sysMenuMapper.findAllMenu(sysMenuVo);
        List<MenuVo> menuInfo=new ArrayList<>();
        for (SysMenu e:menuList){
            MenuVo menuVo=new MenuVo();
            menuVo.setId(e.getId());
            menuVo.setPid(e.getPid());
            menuVo.setHref(e.getHref());
            menuVo.setTitle(e.getTitle());
            menuVo.setIcon(e.getIcon());
            menuVo.setTarget(e.getTarget());
            menuVo.setStatus(e.getStatus());
            menuInfo.add(menuVo);
        }
        map.put("menuInfo", TreeUtil.toTree(menuInfo,0));
        map.put("homeInfo", "{title: '首页',href: '../desk/toDeskManager.action'}");
        map.put("logoInfo", "{title: 'OA管理系统',image: '../resources/images/logo.png'}");
        return map;
    }

    @Override
    public List<SysMenu> findAllMenu(SysMenuVo sysMenuVo) {
        sysMenuVo.setStatus(true);
        return sysMenuMapper.findAllMenu(sysMenuVo);
    }

    @Override
    public void addMenu(SysMenuVo sysMenuVo) {
        this.sysMenuMapper.insertSelective(sysMenuVo);
    }

    @Override
    public void updateMenu(SysMenuVo sysMenuVo) {
        this.sysMenuMapper.updateByPrimaryKeySelective(sysMenuVo);
    }

    @Override
    public Integer queryMenuByPid(Integer pid) {
        return this.sysMenuMapper.queryMenuByPid(pid);
    }

    @Override
    public void deleteMenu(SysMenuVo sysMenuVo) {
        this.sysMenuMapper.deleteByPrimaryKey(sysMenuVo.getId());
        this.sysMenuMapper.deleteRoleMenuByMid(sysMenuVo.getId());
    }

}
