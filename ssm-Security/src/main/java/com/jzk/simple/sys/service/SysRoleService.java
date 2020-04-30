package com.jzk.simple.sys.service;

import com.jzk.simple.sys.utils.DataGridView;
import com.jzk.simple.sys.vo.SysRoleVo;

/**
 * InterfaceName:SysRoleService
 * Package:com.jzk.simple.sys.service
 * Description:
 *
 * @Date:2020/4/27 15:36
 * @Author:JiangZhikuan
 */

public interface SysRoleService {

    //加载角色列表
    DataGridView queryAllRole(SysRoleVo sysRoleVo);

    //添加角色
    void addRole(SysRoleVo sysRoleVo);

    //修改
    void updateRole(SysRoleVo sysRoleVo);

    //删除
    void deleteRole(Integer roleid);

    //批量删除
    void deleteBatchRole(Integer[] ids);

    //加载角色管理分配菜单json
    DataGridView initRoleMenuTreeJson(Integer roleid);

    //保存角色和菜单关系
    void saveRoleMenu(SysRoleVo sysRoleVo);
}
