package com.jzk.simple.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jzk.simple.sys.domain.SysRole;
import com.jzk.simple.sys.mapper.SysRoleMapper;
import com.jzk.simple.sys.service.SysRoleService;
import com.jzk.simple.sys.utils.DataGridView;
import com.jzk.simple.sys.vo.SysRoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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

    @Override
    public DataGridView queryAllRole(SysRoleVo sysRoleVo) {
        Page<Object> page= PageHelper.startPage(sysRoleVo.getPage(),sysRoleVo.getLimit());
        List<SysRole> data=this.sysRoleMapper.queryAllSysRole(sysRoleVo);
        return new DataGridView(page.getTotal(),data);
    }

    @Override
    public void addRole(SysRoleVo sysRoleVo) {
        this.sysRoleMapper.insertSelective(sysRoleVo);
    }

    @Override
    public void updateRole(SysRoleVo sysRoleVo) {
        this.sysRoleMapper.updateByPrimaryKeySelective(sysRoleVo);
    }

    @Override
    public void deleteRole(Integer roleid) {
        this.sysRoleMapper.deleteByPrimaryKey(roleid);
        this.sysRoleMapper.deleteRoleMenuByRid(roleid);
        this.sysRoleMapper.deleteRoleUserByRid(roleid);
    }

    @Override
    public void deleteBatchRole(Integer[] ids) {
        for (Integer id:ids){
            deleteRole(id);
        }
    }
}
