package com.jzk.simple.sys.mapper;

import com.jzk.simple.sys.domain.SysRole;
import com.jzk.simple.sys.domain.SysRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRoleMapper {
    long countByExample(SysRoleExample example);

    int deleteByExample(SysRoleExample example);

    int deleteByPrimaryKey(Integer roleid);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    List<SysRole> selectByExample(SysRoleExample example);

    SysRole selectByPrimaryKey(Integer roleid);

    int updateByExampleSelective(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    int updateByExample(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

    List<SysRole> queryAllSysRole(SysRole sysRole);

    void deleteRoleMenuByRid(Integer roleId);

    void deleteRoleUserByRid(Integer roleId);

    void insertRoleMenu(@Param("rid")Integer rid,@Param("mid")Integer mid);

    /*
    * 根据用户id删除sys_role_user
    * */
    void deleteRoleUserByUid(Integer userId);

    List<SysRole> queryRoleByUid(@Param("available")Integer available,@Param("uid")Integer userId);
}