package com.jzk.simple.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jzk.simple.sys.constast.SysConstast;
import com.jzk.simple.sys.domain.SysRole;
import com.jzk.simple.sys.domain.SysUser;
import com.jzk.simple.sys.mapper.SysRoleMapper;
import com.jzk.simple.sys.mapper.SysUserMapper;
import com.jzk.simple.sys.service.SysUserService;
import com.jzk.simple.sys.utils.DataGridView;
import com.jzk.simple.sys.vo.SysUserVo;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName:SysUserServiceImpl
 * Package:com.jzk.simple.sys.service.impl
 * Description:
 *
 * @Date:2020/4/22 21:55
 * @Author:JZK
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public SysUser login(SysUserVo sysUserVo) {

        String pwd= DigestUtils.md5DigestAsHex(sysUserVo.getPwd().getBytes());
        sysUserVo.setPwd(pwd);
        return this.sysUserMapper.login(sysUserVo);
    }

    @Override
    public DataGridView queryAllUser(SysUserVo sysUserVo) {
        Page<Object> page=
                PageHelper.startPage(sysUserVo.getPage(),sysUserVo.getLimit());
        List<SysUser> data=this.sysUserMapper.queryAllUser(sysUserVo);
        return new DataGridView(page.getTotal(),data);
    }

    @Override
    public void addUser(SysUserVo sysUserVo) {
        this.sysUserMapper.insertSelective(sysUserVo);
    }

    @Override
    public void updateUser(SysUserVo sysUserVo) {
        this.sysUserMapper.updateByPrimaryKeySelective(sysUserVo);
    }

    @Override
    public void deleteUser(Integer userId) {
        this.sysUserMapper.deleteByPrimaryKey(userId);
        this.sysRoleMapper.deleteRoleUserByUid(userId);
    }

    @Override
    public void deleteBatchUser(Integer[] ids) {
        for (Integer id:ids){
            this.deleteUser(id);
        }
    }

    @Override
    public void resetUserPwd(Integer userId) {
        SysUser sysUser=new SysUser();
        sysUser.setUserid(userId);
        sysUser.setPwd(DigestUtils.md5DigestAsHex(SysConstast.USER_DEFAULT_PWD.getBytes()));
        this.sysUserMapper.updateByPrimaryKeySelective(sysUser);
    }

    @Override
    public DataGridView queryUserRole(Integer userid) {
        SysRole sysRole=new SysRole();
        sysRole.setAvailable(SysConstast.AVAILABLE_ROLE_TRUE);
        List<SysRole> allRole=this.sysRoleMapper.queryAllSysRole(sysRole);
        List<SysRole> userRole=
                this.sysRoleMapper.queryRoleByUid(SysConstast.AVAILABLE_ROLE_TRUE,userid);
        List<Map<String,Object>> data=new ArrayList<>();

        for (SysRole role:allRole){
            Boolean LAY_CHECKD=false;
            for (SysRole r:userRole){
                if(role.getRoleid().equals(r.getRoleid())){
                    LAY_CHECKD=true;
                }
            }
            Map<String,Object> map=new HashMap<>();
            map.put("roleid",role.getRoleid());
            map.put("rolename",role.getRolename());
            map.put("roledesc",role.getRoledesc());
            map.put("LAY_CHECKED",LAY_CHECKD);
            data.add(map);
        }
        return new DataGridView(data);
    }

    @Override
    public void saveUserRole(SysUserVo sysUserVo) {
        Integer userid=sysUserVo.getUserid();
        Integer[] roleIds=sysUserVo.getIds();

        this.sysRoleMapper.deleteRoleUserByUid(userid);
        if(roleIds!=null&&roleIds.length>0){
            for (Integer rid:roleIds){
                this.sysUserMapper.insetUserRole(userid,rid);
            }
        }
    }
}
