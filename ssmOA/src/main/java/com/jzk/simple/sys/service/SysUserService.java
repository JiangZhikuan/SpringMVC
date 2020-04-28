package com.jzk.simple.sys.service;

import com.jzk.simple.sys.domain.SysUser;
import com.jzk.simple.sys.utils.DataGridView;
import com.jzk.simple.sys.vo.SysUserVo;

/**
 * interfaceName:SysUserService
 * Package:com.jzk.simple.sys.service
 * Description:
 *
 * @Date:2020/4/22 21:54
 * @Author:JZK
 */

public interface SysUserService {

    SysUser login(SysUserVo sysUserVo);

    /*
    * 查询所有用户
    * */
    DataGridView queryAllUser(SysUserVo sysUserVo);

    /*
    * 添加用户
    * */
    void addUser(SysUserVo sysUserVo);

    /*
    * 修改用户
    * */
    void updateUser(SysUserVo sysUserVo);

    /*
    * 删除用户
    * */
    void deleteUser(Integer userId);

    /*
    * 批量删除
    * */
    void deleteBatchUser(Integer[] ids);

    /*
    * 重置密码
    * */
    void resetUserPwd(Integer userId);

    /*
    * 加载用户管理分配角色
    * */
    DataGridView queryUserRole(Integer userid);

    /*
    * 保存用户和角色关系
    * */
    void saveUserRole(SysUserVo sysUserVo);
}
