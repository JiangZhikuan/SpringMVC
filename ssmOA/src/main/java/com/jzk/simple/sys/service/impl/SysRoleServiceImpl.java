package com.jzk.simple.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jzk.simple.sys.constast.SysConstast;
import com.jzk.simple.sys.domain.SysMenu;
import com.jzk.simple.sys.domain.SysRole;
import com.jzk.simple.sys.mapper.SysMenuMapper;
import com.jzk.simple.sys.mapper.SysRoleMapper;
import com.jzk.simple.sys.service.SysRoleService;
import com.jzk.simple.sys.utils.DataGridView;
import com.jzk.simple.sys.vo.MenuVo;
import com.jzk.simple.sys.vo.SysMenuVo;
import com.jzk.simple.sys.vo.SysRoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName:SysRoleServiceImpl
 * Package:com.jzk.simple.sys.service.impl
 * Description:
 *
 * @Date:2020/4/27 15:36
 * @Author:JiangZhikuan
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysMenuMapper sysMenuMapper;

    /**
     * @param sysRoleVo
     * @return com.jzk.simple.sys.utils.DataGridView
     * @author:JiangZhikuan
     * @Description: 查询所有角色
     * @date: 2020/5/7 17:14
     */
    @Override
    public DataGridView queryAllRole(SysRoleVo sysRoleVo) {
        Page<Object> page= PageHelper.startPage(sysRoleVo.getPage(),sysRoleVo.getLimit());
        List<SysRole> data=this.sysRoleMapper.queryAllSysRole(sysRoleVo);
        return new DataGridView(page.getTotal(),data);
    }

    /**
     * @param sysRoleVo
     * @return void
     * @author:JiangZhikuan
     * @Description: 增加角色
     * @date: 2020/5/7 17:15
     */
    @Override
    public void addRole(SysRoleVo sysRoleVo) {
        this.sysRoleMapper.insertSelective(sysRoleVo);
    }

    /**
     * @param sysRoleVo 
     * @return void
     * @author:JiangZhikuan
     * @Description: 修改角色
     * @date: 2020/5/7 17:15
     */
    @Override
    public void updateRole(SysRoleVo sysRoleVo) {
        this.sysRoleMapper.updateByPrimaryKeySelective(sysRoleVo);
    }

    /**
     * @param roleid
     * @return void
     * @author:JiangZhikuan
     * @Description: 删除角色
     * @date: 2020/5/7 17:15
     */
    @Override
    public void deleteRole(Integer roleid) {
        this.sysRoleMapper.deleteByPrimaryKey(roleid);
        this.sysRoleMapper.deleteRoleMenuByRid(roleid);
        this.sysRoleMapper.deleteRoleUserByRid(roleid);
    }

    /**
     * @param ids
     * @return void
     * @author:JiangZhikuan
     * @Description: 批量删除角色
     * @date: 2020/5/7 17:16
     */
    @Override
    public void deleteBatchRole(Integer[] ids) {
        for (Integer id:ids){
            deleteRole(id);
        }
    }

    /**
     * @param roleid
     * @return com.jzk.simple.sys.utils.DataGridView
     * @author:JiangZhikuan
     * @Description: 根据角色id初始化菜单树
     * @date: 2020/5/7 17:16
     */
    @Override
    public DataGridView initRoleMenuTreeJson(Integer roleid) {
        SysMenuVo sysMenuVo=new SysMenuVo();
        sysMenuVo.setStatus(SysConstast.AVAILABLE_TRUE);
        List<SysMenu> menuList=this.sysMenuMapper.findAllMenu(sysMenuVo);

        //查看当前角色所拥有的菜单
        List<SysMenu> roleMenus=this.sysMenuMapper.queryMenuByRoleId(SysConstast.AVAILABLE_TRUE,roleid);

        List<MenuVo> menuInfo=new ArrayList<>();
        for (SysMenu e:menuList){
            String checkArr=SysConstast.CODE_ZERO+"";
            for (SysMenu sysMenu:roleMenus){
                if(e.getId().equals(sysMenu.getId())){
                    checkArr=SysConstast.CODE_ONE+"";
                    break;
                }
            }
            MenuVo menuVo=new MenuVo();
            menuVo.setId(e.getId());
            menuVo.setPid(e.getPid());
            menuVo.setHref(e.getHref());
            menuVo.setTitle(e.getTitle());
            menuVo.setIcon(e.getIcon());
            menuVo.setTarget(e.getTarget());
            menuVo.setStatus(e.getStatus());
            menuVo.setCheckArr(checkArr);
            menuInfo.add(menuVo);
        }
        return new DataGridView(menuInfo);
    }

    @Override
    public void saveRoleMenu(SysRoleVo sysRoleVo) {
        Integer rid=sysRoleVo.getRoleid();
        Integer[] mids=sysRoleVo.getIds();
        this.sysRoleMapper.deleteRoleMenuByRid(rid);
        for (Integer mid:mids){
            this.sysRoleMapper.insertRoleMenu(rid,mid);
        }
    }
}
