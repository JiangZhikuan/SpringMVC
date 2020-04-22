package com.jzk.simple.sys.service.impl;

import com.jzk.simple.sys.domain.SysUser;
import com.jzk.simple.sys.mapper.SysUserMapper;
import com.jzk.simple.sys.service.SysUserService;
import com.jzk.simple.sys.vo.SysUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

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

    @Override
    public SysUser login(SysUserVo sysUserVo) {

        String pwd= DigestUtils.md5DigestAsHex(sysUserVo.getPwd().getBytes());
        sysUserVo.setPwd(pwd);
        return sysUserMapper.login(sysUserVo);
    }
}
