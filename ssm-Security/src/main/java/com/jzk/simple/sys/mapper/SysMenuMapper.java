package com.jzk.simple.sys.mapper;

import com.jzk.simple.sys.domain.SysMenu;
import com.jzk.simple.sys.domain.SysMenuExample;
import com.jzk.simple.sys.vo.SysMenuVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysMenuMapper {
    long countByExample(SysMenuExample example);

    int deleteByExample(SysMenuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    List<SysMenu> selectByExample(SysMenuExample example);

    SysMenu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysMenu record, @Param("example") SysMenuExample example);

    int updateByExample(@Param("record") SysMenu record, @Param("example") SysMenuExample example);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);

    List<SysMenu> findAllMenu(SysMenuVo sysMenuVo);

    Integer queryMenuByPid(Integer pid);

    void deleteRoleMenuByMid(Integer id);

    List<SysMenu> queryMenuByRoleId(@Param("status") Boolean status,@Param("roleId") Integer roleId);

    List<SysMenu> queryMenuByUid(@Param("status") Boolean available,@Param("uid")Integer userId);

}