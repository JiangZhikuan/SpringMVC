package com.jzk.simple.sys.mapper;

import com.jzk.simple.sys.domain.SysUser;
import com.jzk.simple.sys.domain.SysUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserMapper {
    long countByExample(SysUserExample example);

    int deleteByExample(SysUserExample example);

    int deleteByPrimaryKey(Integer userid);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    List<SysUser> selectByExample(SysUserExample example);

    SysUser selectByPrimaryKey(Integer userid);

    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    /*
    * 登录
    * */
    SysUser login(SysUser user);

    /*
    * 查询用户
    * */
    List<SysUser> queryAllUser(SysUser sysUser);

    /*
    * 保存用户和角色
    * */
    void insetUserRole(@Param("uid")Integer userId,@Param("rid")Integer roleId);
}